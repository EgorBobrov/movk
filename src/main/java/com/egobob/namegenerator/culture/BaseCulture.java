package com.egobob.namegenerator.culture;

import com.egobob.namegenerator.culture.name.firstname.FirstNameGenerator;
import com.egobob.namegenerator.culture.name.lastname.LastNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseCulture implements Culture {

    @Autowired
    private FirstNameGenerator firstNameGenerator;

    @Autowired
    private LastNameGenerator lastNameGenerator;

    @Override
    public String generateFirstName(String cultureName) {
        return firstNameGenerator.generateName(cultureName);
    }

    @Override
    public String generateLastName(String cultureName) {
        return lastNameGenerator.generateName(cultureName);
    }
}
