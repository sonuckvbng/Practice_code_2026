package basic_concept_program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumTargetNonRepeating {
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 1, 15, 3, 6, 8};
        int target = 9;

        List<Integer> n = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    n.add(i);
                    n.add(j);
                    System.out.println(n);
                    return;
                }
            }
        }

        // comment onelogic to print one o/p as return is der

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];

            if (map.containsKey(diff)) {
                System.out.println("map : " + map.get(diff) + ":" + i);
                return;
            }

            map.put(arr[i], i);
        }

    }
}
