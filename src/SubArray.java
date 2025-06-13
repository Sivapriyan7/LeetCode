public class SubArray {
    //Given an array arr[], the task is to find the subarray that has the maximum sum and return its sum
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,-3,-6};
        System.out.println(maxSum(arr));
    }
    public static int maxSum(int[] arr)
    {
        int maxSum=arr[0];
        int currentSum = 0;
        for(int i=0; i<arr.length; i++)
        {
            currentSum += arr[i];
            currentSum = currentSum>0?currentSum:0;
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
