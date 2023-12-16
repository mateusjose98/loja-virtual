package com.mateusjose98.lojavirtual.repository;

import com.mateusjose98.lojavirtual.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    @EntityGraph(attributePaths = "acessos")
    Optional<Usuario> findByLogin(String login);


    @Query("SELECT u FROM Usuario u WHERE u.pessoa.id = ?1")
    Usuario findByPessoa(Long id);

    @Transactional
    @Modifying
    @Query(
            value = """
            insert into usuario_acesso(usuario_id, acesso_id) values(?1, (select id from acesso where descricao = 'ROLE_USER'))
            """, nativeQuery = true)
    void adicionaAcessoAUser(Long id);
}