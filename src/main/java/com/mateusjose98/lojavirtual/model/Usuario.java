package com.mateusjose98.lojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String login;
    private String senha;
    private LocalDate dataUltimaAtualizacaoSenha;
    @ManyToMany
    @JoinTable(name = "usuario_acesso",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "acesso_id"))
    private Set<Acesso> acessos = new HashSet<>();

    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa empresa;

    @PreUpdate
    @PrePersist
    void preUpdate() {
        this.dataUltimaAtualizacaoSenha = LocalDate.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return acessos;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void updatePassword(PasswordEncoder passwordEncoder, String newPassword) {
        this.setDataUltimaAtualizacaoSenha(LocalDate.now());
        this.setSenha(passwordEncoder.encode(newPassword));
    }

    public Usuario from(String rawPass, String senha, Pessoa pessoa) {
        this.login = rawPass;
        this.senha = senha;
        this.pessoa = pessoa;
        return this;
    }
}
