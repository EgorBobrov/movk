package com.egobob.movk.config;

import com.egobob.movk.downloader.PictureDownloader;
import com.egobob.movk.downloader.StubPictureDownloader;
import com.egobob.movk.urlprovider.StubUrlProviler;
import com.egobob.movk.urlprovider.UrlProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean
    public UrlProvider urlProvider() {
        return new StubUrlProviler();
    }

    @Bean
    public PictureDownloader pictureDownloader(){
        PictureDownloader downloader = new StubPictureDownloader(urlProvider());
        return downloader;
    }
}
