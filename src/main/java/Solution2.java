/**
 * Problem statement: Given an int array, remove all the duplicates and shift the empty
 * spaces towards the end of the array. Algorithm should operate in place.
 * Constraints:
 * 1. The order of the integers should be retained according to their first occurrecnes
 */

public class Solution2 {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 3, 2, 4, 2, 3, 2, 1};



        int lastFound = arr[0];

        int currPos = 1;
        for (int i = 1; i < arr.length; ++i) {
            int num = arr[i];
            if (lastFound != num) {
                lastFound = num;
                arr[currPos++] = num;
                arr[i]=-1;
            }
        }



    }


    public static int[] input() {

        return new int[2];
    }
}