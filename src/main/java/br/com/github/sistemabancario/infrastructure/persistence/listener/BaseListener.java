package br.com.github.sistemabancario.infrastructure.persistence.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.github.sistemabancario.domain.shared.BaseEntity;

public class BaseListener {

    @PrePersist
    public void onPrePersist(BaseEntity genericEntity) {
        genericEntity.setDataCriacao(LocalDateTime.now());
        genericEntity.setAtivo(true);
    }

    @PreUpdate
    public void onPreUpdate(BaseEntity genericEntity) {
        genericEntity.setDataAtualizacao(LocalDateTime.now());
    }
}
