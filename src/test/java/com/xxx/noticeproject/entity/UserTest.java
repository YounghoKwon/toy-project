package com.xxx.noticeproject.entity;

import com.xxx.noticeproject.repository.DepartmentRepository;
import com.xxx.noticeproject.repository.UserRepository;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConstants;
import java.security.Key;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    DepartmentRepository departmentRepository;

    private static final String SECRET_KEY = "SECRET_KEY_ABCDCDCDCDCDDDFSFSDFSDFDSFDSDDSFDSFSFCD";
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
    Key key = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

    @Test
    @DisplayName("jwt 생성 테스트")
    void create_jwt_test() throws InterruptedException {

        String token = Jwts.builder()
                .setSubject("kwon")
                .signWith(key, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() + 5000L))
                .compact();

        Thread.sleep(5000);
        JwtParser build = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build();

        assertThrows( ExpiredJwtException.class, ()->build.parseClaimsJws(token));


    }

}
