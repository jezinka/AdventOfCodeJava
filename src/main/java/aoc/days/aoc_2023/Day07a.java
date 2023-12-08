package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class Day07a extends Day {

    public Day07a() {
        super();
    }

    public Day07a(List<String> input) {
        super(input);
    }

    static Map<String, Integer> cardValues = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("A", 14),
            new AbstractMap.SimpleEntry<>("K", 13),
            new AbstractMap.SimpleEntry<>("Q", 12),
            new AbstractMap.SimpleEntry<>("J", 11),
            new AbstractMap.SimpleEntry<>("T", 10),
            new AbstractMap.SimpleEntry<>("9", 9),
            new AbstractMap.SimpleEntry<>("8", 8),
            new AbstractMap.SimpleEntry<>("7", 7),
            new AbstractMap.SimpleEntry<>("6", 6),
            new AbstractMap.SimpleEntry<>("5", 5),
            new AbstractMap.SimpleEntry<>("4", 4),
            new AbstractMap.SimpleEntry<>("3", 3),
            new AbstractMap.SimpleEntry<>("2", 2));


    @Override
    public void resolve() {
        List<Hand> hands = new ArrayList<>();
        for (String line : getInput()) {
            String[] s = line.split(" ");
            Hand hand = new Hand(s[0], Integer.parseInt(s[1]));
            hands.add(hand);
        }

        int result = 0;
        List<Hand> list = hands.stream().sorted(reverseOrder()).toList();
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).bid * (list.size() - i);
        }
        setResult(result);
    }

    static class Hand implements Comparable {

        private final String cards;
        private final Integer bid;

        public Hand(String cards, Integer bid) {
            this.cards = cards;
            this.bid = bid;
        }

        public Hand(String cards, int bid) {
            this.cards = cards;
            this.bid = bid;
        }

        @Override
        public String toString() {
            return cards;
        }

        public String getCards() {
            return cards;
        }

        public Integer getBid() {
            return bid;
        }

        int getType() {
            String cardsForType = this instanceof Day07b.Hand7b ? ((Day07b.Hand7b) this).getEvaluateJokers() : this.cards;

            var groups = Arrays.stream(cardsForType.split(""))
                    .collect(Collectors.groupingBy(Function.identity()))
                    .entrySet();

            if (groups.size() == 1) {
                return 7;
            }
            if (groups.size() == 2 && groups.stream().anyMatch(e -> e.getValue().size() == 4)) {
                return 6;
            }
            if (groups.size() == 2 && groups.stream().anyMatch(e -> e.getValue().size() == 3)) {
                return 5;
            }
            if (groups.size() == 3 && groups.stream().anyMatch(e -> e.getValue().size() == 1) && groups.stream().anyMatch(e -> e.getValue().size() == 3)) {
                return 4;
            }
            if (groups.size() == 3 && groups.stream().anyMatch(e -> e.getValue().size() == 2) && groups.stream().anyMatch(e -> e.getValue().size() == 2)) {
                return 3;
            }
            if (groups.size() == 4 && groups.stream().anyMatch(e -> e.getValue().size() == 2)) {
                return 2;
            }
            return 1;
        }

        @Override
        public int compareTo(Object o) {
            Hand anotherHand = (Hand) o;
            if (this.getType() > anotherHand.getType()) {
                return 1;
            }
            if (this.getType() < anotherHand.getType()) {
                return -1;
            }
            return compareByCards(anotherHand);
        }

        int compareByCards(Hand anotherHand) {
            String[] cards = this.cards.split("");
            String[] anotherCards = anotherHand.cards.split("");
            int value = 0;
            for (int i = 0; i < cards.length; i++) {
                if (!cards[i].equals(anotherCards[i])) {
                    value = this.getCardValues().get(cards[i]).compareTo(this.getCardValues().get(anotherCards[i]));
                    break;
                }
            }
            return value;
        }

        public Map<String, Integer> getCardValues() {
            return Day07a.cardValues;
        }
    }
}

