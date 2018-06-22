package com.egobob.namegenerator.culture.name.firstname;

import com.egobob.namegenerator.culture.name.NameGenerator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FirstNameGenerator extends NameGenerator {

    // TODO: move to resources
    private String firstNameFileEnding = "firstnames.csv";

    @Override
    protected String generateFilePath(String resourceUsed) {
        return BASE_FILE_PATH + resourceUsed + "/" + firstNameFileEnding;
    }

}
