package src.ZohoSecondRoundRecent;

public class RedBlueBall {
    public static void main(String[] args) {
        int red = 2;
        int blue = 1;

        int count = 0;
        char start = 'B';
        int minus_value = 1;
        while(red >0 || blue>0)
        {
            if(start=='B'){
                blue-= minus_value;
                start='R';
            }
            else {
                red -= minus_value;
                start='B';
            }
            minus_value++;
            count++;
        }
        System.out.println("Max Height "+count);
    }
}
