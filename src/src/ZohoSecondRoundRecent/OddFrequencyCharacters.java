package src.ZohoSecondRoundRecent;

public class OddFrequencyCharacters {

    public static void main(String[] args) {
        String s = "aabbbccc";
        System.out.println(findOddFreqChar(s));
    }
    private static String findOddFreqChar(String str)
    {
        int[] freq = new int[26];
        String res = "";
        for (int i=0; i<str.length(); i++)
        {
            freq[str.charAt(i)-'a']++;
        }
        for (int i=0; i<freq.length; i++)
        {
            if(freq[i]%2==1)
            {
                res += (char)('a'+i);
            }
        }
        return res;
    }

}
