package src.ZohoSecondRoundRecent;

import java.util.HashMap;
import java.util.Map;

public class TargetSumPair {
    public static void main(String[] args) {
        int[] arr = {11,15,6,8,9,10};
        int target = 21;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++)
        {
            int diff = target-arr[i];
            if(map.containsKey(diff))
            {
                int firstval = target-diff;
                System.out.println("["+firstval+","+diff+"]");
                return;
            }
            map.put(arr[i],i);
        }
    }
}
