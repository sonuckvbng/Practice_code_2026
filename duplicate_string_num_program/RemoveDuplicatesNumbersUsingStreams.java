package duplicate_string_num_program;

import java.util.*;

public class RemoveDuplicatesNumbersUsingStreams {

    public static void main(String[] args) {
        List<Integer> listOfNumber = Arrays.asList(1,2,2,3,3,4,5,7,7,8,8,10);

        //Using distinct() ------------------------------------------------------------------
        List<Integer> removedDuplicateNum =
                listOfNumber.stream()
                        .distinct()
                        .toList();
        System.out.println("removed duplicate num using distinct() : " + removedDuplicateNum);

        //Using Set -------------------------------------------------------------------------

        Set<Integer> set = new LinkedHashSet<>(listOfNumber); // linkedHashSet used because it maintain order and remove duplicate
        List<Integer> unique = new ArrayList<>(set);

        System.out.println("removed duplicate num using SET : " +unique);
    }
}

/*
Method	        Duplicate Removal	Order Maintained
distinct()	    Yes	                Yes
HashSet	        Yes	                No
LinkedHashSet	Yes,	            Yes
*/
