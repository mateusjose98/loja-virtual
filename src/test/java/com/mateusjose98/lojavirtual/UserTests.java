package com.mateusjose98.lojavirtual;

import com.mateusjose98.lojavirtual.model.Acesso;
import com.mateusjose98.lojavirtual.model.Usuario;
import com.mateusjose98.lojavirtual.model.UsuarioDTO;
import com.mateusjose98.lojavirtual.repository.AcessoRepository;
import com.mateusjose98.lojavirtual.repository.UsuarioRepository;
import com.mateusjose98.lojavirtual.service.JWTTokenService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
public class UserTests {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AcessoRepository acessoRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTTokenService tokenService;

    private Long idUsuario;
    private Long idAcesso;
    private Long idAdmin;
    private Long idAcessoAdmin;
    private String validUserToken;
    private String validAdminToken;

    @BeforeEach
    void setup() {
        log.info("### Adicionando usuários ##");
        usuarioRepository.findByLogin("admin").ifPresentOrElse(usuario -> {
            idAdmin = usuario.getId();
            idAcessoAdmin = usuario.getAcessos().stream().findFirst().get().getId();
                }, () -> {
                    Acesso acesso = new Acesso();
                    acesso.setDescricao("ROLE_ADMIN");
                    acesso = acessoRepository.save(acesso);
            idAcessoAdmin = acesso.getId();
                    Usuario usuario = new Usuario();
                    usuario.setLogin("admin");
                    usuario.setSenha(bCryptPasswordEncoder.encode("123"));
                    usuario.setAcessos(Set.of(acesso));
                    usuario = usuarioRepository.save(usuario);
            idAdmin = usuario.getId();
                }
        );
        validAdminToken = tokenService.generateTokens("admin").get(0);
        usuarioRepository.findByLogin("usuario").ifPresentOrElse(usuario -> {
                    idUsuario = usuario.getId();
                    idAcesso = usuario.getAcessos().stream().findFirst().get().getId();
                }, () -> {
                    Acesso acesso = new Acesso();
                    acesso.setDescricao("ROLE_USER");
                    acesso = acessoRepository.save(acesso);
                    idAcesso = acesso.getId();
                    Usuario usuario = new Usuario();
                    usuario.setLogin("usuario");
                    usuario.setSenha(bCryptPasswordEncoder.encode("123"));
                    usuario.setAcessos(Set.of(acesso));
                    usuario = usuarioRepository.save(usuario);
                    idUsuario = usuario.getId();
                }
        );
        validUserToken = tokenService.generateTokens("usuario").get(0);
    }

    @AfterEach
    void cleaUp() {
        log.info("### LIMPANDO ##");
        if( idUsuario != null && idAcesso != null) {
            usuarioRepository.deleteById(idUsuario);
            acessoRepository.deleteById(idAcesso);
        }
        if( idAdmin != null && idAcessoAdmin != null) {
            usuarioRepository.deleteById(idAdmin);
            acessoRepository.deleteById(idAcessoAdmin);
        }

    }

    @Test
    @DisplayName("Deve cadastrar um usuário com sucesso")
    void cadastroTest() {
        UsuarioDTO novoUsuario = new UsuarioDTO();
        novoUsuario.setLogin("gabriel" + UUID.randomUUID());
        novoUsuario.setSenha(bCryptPasswordEncoder.encode("123"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + validAdminToken);
        HttpEntity<UsuarioDTO> httpEntity = new HttpEntity<>(novoUsuario, headers);
        ResponseEntity<UsuarioDTO> response = this.testRestTemplate.exchange("/usuarios", HttpMethod.POST, httpEntity, UsuarioDTO.class);

        log.info(response);
        UsuarioDTO body = response.getBody();
        assertNotNull(body);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(body.getId());
    }

    @Test
    @DisplayName("Deve FALHAR ao cadastrar usuário")
    void cadastroTestFail() {
        UsuarioDTO novoUsuario = new UsuarioDTO();
        novoUsuario.setLogin("gabriel");
        novoUsuario.setSenha(bCryptPasswordEncoder.encode("123"));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + validUserToken);
        HttpEntity<UsuarioDTO> httpEntity = new HttpEntity<>(novoUsuario, headers);
        ResponseEntity<UsuarioDTO> response = this.testRestTemplate.exchange("/usuarios", HttpMethod.POST, httpEntity, UsuarioDTO.class);

        log.info(response);
        UsuarioDTO body = response.getBody();
        assertNull(body);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }





}
