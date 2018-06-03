package com.egobob.movk;

import com.egobob.movk.authorization.VkAuthorizer;
import com.egobob.movk.authorization.VkAuthorizerImpl;
import com.egobob.movk.config.BaseConfig;
import com.egobob.movk.downloader.PictureDownloader;
import com.egobob.movk.downloader.StubPictureDownloader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Movk {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);
        VkAuthorizer authorizer = context.getBean("vkAuthorizer", VkAuthorizerImpl.class);
        authorizer.autorizeUser();
        PictureDownloader downloader = context.getBean("pictureDownloader", StubPictureDownloader.class);
        downloader.downloadPictures();
    }
}
