/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

/**
 *
 * @author wbpat
 */
@Component
public class JwtKeyProvider {
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        // Generar una clave segura para HS256
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String getEncodedSecretKey() {
        return Base64.getEncoder().encodeToString(this.secretKey.getEncoded());
    }
}
