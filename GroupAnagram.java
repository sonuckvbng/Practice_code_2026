import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagram(words));

    }

    private static List<List<String>> groupAnagram(String[] str) {
        if (str.length == 0 || null == str) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new LinkedHashMap<>();
        Map<String, List<String>> map2 = new LinkedHashMap<>();

        for (String s : str) {
            char[] ch = s.toCharArray();

            Arrays.sort(ch);
            String sortedKeyStr = new String(ch);

            map.computeIfAbsent(sortedKeyStr, key -> new ArrayList<>()).add(s);

            map2.putIfAbsent(sortedKeyStr, new ArrayList<>());
            map2.get(sortedKeyStr).add(s);

        }
        System.out.println(map2.values());
        return new ArrayList<>(map.values());
    }
}
