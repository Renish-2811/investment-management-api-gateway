package com.example.api_gateway.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.ServerLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Component
public class KeycloakLogoutHandler implements ServerLogoutHandler {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakLogoutHandler.class);


    private final RestTemplate restTemplate;


    public KeycloakLogoutHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    private void logoutFromKeycloak(OidcUser user) {
        String endSessionEndpoint = user.getIssuer() + "/protocol/openid-connect/logout";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(endSessionEndpoint)
                .queryParam("id_token_hint", user.getIdToken().getTokenValue());

        ResponseEntity<String> logoutResponse = restTemplate.getForEntity(
                builder.toUriString(), String.class);
        if (logoutResponse.getStatusCode().is2xxSuccessful()) {
            logger.info("Successfully logged out from Keycloak");
        } else {
            logger.error("Could not propagate logout to Keycloak");
        }
    }

    @Override
    public Mono<Void> logout(WebFilterExchange exchange, Authentication authentication) {
        return Mono.empty();
    }
}