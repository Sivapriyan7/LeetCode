package src.Coding_Problems.Gfg_Leet_Problems;

class RemainingString {
    public static String printString(String s, char ch, int count) {
        // code here
        int val = 0;
        for(int i=0;i<s.length();i++)
        {
//            System.out.println("i"+i);
//            System.out.println(s.charAt(i)+"-"+ch);

            if(s.charAt(i)==ch)
            {
//                System.out.print(s.charAt(i)+"-"+ch);
                val++;
            }
            System.out.println("val "+val+" count"+count);
            if(val==count)
            {
                return s.substring(i+1,s.length());
            }
        }
        return "";
    }

    public static void main(String[] args)
    {
        RemainingString s = new RemainingString();
        System.out.print(s.printString("Thisisdemostring",'i',3));

    }
}
