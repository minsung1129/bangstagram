package com.bangstagram.user.configure.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "oauth.naver")
public class NaverProperty {
    @Value("${oauth.naver.clientId}")
    private String naverClientId;

    @Value("${oauth.naver.clientSecret}")
    private String naverClientSecret;

    @Value("${oauth.naver.tokenRequestUrl}")
    private String naverTokenRequestUrl;

    @Value("${oauth.naver.profileRequestUrl}")
    private String naverProfileRequestUrl;
}
