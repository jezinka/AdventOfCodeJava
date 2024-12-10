package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Day09b extends Day {

    public Day09b() {
        super();
    }

    public Day09b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        HashMap<Integer, Integer> empty = new HashMap<>(); // startIndex -> length
        HashMap<Integer, List<Integer>> files = new HashMap<>(); // fileId -> startIndex, length

        var diskMap = getInput().get(0);
        List<Integer> list = Arrays.stream(diskMap.split("")).map(Integer::parseInt).toList();

        int index = 0;
        int fileId = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                files.put(fileId, List.of(index, list.get(i)));
                fileId++;
            } else {
                empty.put(index, list.get(i));
            }
            index += list.get(i);
        }
        for (int i = fileId - 1; i >= 0; i--) {
            List<Integer> entry = files.get(i);
            AtomicReference<Integer> emUsed = new AtomicReference<>();
            List<Map.Entry<Integer, Integer>> toSort = new ArrayList<>(empty.entrySet());
            toSort.sort(Map.Entry.comparingByKey());
            for (Map.Entry<Integer, Integer> em : toSort) {
                if (entry.get(1) <= em.getValue() && em.getValue() < entry.get(0)) {
                    emUsed.set(em.getKey());
                    files.put(i, List.of(em.getKey(), entry.get(1)));
                    if (em.getValue() - entry.get(1) > 0)
                        empty.put(em.getKey() + entry.get(1), em.getValue() - entry.get(1));
                    break;
                }
            }
            empty.remove(emUsed.get());
        }
        files.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(entry -> {

        });

        Integer[] unZipped = new Integer[index + 1];

        files.entrySet().forEach((entry) -> {
            for (int i = 0; i < entry.getValue().get(1); i++) {
                unZipped[entry.getValue().get(0) + i] = entry.getKey();
            }
        });

        long checksum = 0;
        for (int i = 0; i < unZipped.length; i++) {
            Integer onlyFile = unZipped[i];
            if (onlyFile != null)
                checksum += (long) onlyFile * i;
        }

        //8583576817788
        setResult(checksum);
    }
}
