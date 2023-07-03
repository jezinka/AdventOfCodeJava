package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.List;

import static aoc.utils.HashAlgUtils.findMD5HashStartingWith;


public class Day04b extends Day {

    public Day04b() {
        super("4.txt");
    }

    public Day04b(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-04b";
    }

    @Override
    public void resolve() {
        String password = this.getInput().get(0);
        this.setResult(findMD5HashStartingWith(password, "000000"));
    }
}
