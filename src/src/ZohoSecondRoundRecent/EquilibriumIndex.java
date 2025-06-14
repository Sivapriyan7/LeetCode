package src.ZohoSecondRoundRecent;

import java.util.Arrays;

public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] arr = {3,4,9,6,1};
        System.out.println(findEquilibriumIndex(arr));
    }

    private static int findEquilibriumIndex(int[] arr)
    {
        int leftsum = 0;
        int totalsum = Arrays.stream(arr).sum();

        for (int i=0; i<arr.length; i++)
        {
            totalsum -= arr[i];
            if(leftsum==totalsum)
            {
                return i;
            }
            leftsum += arr[i];
        }
        return -1;
    }
}
