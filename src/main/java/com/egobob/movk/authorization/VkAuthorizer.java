package com.egobob.movk.authorization;

import com.vk.api.sdk.client.actors.UserActor;

public interface VkAuthorizer {
    UserActor autorizeUser();
}
