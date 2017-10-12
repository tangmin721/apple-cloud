package com.cachexic.cloud.provider.eshop.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 解析jwt
 * @author tangmin
 * @date 2017-10-12 22:43:07
 */
public class JwtUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * 解析pwt
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
        } catch (Exception ex) {
            LOGGER.error("exception message is: " + ex.getMessage());
            return null;
        }
    }

}
