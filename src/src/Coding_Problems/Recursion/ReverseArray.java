package src.Coding_Problems.Recursion;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr,int start,int end)
    {
        if(start<end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverse(arr,start+1,end-1);
        }
    }
}
