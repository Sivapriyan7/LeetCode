package src.Coding_Problems.TCS;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZero {

    public static void main(String[] args) {
        int[] arr  = {1,0,2,0,1,0,2};
        int zero = 0,one = 0,two = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==0)
            {
                zero++;
            } else if (arr[i]==1) {
                one++;
            }
            else{
                two++;
            }
        }
        int index=0;
        while(zero-->0)
        {
            arr[index++]=0;
        }
        while(one-->0)
        {
            arr[index++]=1;
        }
        while(two-->0)
        {
            arr[index++]=2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static class primesum {
        public static boolean isPrime(int val)
        {
            if(val==1)return false;
            for (int i=2; i<val; i++)
            {
                if(val%i == 0)
                {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int start = sc.nextInt();
            int end = sc.nextInt();
            int totalsum = 0;
            for (int val=start; val<end; val++)
            {
                if(isPrime(val)){
                    totalsum+=val;
                }
            }
            System.out.println(totalsum);
        }
    }
}
