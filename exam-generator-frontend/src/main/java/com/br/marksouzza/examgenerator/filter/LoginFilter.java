package com.br.marksouzza.examgenerator.filter;

import com.br.marksouzza.examgenerator.util.TokenUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebFilter(urlPatterns = {"/*"}, description = "Session checker filter")
public class LoginFilter implements Filter, Serializable {
    @Inject
    private TokenUtil tokenUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (!request.getRequestURI().endsWith("login.xhtml") && !isTokenValid(request)) {
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
            return;
        }
        chain.doFilter(request, response);
    }
    
    private boolean isTokenValid(HttpServletRequest request){
        return tokenUtil.isExpirationTimeFromCookieValid(request) && !tokenUtil.getTokenFromCookies(request).isEmpty();
    }
}
