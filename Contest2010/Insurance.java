import java.util.*;
public class Insurance
{
    private Scanner in = new Scanner(System.in);
    private int trials;
    public Insurance()
    {
        trials = in.nextInt();
        for(int i = 0; i < trials; i++)
        {
            run();
        }
    }
    private void run()
    {
        int odd = in.nextInt();
        int even = in.nextInt();
        odd += in.nextInt(); 
        even += in.nextInt();
        odd += in.nextInt(); 
        even += in.nextInt();
        odd += in.nextInt(); 
        even += in.nextInt();
        odd += in.nextInt(); 
        even *= 2;
        if((even+odd)%10 == 0)
        {
            System.out.println("valid");
        }
        else
        {
            System.out.println("invalid");
        }
    }
}