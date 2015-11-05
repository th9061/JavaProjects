import java.util.*;
public class Hands
{
    private Scanner in = new Scanner(System.in);
    public Hands()
    {
        run();
    }
    private void run()
    {
        int x = in.nextInt();
        int y = in.nextInt();
        double min = y*6;
        double hr = ((y/2)+(x*30));
        System.out.println(hr+" "+min);
    }
}