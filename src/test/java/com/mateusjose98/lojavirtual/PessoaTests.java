package com.mateusjose98.lojavirtual;

import com.mateusjose98.lojavirtual.model.Pessoa;
import com.mateusjose98.lojavirtual.model.PessoaFisica;
import com.mateusjose98.lojavirtual.model.PessoaJuridica;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
@ActiveProfiles({"nosecurity"})
public class PessoaTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Deve criar pessoaJuridica para dados válidos")
    void criarPJ() {
        PessoaJuridica pessoa = new PessoaJuridica();
        pessoa.setCnpj("9009009" + new Random().nextInt(1, 100));
        pessoa.setEmail("jose" + new Random().nextInt(1, 50) + ".teste@"+ Arrays.asList("gmail", "hotmail", "bol", "yahoo").get( new Random().nextInt(0, 4)) +".com");
        pessoa.setInscricaoEstadual("972");
        pessoa.setNome("Casarão Tech " + new Random().nextInt(1, 100));
        pessoa.setTelefone("9899989898");
        HttpEntity<Pessoa> entity = new HttpEntity<>(pessoa);
        var response = testRestTemplate.exchange("/pessoas/pj", HttpMethod.POST, entity, PessoaJuridica.class);
        log.info(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Deve criar pessoaJuridica para dados válidos")
    void criarPF() {
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setCpf("5009009" + new Random().nextInt(1, 100));
        pessoa.setEmail("maria" + new Random().nextInt(1, 50) + ".teste@"+ Arrays.asList( "hotmail", "bol", "yahoo").get( new Random().nextInt(0, 4)) +".com");
        pessoa.setNome("Letícia Ramos " + new Random().nextInt(1, 100));
        pessoa.setTelefone("7783123423");
        HttpEntity<Pessoa> entity = new HttpEntity<>(pessoa);
        var response = testRestTemplate.exchange("/pessoas/pf", HttpMethod.POST, entity, PessoaFisica.class);
        log.info(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
