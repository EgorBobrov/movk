package com.egobob.namegenerator.culture.name;

import com.egobob.namegenerator.culture.name.firstname.FirstNameGenerator;
import com.egobob.namegenerator.culture.name.lastname.LastNameGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class NameGenerator {

    protected static final String BASE_FILE_PATH = "";

    protected Integer averageNameLength;

    protected Set<String> startSyllables = new HashSet<>();

    protected Set<String> bodySyllables = new HashSet<>();

    protected Set<String> endSyllables = new HashSet<>();

    public String generateName(String resourceUsed) {
        loadResource(resourceUsed);
        return startSyllables.stream().skip((int) (startSyllables.size() * Math.random()))
                .findFirst().get() +
                bodySyllables.stream().skip((int) (bodySyllables.size() * Math.random()))
                        .findFirst().get() +
                endSyllables.stream().skip((int) (endSyllables.size() * Math.random()))
                        .findFirst().get();
    }

    private void loadResource(String resourceUsed) {
        BufferedReader br  = new BufferedReader(
                        new InputStreamReader(this.getClass().getClassLoader()
                    .getResourceAsStream(generateFilePath(resourceUsed))));

        List<String> names = br.lines().map(String::toLowerCase).collect(Collectors.toList());
        averageNameLength = names.stream().mapToInt(String::length).sum() / names.size();

        names.forEach(s -> {
            if (s.length() < 3) {
                startSyllables.add(s);
                return;
            }
            int beginBorder = System.currentTimeMillis() % 2 == 0 ? 2 : 3;
            int endBorder = s.length() - beginBorder;
            if (beginBorder > endBorder) {
                endBorder = beginBorder;
                beginBorder = s.length() - 2;
            }
            try {
                startSyllables.add(s.substring(0, 1).toUpperCase() +
                        s.substring(1, beginBorder));
                bodySyllables.add(s.substring(beginBorder, endBorder));
                endSyllables.add(s.substring(endBorder));

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Causing error: " + s);
            }
        });
    }

    protected abstract String generateFilePath(String resourceUsed);

    public static void main(String[] args) throws IOException {
        NameGenerator fng = new FirstNameGenerator();
        NameGenerator lng = new LastNameGenerator();
        String resource = "american";
        System.out.println(fng.generateName(resource));
        System.out.println(lng.generateName(resource));
    }

}
