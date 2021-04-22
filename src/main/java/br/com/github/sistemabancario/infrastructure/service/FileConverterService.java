package br.com.github.sistemabancario.infrastructure.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import br.com.github.sistemabancario.application.service.exception.FileSizeException;
import br.com.github.sistemabancario.application.service.exception.InvalidoMimeTypeException;
import br.com.github.sistemabancario.domain.service.AnexoService;
import br.com.github.sistemabancario.domain.shared.Anexo;
import br.com.github.sistemabancario.infrastructure.service.exception.ConverterException;
import br.com.github.sistemabancario.presentation.dto.shared.AnexoRequestTO;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

@Service
public class FileConverterService {

    private static final String PDF = "application/pdf";
    private static final String PNG = "image/png";
    private static final String JPEG = "image/jpeg";
    private static final String JPG = "image/jpg";
    private static final long CINCO_KB = 5;
    private static final long CINCO_MB = 5000000;

    @Autowired
    private AnexoService anexoService;

    public Anexo decode(AnexoRequestTO anexoTO) {
        byte[] fileByte = Base64Utils.decodeFromString(anexoTO.getUrl().replaceAll("^.+?(;base64),", ""));
        String filePath = getFilePath(anexoTO);
        File serverFile = getServerFile(filePath);
        try {
            FileUtils.writeByteArrayToFile(serverFile, fileByte);
           
            Anexo anexo = new Anexo(anexoTO.getNome(), anexoTO.getUrl(), anexoTO.getFormato());
            return anexoService.salvar(anexo);
        } catch (IOException e) {
            throw new ConverterException(e);
        }

    }

    private File getServerFile(String filePath) {
        return new File(filePath);
    }

	public String encode(br.com.github.sistemabancario.domain.shared.Anexo anexo) {
		try {
			byte[] encoded = null;
			encoded = Base64Utils.encode(FileUtils.readFileToByteArray(new File(anexo.getCaminho())));
			return new String(encoded, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new ConverterException(e);
		}

	}

    private String getFilePath(AnexoRequestTO anexoTO) {
        LocalDateTime today = LocalDateTime.now();
        return String.format("%s/%s/%s/%s/%s_%s.%s", anexoTO.getUrl(), today.getYear(),
                today.getMonthValue(), today.getDayOfMonth(),
                today.atZone(ZoneId.of("America/Buenos_Aires")).toInstant().toEpochMilli(), anexoTO.getNome(),
                anexoTO.getFormato());
    }

    public void validarAnexoRequestTO(List<AnexoRequestTO> anexosTO) {
        if (anexosTO == null || anexosTO.isEmpty()) {
            return;
        }

        for (AnexoRequestTO anexoTO : anexosTO) {
            if (anexoTO == null) {
                continue;
            }
            byte[] fileByte = Base64Utils.decodeFromString(anexoTO.getUrl().replaceAll("^.+?(;base64),", ""));
            String filePath = getFilePath(anexoTO);
            File serverFile = getServerFile(filePath);
            try {
                FileUtils.writeByteArrayToFile(serverFile, fileByte);

                long sizeOf = FileUtils.sizeOf(serverFile);
                if (sizeOf < CINCO_KB || sizeOf > CINCO_MB) {
                    throw new FileSizeException();
                }

                String mimeType = getMimeType(serverFile);
                if (Boolean.FALSE.equals(acceptedHeaders(mimeType))) {
                    throw new InvalidoMimeTypeException();
                }
            } catch (IOException e) {
                throw new ConverterException(e);
            } finally {
                FileUtils.deleteQuietly(serverFile);
            }
        }
    }

    private String getMimeType(File file) {
        String mimeType = "";
        try {
            mimeType = Magic.getMagicMatch(file, false).getMimeType();
        } catch (MagicParseException | MagicMatchNotFoundException | MagicException e) {
            throw new InvalidoMimeTypeException();
        }

        return mimeType;
    }

    private boolean acceptedHeaders(String mimeType) {
        return mimeType.equals(PDF) || mimeType.equals(PNG) || mimeType.equals(JPEG) || mimeType.equals(JPG);
    }

}
