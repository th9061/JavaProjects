import java.util.*;
public class Cinderella
{
    private int trials;
    private Scanner in = new Scanner(System.in);
    public Cinderella()
    {
        System.out.println("ta");
        trials = in.nextInt();
        for(int i = 0; i < trials; i++)
        {
            find(i+1);
        }
    }
    private void find(int t)
    {
        int w = in.nextInt();
        int h = in.nextInt();
        int grid[][] = new int [w][h];
        int distance = 0;
        int largest = 0;
        int smallest = -1;
        int lx = 0, ly = 0, sx = 0, sy = 0;
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                grid[x][y] = in.nextInt();
                if(grid[x][y] > largest)
                {
                    largest = grid[x][y];
                    lx = x;
                    ly = y;
                    if(smallest < 0)
                    {
                        smallest = largest;
                    }
                }
                else if(grid[x][y] < smallest)
                {
                    smallest = grid[x][y];
                    sx = x;
                    sy = y;
                }
            }
        }
        do{
            if(sy > ly)
            {
                distance ++;
                sy --;
            }
            else if(ly > sy)
            {
                distance ++;
                ly --;
            }
            else if(sx > lx)
            {
                distance ++;
                sx --;
            }
            else if(lx > sx)
            {
                distance ++;
                lx --;
            }
        }while(sy!=ly||lx!=sy);
        System.out.println("Distance for case #"+t+": "+distance);
    }
}