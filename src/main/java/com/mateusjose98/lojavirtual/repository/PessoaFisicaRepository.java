package com.mateusjose98.lojavirtual.repository;

import com.mateusjose98.lojavirtual.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>, JpaSpecificationExecutor<PessoaFisica> {
    boolean existsByCpf(String cpf);
}