package com.br.marksouzza.examgenerator.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.faces.annotation.RequestCookieMap;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import java.util.Map;

import static com.br.marksouzza.examgenerator.custom.CustomURLEncoderDecoder.decodeUTF8;

public class JsonUtil {
    @Inject
    @RequestCookieMap
    private Map<String, Object> cookieMap;

    public HttpHeaders createJsonHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return header;
    }

    public HttpHeaders createTokenizedHeader() {
        HttpHeaders header = createJsonHeader();
        Cookie tokenCookie = (Cookie) cookieMap.get("token");
        header.add("Authorization", decodeUTF8(tokenCookie.getValue()));
        return header;
    }

}
