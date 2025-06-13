package src.Striver.Recursion;

import javax.swing.*;
import java.util.Scanner;

public class Print1ToN {

    public static void print1ton(int i,int n)
    {
        if(i>n){
            return;
        }
        System.out.println(i);
        print1ton(i+1,n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print1ton(1,n);
    }
}
