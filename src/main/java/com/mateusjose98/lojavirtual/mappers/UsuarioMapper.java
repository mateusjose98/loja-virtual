package com.mateusjose98.lojavirtual.mappers;

import com.mateusjose98.lojavirtual.model.Usuario;
import com.mateusjose98.lojavirtual.model.UsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {


    public Usuario toEntity(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setLogin(dto.getLogin());
        return usuario;
    }

}
