package aoc.days;

public interface AdventDay {

    void resolve();

    Object getResult();

    void addToInput(String line);

    String getName();
}
