package aoc.days;

import aoc.utils.FileUtils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Day implements AdventDay {

    private String inputFileName;
    private String name;
    private List<String> input = new ArrayList<>();
    private Object result;

    public Day() {
        Matcher m = Pattern.compile("aoc.days.aoc_(?<year>\\d+).Day(?<day>\\d+)(?<part>[a-b])").matcher(this.getClass().getName());
        if (m.matches()) {
            String year = m.group("year");
            String day = m.group("day");
            this.inputFileName = "%s%s%s.txt".formatted(year, File.separator, day.replaceFirst("^0", ""));
            this.name = "%s-%s%s".formatted(year, day, m.group("part"));
        } else {
            throw new RuntimeException("Wrong package, class name combination");
        }
        this.prepareInput();
    }

    protected Day(List<String> input) {
        input.forEach(this::addToInput);
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    protected void prepareInput() {
        FileUtils fileUtils = new FileUtils();
        InputStream inputStream = fileUtils.getFileFromResourceAsStream(this.inputFileName);
        fileUtils.prepareInput(inputStream, this);
    }

    public void addToInput(String line) {
        this.input.add(line);
    }

    public List<String> getInput() {
        return this.input;
    }

    public ArrayList<String> getInputLineSplitBySingleCharacters() {
        if (this.input.size() == 1) {
            return new ArrayList<>(List.of(this.input.get(0).split("")));
        }
        throw new UnsupportedOperationException("Input doesn't have exactly one line");
    }

    public String getName() {
        return name;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }
}
