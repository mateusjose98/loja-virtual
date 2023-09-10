package com.mateusjose98.lojavirtual.service;

import java.util.List;

public interface JWTTokenService {


    boolean isTokenValid(String token);
    List<String> generateRefreshToken(String token);
    String getSubject(String tokenJWT);
    List<String> generateTokens(String username);
}
