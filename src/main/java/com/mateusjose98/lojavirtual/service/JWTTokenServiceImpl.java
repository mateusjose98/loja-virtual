package com.mateusjose98.lojavirtual.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mateusjose98.lojavirtual.util.DateUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Log4j2
public class JWTTokenServiceImpl implements JWTTokenService {

    @Value(
            "${secretKey}"
    )
    private String secretKey;

    @Value(
            "${spring.application.name}"
    )
    private String appName;

    public List<String> generateTokens(String username) {

        String accessToken = generateToken(username,DateUtils.instantAfter(30) );
        String refreshToken = generateToken(username, DateUtils.instantAfter(40 ));

        return List.of(accessToken, refreshToken);
    }

    public String generateToken(String username, Instant expiresAt) {
        log.info("Gerando token para usuário {}", username);

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer(appName)
                    .withSubject(username)
                    .withClaim("chave", "dados extras(perfil, roels, etc)")
                    .withExpiresAt(
                            expiresAt
                    )
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            log.error("Erro ao gerar token para usuário {}", username);
            throw new RuntimeException("Erro ao gerar token para usuário {}");
        }

    }

    @Override
    public boolean isTokenValid(String token) {

        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm =  Algorithm.HMAC256(secretKey);
            JWTVerifier verifier =JWT.require(Algorithm.HMAC256(secretKey))
                    .withIssuer(appName)
                    .build();

            decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            log.error("{}", exception.getMessage());
        }
        return false;
    }

    @Override
    public List<String> generateRefreshToken(String token) {
        return this.generateTokens(getSubject(token));
    }

    public String getSubject(String tokenJWT) {
        try {
            return JWT.require(Algorithm.HMAC256(secretKey))
                    .withIssuer(appName)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
