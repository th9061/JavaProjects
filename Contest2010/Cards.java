import java.util.*;
public class Cards
{
    private Scanner in = new Scanner(System.in);
    public Cards()
    {
        System.out.println("Type in your cards:");
        run();
    }
    private void run()
    {
        String data = in.nextLine();
        String a = data.substring(0,1);
        int aCount = 1;
        String b = "";
        int bCount = 0;
        String c = "";
        int cCount = 0;
        boolean print = false;
        for(int i = 0; i < data.length(); i ++)
        {
            if(a.equals(data.substring(i,i+1)))
            {
                aCount ++;
            }
            else if(b.equals("") || b.equals(data.substring(i,i+1)))
            {
                b = data.substring(i,i+1);
                bCount ++;
            }
            else if(c.equals("") || c.equals(data.substring(i,i+1)))
            {
                c = data.substring(i,i+1);
                cCount ++;
            }
        }
        do{
            if(aCount >= 3)
            {
                aCount -= 3;
                System.out.println("set of three: "+a);
                print = true;
            }
            else if(bCount >= 3)
            {
                bCount -= 3;
                System.out.println("set of three: "+b);
                print = true;
            }
            else if(cCount >= 3)
            {
                cCount -= 3;
                System.out.println("set of three: "+c);
                print = true;
            }
            else if(aCount > 0 && bCount > 0 && cCount > 0)
            {
                aCount --;
                bCount --;
                cCount --;
                System.out.println("set: "+a+b+c);
                print = true;
            }
            else if(print)
            {
                print = false;
            }
            else
            {
                System.out.println("no set");
            }
        }while(print);
        
        run();
    }
}