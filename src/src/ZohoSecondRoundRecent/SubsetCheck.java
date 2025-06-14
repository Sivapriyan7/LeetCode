package src.ZohoSecondRoundRecent;

public class SubsetCheck {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,5,6,7,8,11,12};
        int[] arr2 = {3,4,5,8,9,10};
        System.out.println(findSubset(arr1,arr2));
    }

    private static boolean findSubset(int[] arr1, int[] arr2)
    {
        int p1 = 0;
        int p2 = 0;
        while (p1 < arr1.length && p2 < arr2.length)
        {
            if(arr1[p1] < arr2[p2]){
                p1++;
            }
            else if (arr1[p1]==arr2[p2])
            {
                p1++;
                p2++;
            }
            else {
                return false;
            }
        }
        if(p2 <= arr2.length){
            return false;
        }
        return true;
    }
}
