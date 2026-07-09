import java.util.Arrays;

public class MoveZerosToRightWithoutNewArray {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 4, 0, 5};

       int zeroCount = moveZerosRight(arr);
        System.out.println(Arrays.toString(arr) + "\nZero count is : " + zeroCount);
    }

    private static int moveZerosRight(int[] arr) {

        int write =0;

        for(int i =0 ; i< arr.length; i++){
           if(arr[i]!=0){
               arr[write++] = arr[i];

           }
        }
        int countZero = arr.length - write;

        while(write < arr.length){
            arr[write++] = 0;
        }

        return countZero;
    }


}
