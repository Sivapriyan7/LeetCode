package src.ZohoSecondRoundRecent;

public class UniqueElement {

    public static void main(String[] args) {
        int[] arr = {1,  2,2,4,4,6,6};
        System.out.println(findUniqueElement(arr));

    }
    private static int findUniqueElement(int[] arr)
    {
        int sum = 0;
        for (int n : arr)
        {
            sum = sum ^ n;
        }
        return sum;
    }
}
