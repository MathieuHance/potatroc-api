package com.restapi.potatrocapi.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class tokenInfo {

    public String getUserSub () {
        String claims = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
            Jwt jwt = JwtHelper.decode(token);
            claims = jwt.getClaims();
        }


        JsonObject data = new Gson().fromJson(claims, JsonObject.class);
        String sub =   data.get("sub").getAsString();
        return sub;
    }
}
