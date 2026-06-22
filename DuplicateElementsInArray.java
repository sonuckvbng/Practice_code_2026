import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElementsInArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 2, 5, 3, 6};

        //Using for each and HashSet
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for(int n : arr){
            if(!set.add(n)){
                duplicate.add(n);
            }
        }

        System.out.println("Duplicate Elements In Array using for loop ans HashSet :" + duplicate);


        //Using Stream API and HashSet
            /*❌ This does NOT work properly for primitive array
                int[] arr = {1, 2, 3};
                 List<int[]> list = Arrays.asList(arr);
                 Because int[] is treated as single object.
             */
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        List<Integer> duplicateNum = list.stream().filter(ar -> !set2.add(ar))
                .toList();

        System.out.println("Duplicate Elements In Array using Stream api and HashSet :" + duplicateNum);

        // Arrays.stream(arr) gives:IntStream
        // .boxed() converts: int -> Integer
        /*
        Array Type	        Conversion
        Integer[]	        Arrays.asList(arr)
        int[]	            Arrays.stream(arr).boxed().toList()
         */
    }
}
