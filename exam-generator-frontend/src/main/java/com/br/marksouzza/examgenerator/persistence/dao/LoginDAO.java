package com.br.marksouzza.examgenerator.persistence.dao;

import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public class LoginDAO implements Serializable {
    private final String BASE_URL ="http://localhost:8081/login";
    private final RestTemplate restTemplate;

    public LoginDAO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
