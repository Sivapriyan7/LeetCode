package src.Striver.Recursion;

import java.util.Scanner;

public class PrintNameNTimes {
    public static void printName(int i,int n)
    {
        if(i>n){
            return;
        }
        else {
            System.out.println("sivapriyan");
            printName(i+1,n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printName(1,n);
    }
}
