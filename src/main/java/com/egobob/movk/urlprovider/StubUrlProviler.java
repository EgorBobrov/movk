package com.egobob.movk.urlprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StubUrlProviler implements UrlProvider {

    private String url;

    @Autowired
    @Override
    public void setUrl(@Value("${auth.redirectUrl}") String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
