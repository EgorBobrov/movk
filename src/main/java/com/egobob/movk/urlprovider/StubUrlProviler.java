package com.egobob.movk.urlprovider;

import org.springframework.stereotype.Component;

@Component
public class StubUrlProviler implements UrlProvider {
    @Override
    public String getUrl() {
        return "http://www.m.vk.com/ololorium";
    }
}
