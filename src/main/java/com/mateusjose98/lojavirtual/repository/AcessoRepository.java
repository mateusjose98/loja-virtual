package com.mateusjose98.lojavirtual.repository;

import com.mateusjose98.lojavirtual.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long>, JpaSpecificationExecutor<Acesso> {
}