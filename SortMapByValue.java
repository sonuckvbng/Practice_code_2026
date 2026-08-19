import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "Apple", 50,
                "Banana", 10,
                "Cherry", 30
        );

        Map<String, Integer> map1=  map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (ov, nv)-> ov,
                        LinkedHashMap::new
                ));
        System.out.println("Hello world!" + map1);
    }
}
