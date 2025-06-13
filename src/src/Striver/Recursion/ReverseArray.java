package src.Striver.Recursion;

import java.util.Arrays;

public class ReverseArray {
    //REVERSE FUNCTION WITH LEFT AND RIGH POINTERS
    public static void reverse(int[] arr,int left,int right)
    {
        if (left >= right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverse(arr,left+1,right-1);
    }
    //REVERSE FUNCTION WITH SINGLE VARIABLE
    public static void reverse1(int[] arr,int i)
    {
        int n = arr.length;
        if (i >= n/2) return;
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        reverse1(arr,i+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6};
        System.out.println(Arrays.toString(arr));
//        reverse(arr,0,arr.length-1);
        reverse1(arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
