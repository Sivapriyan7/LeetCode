package src.PatternPrinting;

public class Patterns {
    public static void main(String[] args) {
//        pattern28(5);
//        pattern29(5);
//        patternChar(5);

//        pattern1(5);
//        pattern2(5);
//        pattern3(5);
//        pattern4(5);
//        pattern5(5);
//        pattern6(5);
//        pattern7(5);
//        pattern8(5);
//        pattern9(5);
//        pattern10(5);
//        pattern28(5);
//        pattern29(5);
        pattern30(10);

    }


//            *****
//            *****
//            *****
//            *****
//            *****
    public static void pattern1(int n)
    {
        for (int row = 1; row <= n; row++) {
            for (int col=1; col<n; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern30(int n)
    {
        int row,col;
        for (row=1; row<=n; row++)
        {
            for (int space=n-row; space>=1; space--)
            {
                System.out.print(" ");
            }
            for (col=1; col<=row; col++)
            {
                if(col==10)
                {
                    System.out.print(1);
                }
                else {
                    System.out.print(col+"");
                }
            }
            for (int right=col-2; right>=1; right--)
                System.out.print(right);
            System.out.println();
        }
        int num;
        for (row=1; row<=n-1; row++)
        {
            for (int space=1; space<=row; space++)
            {
                System.out.print(" ");
            }
            for (num=1; num<=n-row; num++)
            {
                System.out.print(num);
            }
            for (int right=num-2; right>=1; right--)
            {
                System.out.print(right);
            }
            System.out.println();
        }
    }

    public static void pattern2(int n)
    {
        for (int row = 0; row < n; row++) {
            for (int col=0; col<=row; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n)
    {
        for (int row = 1; row <= n; row++)
        {
            for (int col=1; col<=n-row+1; col++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n)
    {
        for (int row = 1;row <= n; row++)
        {
            for (int col = 1;col <= row;col++)
            {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n)
    {
        for (int row=1; row<=2*n-1; row++)
        {
            int cols = row>=n ? 2*n-row: row;
            for (int col=1; col<=cols; col++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n)
    {
        for (int row=1; row<=n; row++)
        {
            for (int col=1; col<=n; col++)
            {
                if(col <= n-row)
                {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void pattern7(int n)
    {
        for (int row=n; row>=1; row--)
        {
            for (int col=1; col<=n-row; col++)
            {
                System.out.print(" ");
            }
            for (int k=1; k<=row; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n)
    {
        for (int row=1; row<=n; row++)
        {
            for (int col=1; col<=n-row+1; col++)
            {
                System.out.print(" ");
            }
            for (int i=1; i<=row*2-1; i++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n)
    {
        for(int row=n; row>=1; row--)
        {
            for (int col=1; col<=n-row; col++)
            {
                System.out.print(" ");
            }
            for (int i=1; i<=row*2-1;i++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern10(int n)
    {
        for(int row=1; row<=n; row++)
        {
            for(int col=1; col<=n-row+1; col++)
            {
                System.out.print(" ");
            }
            for (int i=1; i<=row; i++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n)
    {
        for(int row=n; row>=1; row--)
        {
            for (int col=1; col<=n-row; col++)
            {
                System.out.print(" ");
            }
            for (int i=1;i<=row; i++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patternChar(int n)
    {
        char currentChar = 'A';
        for (int row=1;row<=n;row++)
        {
            for (int col=1; col<=row; col++)
            {
                System.out.print(currentChar + " ");
                currentChar++;
            }
            System.out.println();
        }
    }

    public static void pattern28(int n)
    {
        for (int row=1; row<=n*2-1; row++)
        {
            int cols = row<n ? n-row:row-n;
            for (int col=1; col<=cols; col++)
            {
                System.out.print(" ");
            }
            int star = row<=n ? row: n*2-row;
            for (int i=1; i<=star; i++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern29(int n)
    {
        for (int row=1; row<=n*2-1; row++)
        {
            int cols = row<n ? n-row:row-n;
            for (int col=1; col<=cols; col++)
            {
                System.out.print(" ");
            }
            int star = row<=n ? row: n*2-row;
            for (int i=1; i<=star; i++)
            {
                if(i==1 || i==star)
                {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern20(int n)
    {
        for (int row=1; row<=n; row++)
        {
            for (int col=1; col<=n-row; col++)
            {
                System.out.print("  ");
            }
            for (int i=1; i<=row*2-1; i++)
            {
                if (i<=row)
                {
                    System.out.print(row-i+1+" ");
                }
                else {
                    System.out.print(i-row+1  +" ");
                }
            }
            System.out.println();
        }
    }
}

