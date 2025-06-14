package src.ZohoSecondRoundRecent;

import java.util.PriorityQueue;

public class FindKthSmallestElement {

    public static void main(String[] args) {

        int[] arr = {2,4,5,6,6,7,5};
        System.out.println(findkthsmallest(arr,5));

    }

    private static int findkthsmallest(int[] arr, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n: arr)
        {
            minHeap.add(n);
        }
        for (int i=0; i<k-1; i++)
        {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
