package com.egobob.movk.config;

import com.egobob.movk.downloader.PictureDownloader;
import com.egobob.movk.downloader.StubPictureDownloader;
import com.egobob.movk.urlprovider.StubUrlProviler;
import com.egobob.movk.urlprovider.UrlProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.egobob.movk.downloader", "com.egobob.movk.urlprovider", "com.egobob.movk.authorization"})
@PropertySource(value = {"classpath:authorization.properties"})
public class BaseConfig {
}
