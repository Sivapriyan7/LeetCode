package src.ZohoSecondRoundRecent;

public class AddDigit {

    public static void main(String[] args) {
        int num = 232218;
        while (num > 9)
        {
            num = addDigit(num);
        }
        System.out.println(num);
        System.out.println(addDigit(num));
    }

    private int addDigitsUsingMod(int num)
    {
        if(num == 0) return 0;
        if (num%9 == 0) return 9;
        return num % 9;
    }

    private static int addDigit(int num)
    {
        int sum = 0;
        while (num > 0)
        {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
