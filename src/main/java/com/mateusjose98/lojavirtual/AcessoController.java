package com.mateusjose98.lojavirtual;

import com.mateusjose98.lojavirtual.model.Acesso;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acessos")
@RequiredArgsConstructor
public class AcessoController {

    final AcessoService acessoService;

    @PostMapping
    public void salvar(@RequestBody Acesso acesso) {
        acessoService.cadastrar(acesso);
    }
}
