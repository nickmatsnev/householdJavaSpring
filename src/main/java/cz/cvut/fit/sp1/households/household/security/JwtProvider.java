package cz.cvut.fit.sp1.households.household.security;


import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static cz.cvut.fit.sp1.households.household.security.Constants.JWT_SECRET;
import static javax.crypto.Cipher.SECRET_KEY;

public class JwtProvider {
    public static String createJWT(UserEntity entity, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWT_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", entity.getUserId());
        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setSubject(entity.getEmail())
                .setClaims(claims)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(JWT_SECRET))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static int getUserIdFromHeader(String header) {
        String jwt = header.substring(7);
        Claims claims = decodeJWT(jwt);
        return claims.get("userId", Integer.class);
    }

    public static String getSubject(Claims claims) {
        return claims.getSubject();
    }

    public static String getId(Claims claims) {
        return claims.getId();
    }

    public static Date getIssuedAt(Claims claims) {
        return claims.getIssuedAt();
    }

    public static String getIssuer(Claims claims) {
        return claims.getIssuer();
    }

    public static Date getExpiration(Claims claims) {
        return claims.getExpiration();
    }

    public static String getAudience(Claims claims) {
        return claims.getAudience();
    }

    public static Date getNotBefore(Claims claims) {
        return claims.getNotBefore();
    }

}
