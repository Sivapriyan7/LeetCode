package src.ZohoSecondRoundRecent;

public class InnerReducingPattern {

    public static void printPattern(int n)
    {
        int size = n*2-1;
        int[][] mat = new int[size][size];
        int first = 0;
        int last = size-1;
        while(n != 0)
        {
            for(int i=first; i<=last; i++)
            {
               for(int j=first; j<=last; j++)
               {
                   if(i==first || i==last || j==first || j==last)
                   {
                       mat[i][j] = n;
                   }
               }
            }
            first++;
            last--;
            n--;
        }
        first=0;
        last=size-1;
        for(int i=first; i<=last; i++)
        {
            for(int j=first; j<=last; j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 4;
        printPattern(n);
    }
}
