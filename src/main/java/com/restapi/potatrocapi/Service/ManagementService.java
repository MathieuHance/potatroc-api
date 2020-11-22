package com.restapi.potatrocapi.Service;

import com.restapi.potatrocapi.model.ManagementToken;
import com.restapi.potatrocapi.model.UserAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Service
public class ManagementService {

    @Value("${auth0.management.url}")
    private String management_url;

    @Value("${auth0.management.client_id}")
    private String client_id;

    @Value("${auth0.management.client_secret}")
    private String client_secret;

    @Value("${auth0.management.audience}")
    private String audience;

    @Value("${auth0.management.grant_type}")
    private String grant_type;

    @Value("${auth0.api.url}")
    private String auth0_api_url;


    private final RestTemplate restTemplate;

    public ManagementService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ManagementToken getManagementToken() {

        String url = this.management_url;

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // create a map for post parameters
        Map<String, Object> map = new HashMap<>();

        map.put("grant_type", this.grant_type);
        map.put("audience", this.audience);
        map.put("client_secret", this.client_secret);
        map.put("client_id", this.client_id);
        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<ManagementToken> response = this.restTemplate.postForEntity(url, entity, ManagementToken.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    public UserAuth getUserMail(String id) {
        String url = this.management_url;
        String token = "";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // create a map for post parameters
        Map<String, Object> map = new HashMap<>();

        map.put("grant_type", this.grant_type);
        map.put("audience", this.audience);
        map.put("client_secret", this.client_secret);
        map.put("client_id", this.client_id);
        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<ManagementToken> response = this.restTemplate.postForEntity(url, entity, ManagementToken.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            token = response.getBody().getAccess_token();
        } else {
            token="";
        }
        System.out.println(token);
        String url_auth = this.auth0_api_url + "users/{id}?fields=email&include_fields=true";
        // create headers
        HttpHeaders headers2 = new HttpHeaders();
        // set `accept` header
        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set custom header
        headers2.set("Authorization", "Bearer "+ token);
        // build the request
        HttpEntity request2 = new HttpEntity(headers2);
        ResponseEntity<UserAuth> response2 = this.restTemplate.exchange(url_auth, HttpMethod.GET, request2, UserAuth.class, id);
        if(response2.getStatusCode() == HttpStatus.OK) {
            return response2.getBody();
        } else {
            return null;
        }
    }
}
