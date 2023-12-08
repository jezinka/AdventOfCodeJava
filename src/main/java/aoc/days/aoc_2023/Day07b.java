package aoc.days.aoc_2023;

import aoc.days.Day;
import aoc.days.aoc_2023.Day07a.Hand;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public class Day07b extends Day {

    public Day07b() {
        super();
    }

    public Day07b(List<String> input) {
        super(input);
    }

    static Map<String, Integer> cardValues = Map.ofEntries(new AbstractMap.SimpleEntry<>("A", 13), new AbstractMap.SimpleEntry<>("K", 12), new AbstractMap.SimpleEntry<>("Q", 11), new AbstractMap.SimpleEntry<>("T", 10), new AbstractMap.SimpleEntry<>("9", 9), new AbstractMap.SimpleEntry<>("8", 8), new AbstractMap.SimpleEntry<>("7", 7), new AbstractMap.SimpleEntry<>("6", 6), new AbstractMap.SimpleEntry<>("5", 5), new AbstractMap.SimpleEntry<>("4", 4), new AbstractMap.SimpleEntry<>("3", 3), new AbstractMap.SimpleEntry<>("2", 2), new AbstractMap.SimpleEntry<>("J", 1));

    @Override
    public void resolve() {
        List<Hand7b> hands = new ArrayList<>();
        for (String line : getInput()) {
            String[] s = line.split(" ");
            Hand7b hand = new Hand7b(s[0], Integer.parseInt(s[1]), s[0]);

            if (hand.getCards().contains("J")) {
                List<String> possibleJokers = List.of(hand.getCards());
                while (possibleJokers.stream().anyMatch(h -> h.contains("J"))) {
                    possibleJokers = getPossibleJokers(possibleJokers);
                }

                List<Hand7b> js = possibleJokers.stream().map(j -> new Hand7b(hand, j)).toList();

                Optional<Hand7b> highest = js.stream().max(naturalOrder());
                highest.ifPresent(hands::add);
            } else {
                hands.add(hand);
            }
        }

        int result = 0;
        List<Hand7b> list = hands.stream().sorted(reverseOrder()).toList();
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getBid() * (list.size() - i);
        }
        setResult(result);
    }

    private List<String> getPossibleJokers(List<String> cards) {
        List<String> possibleJokers = new ArrayList<>();
        List<String> replacementWithoutJ = cardValues.keySet().stream().filter(k -> !k.equals("J")).toList();
        for (String card : cards.stream().filter(c -> c.contains("J")).toList()) {
            for (String rep : replacementWithoutJ) {
                possibleJokers.add(card.replaceFirst("J", rep));
            }
        }
        return possibleJokers;
    }

    public static class Hand7b extends Hand {

        private final String evaluateJokers;

        public Hand7b(Hand hand, String evaluateJokers) {
            super(hand.getCards(), hand.getBid());
            this.evaluateJokers = evaluateJokers;
        }

        public Hand7b(String cards, Integer bid, String evaluateJokers) {
            super(cards, bid);
            this.evaluateJokers = evaluateJokers;
        }

        @Override
        public Map<String, Integer> getCardValues() {
            return Day07b.cardValues;
        }

        public String getEvaluateJokers() {
            return evaluateJokers;
        }
    }
}
