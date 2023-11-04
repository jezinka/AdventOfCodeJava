package aoc.days.aoc_2016;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04b extends Day04a {

    public Day04b() {
        super();
    }

    public Day04b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Room> rooms = new ArrayList<>();
        for (String instruction : this.getInput()) {
            Matcher groups = Pattern.compile("(?<name>[a-z\\-]+)-(?<id>\\d+)\\[(?<checksum>\\w+)\\]").matcher(instruction);
            if (groups.matches()) {
                String name = groups.group("name");
                String checksum = groups.group("checksum");

                if (getChecksum(name).equals(checksum)) {
                    int id = Integer.parseInt(groups.group("id"));
                    rooms.add(new Room(id, name));
                }
            }
        }

        rooms.stream()
                .filter(room -> room.getDecryptedName().contains("northpole"))
                .findFirst()
                .ifPresent(roomWithStaff -> setResult(roomWithStaff.id));
    }


    public record Room(Integer id, String name) {

        public String getDecryptedName() {
            int offset = id % 26;
            StringBuilder decrypted = new StringBuilder();
            for (char letter : name.toCharArray()) {
                if (letter == '-') {
                    decrypted.append(" ");
                } else {
                    decrypted.append(moveLetter(letter, offset));
                }
            }
            return decrypted.toString();
        }

        private char moveLetter(char letter, int offset) {
            int i = ((int) letter) + offset;
            if (i > (int) 'z') {
                i -= 26;
            }
            return (char) i;
        }
    }
}
