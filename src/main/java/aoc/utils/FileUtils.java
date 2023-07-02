package aoc.utils;

import aoc.days.AdventDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public InputStream getFileFromResourceAsStream(String inputFileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(inputFileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + inputFileName);
        } else {
            return inputStream;
        }
    }

    public void prepareInput(InputStream is, AdventDay day) {

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                day.addToInput(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
