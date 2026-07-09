package basic_concept_program;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeros(int[] arr) { // Method to move all zeros to end of array
        int index = 0; // Pointer to track position for next non-zero element

        for (int i = 0; i < arr.length; i++) { // Iterate through the entire array
            if (arr[i] != 0) { // If current element is non-zero
                int temp = arr[index]; // Swap current element with element at index position
                arr[index] = arr[i]; // Place non-zero element at index position
                arr[i] = temp; // Move zero (or other element) to current position
                index++; // Move index pointer forward
            }
        }
        // After loop: all non-zero elements at front, zeros at end
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12}; // Input array with zeros

        System.out.println("Original array: " + Arrays.toString(arr)); // Print original array

        moveZeros(arr); // Call method to move zeros to end

        System.out.println("After moving zeros: " + Arrays.toString(arr)); // Print result: [1, 3, 12, 0, 0]
    }
}
// Time Complexity: O(n) - Single pass through the array
// Space Complexity: O(1) - No extra space used, only a few variables
