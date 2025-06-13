package src.Striver.Recursion;

import java.util.Scanner;

public class PrintNTo1 {

    public static void printnto1(int i, int n)
    {
        if(i>n){
            return;
        }
        printnto1(i+1,n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printnto1(1,n);
    }
}
