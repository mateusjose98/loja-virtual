package com.mateusjose98.lojavirtual.service;

import com.mateusjose98.lojavirtual.model.*;
import com.mateusjose98.lojavirtual.repository.PessoaFisicaRepository;
import com.mateusjose98.lojavirtual.repository.PessoaJuridicaRepository;
import com.mateusjose98.lojavirtual.service.enums.EmailType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class PessoaService {

    final PessoaJuridicaRepository pessoaJuridicaRepository;
    final UsuarioService usuarioService;
    final PasswordEncoder passwordEncoder;
    final EmailService emailService;
    final PessoaFisicaRepository pessoaFisicaRepository;

    public Pessoa criarPj(PessoaJuridica pessoa) {
        pessoa = pessoaJuridicaRepository.save(pessoa);
        UsuarioDTO usuarioDTO = usuarioService.findByPessoa(pessoa.getId());
        if(usuarioDTO == null) {
            createUserWithDefaultPassword(pessoa);
        }
        return pessoa;
    }

    private void createUserWithDefaultPassword(Pessoa pessoa) {
        String rawPass = pessoa instanceof PessoaFisica ? ((PessoaFisica) pessoa).getCpf() : ((PessoaJuridica) pessoa).getCnpj();
        String senha = passwordEncoder.encode(rawPass);
        usuarioService.criar(new Usuario().from(rawPass,
                senha, pessoa));
        emailService.enviar(pessoa.getEmail(), Map.of("senha", senha), EmailType.PASSWORD_CREATED);
    }

    public boolean existsByCnpj(String cnpj) {
        return pessoaJuridicaRepository.existsByCnpj(cnpj);
    }

    public boolean existsByCpf(String cpf) {
        return pessoaFisicaRepository.existsByCpf(cpf);
    }

    public Pessoa criarPf(PessoaFisica pessoa) {
        pessoa = pessoaFisicaRepository.save(pessoa);
        UsuarioDTO usuarioDTO = usuarioService.findByPessoa(pessoa.getId());
        if(usuarioDTO == null) {
            createUserWithDefaultPassword(pessoa);
        }
        return pessoa;
    }
}
