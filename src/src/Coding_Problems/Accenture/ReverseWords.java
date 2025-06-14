package src.Coding_Problems.Accenture;

import java.util.Stack;

public class ReverseWords {

    public static String reverseWords(String str)
    {
       str = str+" ";
       String result = "";
       int prev=0;
       for(int i=0; i<str.length(); i++)
       {
           if(str.charAt(i) == ' ' )
           {
               result = str.substring(prev,i) +" "+ result;
               prev = i+1;
           }
       }
       return result.substring(0,result.length()-1);
    }

    public static String reverseWords2(String str)
    {
        String[] str_arr = str.split(" ");
        String result = "";
        for (int i=str_arr.length-1; i>=0; i--)
        {
            result += str_arr[i] +" ";
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "Welcome, to Code!";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords2(str));
    }
}
