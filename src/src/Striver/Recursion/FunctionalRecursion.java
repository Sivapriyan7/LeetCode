package src.Striver.Recursion;

import java.util.Scanner;

public class FunctionalRecursion {
    public static int findsum(int n){
        if(n==0) return 0;
        return n+findsum(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalsum = findsum(n);
        System.out.println("Total sum "+totalsum);
    }
}
