package src.Striver.Recursion;

public class FibonacciSeries {

    public static int fibonacci(int n)
    {
        if(n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacci(n));
    }
}
