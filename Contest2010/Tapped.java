import java.util.*;
public class Tapped
{
    private Scanner in = new Scanner(System.in);
    public Tapped()
    {
        System.out.println("amount of c");
        run();
    }

    private void run()
    {
        double n = in.nextInt();
        double x = in.nextInt();
        if(n != 0 || x != 0)
        {
            int k = 0;
            double current = n;
            while(x!=0||n!=0)
            {
                x = (n*x)/100;
                while(current > x)
                {
                    current -= (current/n)/10;
                    k++;
                }
            }
            System.out.println("Run tap for "+k+" second(s).");
            run();
        }
    }
}