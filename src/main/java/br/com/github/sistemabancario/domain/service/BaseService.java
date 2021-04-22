package br.com.github.sistemabancario.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.github.sistemabancario.domain.shared.BaseEntity;


public interface BaseService<T extends BaseEntity> {
    public T salvar(T entidade);

    public T atualizar(Long id, T entity);

    public Long contar();

    public List<T> listar();

    public Page<T> listar(Specification<T> specification, Pageable pageable);
    
    public List<T> listar(Specification<T> specification);

    public T buscar(Long id);

    public void remover(Long id);
    
    public T alternaAtivo(Long id);

}
