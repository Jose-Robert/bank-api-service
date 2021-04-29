package br.com.github.sistemabancario.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.sistemabancario.domain.model.Pais;
import br.com.github.sistemabancario.domain.service.PaisService;
import br.com.github.sistemabancario.infrastructure.service.ConverterService;
import br.com.github.sistemabancario.infrastructure.service.ResponseServiceImpl;
import br.com.github.sistemabancario.presentation.ResponseTO;
import br.com.github.sistemabancario.presentation.dto.shared.PaisResponseTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/paises")
public class PaisRest {
	
	@Autowired
	private PaisService paisService;

	@Autowired
	private ConverterService converterService;

	@Autowired
	private ResponseServiceImpl responseService;
	
	@ApiOperation(value = "Retorna o Paises pelo nome")
	@GetMapping("/buscar-por-nomePt/{nomePt}")
	public ResponseEntity<ResponseTO<List<PaisResponseTO>>> buscarPorNomePt(@PathVariable String nomePt) {
		List<Pais> paises = paisService.buscarPorNomePt(nomePt);
		List<PaisResponseTO> paisesResponse = converterService.convert(paises, PaisResponseTO.class);
		return responseService.ok(paisesResponse);
	}
	
	@ApiOperation(value = "Retorna o Pais pela Sigla")
	@GetMapping("/buscar-por-sigla/{sigla}")
	public ResponseEntity<ResponseTO<List<PaisResponseTO>>> buscarPorSigla(@PathVariable String sigla) {
		List<Pais> paises = paisService.buscarPorSigla(sigla);
		List<PaisResponseTO> paisesResponse = converterService.convert(paises, PaisResponseTO.class);
		return responseService.ok(paisesResponse);
	}
}
