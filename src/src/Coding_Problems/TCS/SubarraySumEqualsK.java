package src.Coding_Problems.TCS;

import java.util.Arrays;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static int[] findsubarrayequalsK(int[] nums, int k)
    {
        int left=0,sum=0;
        for (int right=0; right<nums.length; right++)
        {
            sum += nums[right];
//            System.out.println(sum);

            while (sum > k && left <= right)
            {
                sum -= nums[left];
                left+=1;
            }
            System.out.println("sum "+sum+" k "+k);
            if(sum==k)
            {
                return Arrays.copyOfRange(nums,left,right+1);
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = findsubarrayequalsK(arr,k);
        System.out.println(Arrays.toString(result));
    }
}
