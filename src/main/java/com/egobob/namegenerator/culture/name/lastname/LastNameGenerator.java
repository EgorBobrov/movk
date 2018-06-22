package com.egobob.namegenerator.culture.name.lastname;

import com.egobob.namegenerator.culture.name.NameGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LastNameGenerator extends NameGenerator{

    // TODO: move to resources
    private String lastNameFileEnding = "lastnames.csv";

    @Override
    protected String generateFilePath(String resourceUsed) {
        return BASE_FILE_PATH + resourceUsed + "/" + lastNameFileEnding;
    }

}
