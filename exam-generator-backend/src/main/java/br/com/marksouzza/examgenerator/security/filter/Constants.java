package br.com.marksouzza.examgenerator.security.filter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Constants {
    public static final String SECRET = "secret";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 864000000L; // 1 DAY

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("marksouzza"));
    }


}
