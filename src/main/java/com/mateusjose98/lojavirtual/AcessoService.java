package com.mateusjose98.lojavirtual;

import com.mateusjose98.lojavirtual.model.Acesso;
import com.mateusjose98.lojavirtual.repository.AcessoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class AcessoService {

    final AcessoRepository acessoRepository;

    public Acesso referencia(Long id) {
        return acessoRepository.getReferenceById(id);
    }

    public List<Acesso> listarTodos(){
        return acessoRepository.findAll();
    }

    public void cadastrar(Acesso acesso){
        acessoRepository.save(acesso);
    }
}
