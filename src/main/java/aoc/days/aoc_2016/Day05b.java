package aoc.days.aoc_2016;

import aoc.days.Day;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day05b extends Day {

    public Day05b() {
        super();
    }

    public Day05b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        String input = this.getInput().get(0);
        long counter = 0;

        String[] password = new String[8];
        while (Arrays.stream(password).anyMatch(Objects::isNull)) {
            String md5Hex = DigestUtils.md5Hex(input + counter);
            if (md5Hex.startsWith("00000")) {
                String positionS = md5Hex.substring(5, 6);
                if (StringUtils.isNumeric(positionS)) {
                    int position = Integer.parseInt(positionS);
                    if (position < 8 && position >= 0 && password[position] == null) {
                        String passwordChunk = md5Hex.substring(6, 7);
                        password[position] = passwordChunk;
                    }
                }
            }
            counter++;
        }
        setResult(StringUtils.join(password, ""));
    }
}
