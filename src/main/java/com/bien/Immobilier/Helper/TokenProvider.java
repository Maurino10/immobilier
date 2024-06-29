package com.bien.Immobilier.Helper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bien.Immobilier.Model.Admin;
import com.bien.Immobilier.Model.Client;
import com.bien.Immobilier.Model.Proprietaire;


@Service
public class TokenProvider {

    private String JWT_SECRET = "mqnweudnfcvifgffjkshrolaoeirbvfdaisu1234jhsdkjfgu5489fdaskjhfabfjkasdhjfaskl0784568fd";

    public String generateAccessToken(Object user) {
        String subject = "";
        if (user instanceof Admin) {
            Admin adminObj = (Admin) user;
            subject = adminObj.getLogin()+"=="+adminObj.getPassword();
        } else if (user instanceof Proprietaire) {
            Proprietaire adminObj = (Proprietaire) user;
            subject = String.valueOf(adminObj.getNumero());
        } else {
            Client clientObj = (Client) user;
            subject = clientObj.getEmail();
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.create()
                .withSubject(subject)
                .withExpiresAt(genAccessExpirationDate())
                .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JWTCreationException("Error while generating token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Error while validating token", exception);
        }
    }

    private Instant genAccessExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}