package com.egobob.movk.config;

import com.egobob.movk.downloader.PictureDownloader;
import com.egobob.movk.downloader.StubPictureDownloader;
import com.egobob.movk.urlprovider.StubUrlProviler;
import com.egobob.movk.urlprovider.UrlProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.egobob.movk.downloader", "com.egobob.movk.urlprovider"})
public class BaseConfig {
}
