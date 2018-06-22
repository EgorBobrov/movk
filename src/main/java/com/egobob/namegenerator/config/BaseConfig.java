package com.egobob.namegenerator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.egobob.namegenerator.culture",
        "com.egobob.namegenerator.nameprovider"})
@PropertySource(value = {"classpath:nameprovider.properties"})
public class BaseConfig {
}
