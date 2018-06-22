package com.egobob.namegenerator.nameprovider;

import com.egobob.namegenerator.culture.Culture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NameProviderImpl implements NameProvider {

    @Autowired
    private Culture culture;

    @Override
    public String getName(String cultureName) {
        return culture.generateFirstName(cultureName) + " " + culture.generateLastName(cultureName);
    }
}
