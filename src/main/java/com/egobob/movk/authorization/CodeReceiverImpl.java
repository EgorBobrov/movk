package com.egobob.movk.authorization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class CodeReceiverImpl implements CodeReceiver {

    private static final String AUTH_URL = "https://oauth.vk.com/authorize";
    private static final String DISPLAY = "page";
    private static final String RESPONSE_TYPE = "code";

    @Value("${auth.apiVersion}")
    private String apiVersion;

    @Value("${auth.scope}")
    private String scope;

    @Value("${auth.appId}")
    private String appId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.redirectUrl}")
    private String redirectUrl;

    @Override
    public String getCode() {
        // TODO: receive real code using HTTP and redirect URL
        return "Request for " + redirectUrl + " will be sent by vk api v." + apiVersion +
                " using scope '" + scope + "' by application " + appId;
    }
}
