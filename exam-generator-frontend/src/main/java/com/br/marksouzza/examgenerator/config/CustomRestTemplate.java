package com.br.marksouzza.examgenerator.config;

import org.springframework.web.client.RestTemplate;

/**
 * Without this class the @Inject for RestTemplate will not work.
 */
public class CustomRestTemplate extends RestTemplate {
}
