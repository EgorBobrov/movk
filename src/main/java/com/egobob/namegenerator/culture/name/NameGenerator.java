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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public abstract class NameGenerator {

    protected static final String BASE_FILE_PATH = "";

    protected final Map<String, SyllablesContainer> loadedCultures = new ConcurrentHashMap<>();

    public String generateName(String resourceUsed) {
        loadResource(resourceUsed);
        Set<String> startSyllables = loadedCultures.get(resourceUsed).startSyllables;
        Set<String> bodySyllables = loadedCultures.get(resourceUsed).bodySyllables;
        Set<String> endSyllables = loadedCultures.get(resourceUsed).endSyllables;
        return startSyllables.stream().skip((int) (startSyllables.size() * Math.random()))
                .findFirst().orElse("An") +
                bodySyllables.stream().skip((int) (bodySyllables.size() * Math.random()))
                        .findFirst().orElse("onym") +
                endSyllables.stream().skip((int) (endSyllables.size() * Math.random()))
                        .findFirst().orElse("ous");
    }

    private void loadResource(String resourceUsed) {
        if (loadedCultures.containsKey(resourceUsed)) {
            return;
        }
        loadedCultures.put(resourceUsed,
                new SyllablesContainer(resourceUsed));
    }

    protected abstract String generateFilePath(String resourceUsed);

    private class SyllablesContainer {

        private final String cultureName;

        private final Set<String> startSyllables = new HashSet<>();

        private final Set<String> bodySyllables = new HashSet<>();

        private final Set<String> endSyllables = new HashSet<>();

        private SyllablesContainer(String cultureName){
            this.cultureName = cultureName;
            BufferedReader br  = new BufferedReader(
                    new InputStreamReader(this.getClass().getClassLoader()
                            .getResourceAsStream(generateFilePath(cultureName))));

            List<String> names = br.lines().map(String::toLowerCase).collect(Collectors.toList());

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SyllablesContainer that = (SyllablesContainer) o;
            return Objects.equals(cultureName, that.cultureName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cultureName);
        }
    }

}
