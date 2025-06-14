package src.ZohoSecondRoundRecent;

public class minPseudoBinaryCount {
    public static void main(String[] args) {
        int n = 23437;
        System.out.println(findMinPseudobinaryCount(n));
    }

    private static int findMinPseudobinaryCount(int num)
    {
        int count = 0;
        while (num > 0)
        {
            count = Math.max(count, num%10);
            num /= 10;
        }
        return count;
    }
}
