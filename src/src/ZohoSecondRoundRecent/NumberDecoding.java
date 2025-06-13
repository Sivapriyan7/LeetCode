package src.ZohoSecondRoundRecent;

public class NumberDecoding {
    public static void main(String[] args) {
        String val = "1234";
        int ways = 1;
        int left = 0,right = 1;
        while(right<val.length()+1 && left<val.length()-1)
        {
            String substr = val.substring(left,right+1);
            System.out.println("substr "+substr);
            int value = Integer.parseInt(substr);
            if(value <= 26)
            {
                ways++;
            }
            left++;
            right++;
        }
        System.out.println("ways "+ways);
    }
}
