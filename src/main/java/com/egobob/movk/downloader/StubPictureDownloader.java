package com.egobob.movk.downloader;

import com.egobob.movk.urlprovider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pictureDownloader")
public class StubPictureDownloader implements PictureDownloader {

    private UrlProvider urlProvider;

    public StubPictureDownloader() {
    }

    @Autowired
    public StubPictureDownloader(UrlProvider urlProvider) {
        this.urlProvider = urlProvider;
    }

    @Override
    public void downloadPictures() {
        System.out.println(urlProvider.getUrl());
    }

    public UrlProvider getUrlProvider() {
        return urlProvider;
    }

    public void setUrlProvider(UrlProvider urlProvider) {
        this.urlProvider = urlProvider;
    }
}
