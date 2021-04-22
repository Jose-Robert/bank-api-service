package br.com.github.sistemabancario.application.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import br.com.github.sistemabancario.domain.service.AnexoService;
import br.com.github.sistemabancario.domain.shared.Anexo;
import br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository.AnexoRepository;
import br.com.github.sistemabancario.infrastructure.service.exception.ConverterException;

@Service
public class AnexoServiceImpl extends BaseServiceImpl<Anexo, AnexoRepository> implements AnexoService {

    public String buscarArquivo(Long id) {

        Anexo anexo = buscar(id);

        return encode(anexo);
    }

    public String encode(Anexo anexo) {
        try {
            byte[] encoded = null;
            encoded = Base64Utils.encode(FileUtils.readFileToByteArray(new File(anexo.getCaminho())));
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ConverterException(e);
        }

    }
    
    public Anexo getAnexoPorNome(String nome) {
        Optional<Anexo> optional = repository.findByNome(nome);
        return optional.isPresent() ? optional.get() : null;
    }

}
