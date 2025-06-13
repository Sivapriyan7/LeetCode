package src.ZohoSecondRoundRecent;

import java.util.Arrays;

public class EvenSubarrayPartitionSum {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int index = 1;
        while(index < nums.length)
        {
            int leftsum = Arrays.stream(nums,0,index).sum();
            int rightsum = Arrays.stream(nums, index,nums.length).sum();
            index++;
            System.out.println("leftsum "+leftsum+" rightsum "+rightsum);
            int diff = leftsum-rightsum;
            if(diff%2==0)
            {
                System.out.println(diff);
            }

        }
    }
}
