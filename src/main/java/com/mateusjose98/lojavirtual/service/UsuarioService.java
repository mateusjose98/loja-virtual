package com.mateusjose98.lojavirtual.service;

import com.mateusjose98.lojavirtual.model.Usuario;
import com.mateusjose98.lojavirtual.model.UsuarioDTO;
import com.mateusjose98.lojavirtual.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

public class UsuarioService {

    final UsuarioRepository usuarioRepository;
    final PasswordEncoder passwordEncoder;

    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado " + login));
    }

    public Usuario findByID(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    @Transactional
    public void changePassword(String username, String oldPassword, String newPassword) {
        Usuario usuario = findByLogin(username);
        if(!passwordEncoder.matches(oldPassword, usuario.getPassword())) {
           throw new RuntimeException("Antiga senha não corresponde!");
        }
        usuario.updatePassword(passwordEncoder, newPassword);
    }

    public UsuarioDTO getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return new UsuarioDTO(this.findByLogin(authentication.getName()));
        }
        return null;
    }

    public UsuarioDTO criar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario, "dataUltimaAtualizacaoSenha");
        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }
}
