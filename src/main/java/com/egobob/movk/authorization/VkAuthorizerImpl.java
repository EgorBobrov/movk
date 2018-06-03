package com.egobob.movk.authorization;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("vkAuthorizer")
public class VkAuthorizerImpl implements VkAuthorizer {

    @Value("${auth.appId}")
    private Integer appId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.redirectUrl}")
    private String redirectUrl;

    @Autowired
    CodeReceiver receiver;

    private TransportClient transportClient = HttpTransportClient.getInstance();
    private VkApiClient vk = new VkApiClient(transportClient);

    @Override
    public UserActor autorizeUser() {
        try {
            UserAuthResponse authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(appId, clientSecret, redirectUrl, receiver.getCode())
                    .execute();
            return new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Failed to authorized and get UserActor");
    }
}
