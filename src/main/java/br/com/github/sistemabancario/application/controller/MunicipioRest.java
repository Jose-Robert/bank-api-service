package br.com.github.sistemabancario.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.sistemabancario.domain.model.Municipio;
import br.com.github.sistemabancario.domain.service.MunicipioService;
import br.com.github.sistemabancario.infrastructure.service.ConverterService;
import br.com.github.sistemabancario.infrastructure.service.ResponseServiceImpl;
import br.com.github.sistemabancario.presentation.ResponseTO;
import br.com.github.sistemabancario.presentation.dto.shared.MunicipioResponseTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/municipios")
public class MunicipioRest {

	@Autowired
	private MunicipioService municipioService;

	@Autowired
	private ConverterService converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@ApiOperation(value = "Retorna uma lista de Municipios pelo código IBGE")
	@GetMapping("/buscar-por-codigoIbge/{codigoIbge}")
	public ResponseEntity<ResponseTO<List<MunicipioResponseTO>>> buscarPorCodigoIbge(@PathVariable String codigoIbge) {
		List<Municipio> municipios = municipioService.buscarPorCodigoIbge(codigoIbge);
		List<MunicipioResponseTO> municipiosResponse = converterService.convert(municipios, MunicipioResponseTO.class);
		return responseService.ok(municipiosResponse);
	}

	@ApiOperation(value = "Retorna uma lista de Municipios pelo nome")
	@GetMapping("/buscar-por-nome/{nome}")
	public ResponseEntity<ResponseTO<List<MunicipioResponseTO>>> buscarPorNome(@PathVariable String nome) {
		List<Municipio> municipios = municipioService.buscarPorNome(nome);
		List<MunicipioResponseTO> municipiosResponse = converterService.convert(municipios, MunicipioResponseTO.class);
		return responseService.ok(municipiosResponse);
	}

	@ApiOperation(value = "Retorna uma lista de Municipios pela UF")
	@GetMapping("/buscar-por-uf/{uf}")
	public ResponseEntity<ResponseTO<List<MunicipioResponseTO>>> buscarPorUf(@PathVariable String uf) {
		List<Municipio> municipios = municipioService.buscarPorUf(uf);
		List<MunicipioResponseTO> municipiosResponse = converterService.convert(municipios, MunicipioResponseTO.class);
		return responseService.ok(municipiosResponse);
	}
}
