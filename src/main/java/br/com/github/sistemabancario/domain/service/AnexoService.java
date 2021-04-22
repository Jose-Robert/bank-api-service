package br.com.github.sistemabancario.domain.service;

import br.com.github.sistemabancario.domain.shared.Anexo;

public interface AnexoService extends BaseService<Anexo> {

	public String buscarArquivo(Long id);

	public Anexo getAnexoPorNome(String nome);

}
