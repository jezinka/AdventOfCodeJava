package aoc.days.aoc_2023;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day04b extends Day04a {


    public Day04b() {
        super();
    }

    public Day04b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Map<Integer, Integer> couponsNumber = new HashMap<>();
        int couponId = 1;
        for (String line : getInput()) {

            if (!couponsNumber.containsKey(couponId)) {
                couponsNumber.put(couponId, 1);
            } else {
                couponsNumber.put(couponId, couponsNumber.get(couponId) + 1);
            }

            var intersection = getIntersection(line);

            for (int i = couponId + 1; i < couponId + 1 + intersection.size(); i++) {
                for (int x = 0; x < couponsNumber.get(couponId); x++) {
                    if (couponsNumber.containsKey(i)) {
                        couponsNumber.put(i, couponsNumber.get(i) + 1);
                    } else {
                        couponsNumber.put(i, 1);
                    }
                }
            }

            couponId++;
        }
        setResult(couponsNumber.values().stream().mapToInt(Integer::intValue).sum());
    }
}
