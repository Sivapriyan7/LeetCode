package src.ZohoSecondRoundRecent;

import src.Coding_Problems.PBL.wipro.ExceptionHandling.ArrayAccess;

import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {5, 1}, {1, 2}};

//        Arrays.sort(arr, (a, b) -> {
//            if (a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            } else {
//                return Integer.compare(a[1], b[1]);
//            }
//        });

        Arrays.sort(arr, Comparator.comparingInt((int[] a)->a[0])
                .thenComparingInt(a ->a[1]));


        // Print the sorted array
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
