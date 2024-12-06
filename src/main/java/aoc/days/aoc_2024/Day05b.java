package aoc.days.aoc_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day05b extends Day05a {

    public Day05b() {
        super();
    }

    public Day05b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        Map<Integer, List<Integer>> orderOfPages = new HashMap<>();
        ArrayList<List<Integer>> invalidUpdates = new ArrayList<>();
        ArrayList<List<Integer>> reorderUpdates = new ArrayList<>();

        processUpdates(orderOfPages, invalidUpdates);

        for (List<Integer> updates : invalidUpdates) {
            boolean inValidUpdate = true;

            while (inValidUpdate) {
                inValidUpdate = false;
                for (Integer u : updates) {
                    boolean updateChange = false;
                    if (orderOfPages.containsKey(u)) {
                        for (Integer pageBehind : orderOfPages.get(u)) {
                            if (updates.contains(pageBehind) && updates.indexOf(pageBehind) <= updates.indexOf(u)) {
                                List<Integer> copyOfUpdates = updates.stream().collect(Collectors.toList());
                                copyOfUpdates.remove(pageBehind);
                                copyOfUpdates.add(updates.indexOf(u), pageBehind);
                                updates = copyOfUpdates;
                                updateChange = true;
                                inValidUpdate = true;
                                break;
                            }
                        }
                    }
                    if (updateChange) {
                        break;
                    }

                    if (updates.indexOf(u) == updates.size() - 1) {
                        reorderUpdates.add(updates);
                    }
                }
            }
        }

        int sumOfMiddles = getSumOfMiddles(reorderUpdates);
        setResult(sumOfMiddles);
    }

}
