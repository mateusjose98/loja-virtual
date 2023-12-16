package com.mateusjose98.lojavirtual.controller;

import com.mateusjose98.lojavirtual.exceptions.RecursoJaExistente;
import com.mateusjose98.lojavirtual.model.Pessoa;
import com.mateusjose98.lojavirtual.model.PessoaFisica;
import com.mateusjose98.lojavirtual.model.PessoaJuridica;
import com.mateusjose98.lojavirtual.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor
public class PessoaController {

    final PessoaService pessoaService;


    @PostMapping("pj")
    public ResponseEntity<Pessoa> criarPessoaJuridica(@RequestBody PessoaJuridica pessoa) {
        if(pessoa.getId() == null) {
            pessoa.setId(null);
        }
        if(pessoaService.existsByCnpj(pessoa.getCnpj())) {
            throw new RecursoJaExistente(String.format("Pessoa jurídica com o cnpj %s já existe!", pessoa.getCnpj()));
        }

        Pessoa pj = pessoaService.criarPj(pessoa);
        return new ResponseEntity<Pessoa>(pj, HttpStatus.CREATED);
    }


    @PostMapping("pf")
    public ResponseEntity<Pessoa> criarPessoaFisica(@RequestBody PessoaFisica pessoa) {
        if(pessoa.getId() == null) {
            pessoa.setId(null);
        }
        if(pessoaService.existsByCpf(pessoa.getCpf())) {
            throw new RecursoJaExistente(String.format("Pessoa com o cpf %s já existe!", pessoa.getCpf()));
        }

        Pessoa pf = pessoaService.criarPf(pessoa);
        return new ResponseEntity<Pessoa>(pf, HttpStatus.CREATED);
    }
}
