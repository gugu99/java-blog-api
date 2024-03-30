package com.gugu.blog.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt") // 자바 클래스에 프로퍼티값을 가져와서 사용하는 애너테이션 - 프로퍼티에 있는 값을 클래스로 바인딩하기 위해 사용
public class JwtProperties {

    //@Value("${jwt.issuer}") // yml 변수 가져오기 - 단일 값을 주입받기 위해서 사용
    private String issuer;

    //@Value("${jwt.secret_key}")
    private String secretKey;
}
