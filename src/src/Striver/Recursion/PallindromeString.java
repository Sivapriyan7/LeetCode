package src.Striver.Recursion;

public class PallindromeString {

    public static boolean isPallindrome(String s, int left, int right)
    {
        if(left >= right) return true;
        s = s.toLowerCase();
        if(s.charAt(left) != s.charAt(right))
        {
            return false;
        }
        return isPallindrome(s,left+1,right-1);
    }

    public static void main(String[] args) {
        String str = "Madam";
        System.out.println(isPallindrome(str,0,str.length()-1));
    }
}
