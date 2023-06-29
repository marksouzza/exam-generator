package com.br.marksouzza.examgenerator.bean.login;

import com.br.marksouzza.examgenerator.persistence.dao.LoginDAO;
import com.br.marksouzza.examgenerator.persistence.model.Token;

import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Named
@ViewScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;
    private final LoginDAO loginDAO;
    private final ExternalContext externalContext;

    @Inject
    public LoginBean(LoginDAO loginDAO, ExternalContext externalContext) {
        this.loginDAO = loginDAO;
        this.externalContext = externalContext;
    }

    public String login() {
        Token token = loginDAO.loginReturningToken("marksouzza", "marksouzza");
        return token == null ? null : addTokenExpirationTimeCookiesAndReturnIndex(token);
    }

    private String addTokenExpirationTimeCookiesAndReturnIndex(Token token) {
        try {
            externalContext.addResponseCookie("token", URLEncoder.encode(token.getToken(), "UTF-8"), null);
            externalContext.addResponseCookie("expirationTime", token.getExpirationTime().toString(), null);
            return "index.xhtml/faces-redirect=true";
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
