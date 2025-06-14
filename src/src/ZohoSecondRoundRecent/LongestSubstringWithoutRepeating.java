package src.ZohoSecondRoundRecent;

public class LongestSubstringWithoutRepeating {


    public static void main(String[] args) {
        String s = "dddea";
        System.out.println(longestSubstringwithoutRepeating(s));

    }

    private static int longestSubstringwithoutRepeating(String str)
    {
        int[] hash = new int[256];
        for (int i=0; i<hash.length; i++)
        {
            hash[i] = -1;
        }
        int l = 0 , r = 0 ,maxLen = 0, len = 0;
        int n = str.length();
        while (r < n)
        {
            if(hash[str.charAt(r)] != -1)
            {
                if(hash[str.charAt(r)] >= l)
                {
                    l = hash[str.charAt(r)]+1;
                }
            }
            len = r-l+1;
            maxLen = Math.max(len, maxLen);
            hash[str.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}
