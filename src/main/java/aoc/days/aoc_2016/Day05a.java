package aoc.days.aoc_2016;

import aoc.days.Day;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class Day05a extends Day {

    public Day05a() {
        super();
    }

    public Day05a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        String input = this.getInput().get(0);
        long counter = 0;

        String password = "";
        while (password.length() < 8) {
            String md5Hex = DigestUtils.md5Hex(input + counter);
            if (md5Hex.startsWith("00000")) {
                String passwordChunk = md5Hex.substring(5, 6);
                password += passwordChunk;
            }
            counter++;
        }
        setResult(password);
    }
}
