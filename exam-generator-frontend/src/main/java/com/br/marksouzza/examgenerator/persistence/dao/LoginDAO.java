package com.br.marksouzza.examgenerator.persistence.dao;

import com.br.marksouzza.examgenerator.annotation.ExceptionHandler;
import com.br.marksouzza.examgenerator.custom.CustomRestTemplate;
import com.br.marksouzza.examgenerator.persistence.model.support.Token;
import com.br.marksouzza.examgenerator.util.JsonUtil;
import org.springframework.http.*;

import javax.inject.Inject;
import java.io.Serializable;

public class LoginDAO implements Serializable {
    private final String BASE_URL = "http://localhost:8081/login";
    private final CustomRestTemplate restTemplate;
    private final JsonUtil jsonUtil;
    @Inject
    public LoginDAO(CustomRestTemplate restTemplate, JsonUtil jsonUtil) {
        this.restTemplate = restTemplate;
        this.jsonUtil = jsonUtil;
    }

    @ExceptionHandler
    public Token loginReturningToken(String username, String password) {
        String loginJson = "{\"username\":" + addQuotes(username) + ",\"password\":"+addQuotes(password) + "}";
            ResponseEntity<Token> tokenExchange = restTemplate.exchange(BASE_URL, HttpMethod.POST, new HttpEntity<>(loginJson, jsonUtil.createJsonHeader()), Token.class);
            return tokenExchange.getBody();
    }

    private String addQuotes(String value) {
        return new StringBuilder(300).append("\"").append(value).append("\"").toString();
    }

}
