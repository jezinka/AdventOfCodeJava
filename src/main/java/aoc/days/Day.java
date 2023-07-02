package aoc.days;

import aoc.utils.FileUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class Day implements AdventDay {

    private String inputFileName;
    private List<String> input = new ArrayList<>();
    private Object result;

    public Day(String inputFileName) {
        this.inputFileName = inputFileName;
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
        throw new RuntimeException("Day not implemented");
    }
}
