package com.egobob.movk;

import com.egobob.movk.config.BaseConfig;
import com.egobob.movk.downloader.PictureDownloader;
import com.egobob.movk.downloader.StubPictureDownloader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Movk {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);
        PictureDownloader downloader = context.getBean("pictureDownloader", StubPictureDownloader.class);
        downloader.downloadPictures();
    }
}
