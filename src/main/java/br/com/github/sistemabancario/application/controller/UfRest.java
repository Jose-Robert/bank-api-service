package br.com.github.sistemabancario.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.sistemabancario.domain.model.Uf;
import br.com.github.sistemabancario.domain.service.UfService;
import br.com.github.sistemabancario.infrastructure.service.ConverterService;
import br.com.github.sistemabancario.infrastructure.service.ResponseServiceImpl;
import br.com.github.sistemabancario.presentation.ResponseTO;
import br.com.github.sistemabancario.presentation.dto.shared.UfResponseTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/ufs")
public class UfRest {

	@Autowired
	private UfService ufService;

	@Autowired
	private ConverterService converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@ApiOperation(value = "Retorna uma lista de Ufs pelo Código")
	@GetMapping("/buscar-por-codigo-uf/{codigoUf}")
	public ResponseEntity<ResponseTO<List<UfResponseTO>>> buscarPorCodigoUf(@PathVariable Integer codigoUf) {
		List<Uf> ufs = ufService.buscarPorCodigoUf(codigoUf);
		List<UfResponseTO> ufsResponse = converterService.convert(ufs, UfResponseTO.class);
		return responseService.ok(ufsResponse);
	}

	@ApiOperation(value = "Retorna uma lista de Ufs pelo Nome")
	@GetMapping("/buscar-por-nome/{nome}")
	public ResponseEntity<ResponseTO<List<UfResponseTO>>> buscarPorNome(@PathVariable String nome) {
		List<Uf> ufs = ufService.buscarPorNome(nome);
		List<UfResponseTO> ufsResponse = converterService.convert(ufs, UfResponseTO.class);
		return responseService.ok(ufsResponse);
	}

	@ApiOperation(value = "Retorna uma lista de Ufs pela Sigla")
	@GetMapping("/buscar-por-sigla/{sigla}")
	public ResponseEntity<ResponseTO<List<UfResponseTO>>> buscarPorSigla(@PathVariable String sigla) {
		List<Uf> ufs = ufService.buscarPorSigla(sigla);
		List<UfResponseTO> ufsResponse = converterService.convert(ufs, UfResponseTO.class);
		return responseService.ok(ufsResponse);
	}
	
	@ApiOperation(value = "Retorna uma lista de Ufs pela Região")
	@GetMapping("/buscar-por-regiao/{regiao}")
	public ResponseEntity<ResponseTO<List<UfResponseTO>>> buscarPorRegiao(@PathVariable Integer regiao) {
		List<Uf> ufs = ufService.buscarPorRegiao(regiao);
		List<UfResponseTO> ufsResponse = converterService.convert(ufs, UfResponseTO.class);
		return responseService.ok(ufsResponse);
	}

}
