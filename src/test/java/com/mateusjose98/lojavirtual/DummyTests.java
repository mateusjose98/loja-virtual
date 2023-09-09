package com.mateusjose98.lojavirtual;

import com.mateusjose98.lojavirtual.model.Acesso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DummyTests {



    @Autowired
    private AcessoService acessoService;

    @Test
    public void testarCadastro() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_CUSTOMER");
        acessoService.cadastrar(acesso);

    }

}
