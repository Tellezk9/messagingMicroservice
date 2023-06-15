package com.messaging.messagingtwilio.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityManager extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    private final String[] validUrl = {"/swagger-ui/**", "/v3/api-docs/**", "/actuator/health"};
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();

        if (Boolean.TRUE.equals(shouldNotFilter(path))) {
            filterChain.doFilter(request, response);
        } else {
            try {
                String token = getToken(request);
                if (token != null && validateToken(token) && getRoles(token) != null) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
                }
            } catch (Exception ex) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
            }
        }

    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // return everything after "Bearer "
        }
        return null;
    }

    private Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private List<String> getRoles(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        return claims.get("roles", List.class);
    }

    private Boolean shouldNotFilter(String currentUrl) {
        if (currentUrl == null) {
            return false;
        }
        for (String url : this.validUrl) {
            if (pathMatcher.matchStart(url, currentUrl)) {
                return true;
            }
        }
        return false;
    }
}
