import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class World extends JPanel
{
    private Cell[][] cell;
    private Cell[][] copy;
    public World(int size)
    {
        super(new GridLayout(size,size));
        cell = new Cell[size][size];
        copy = new Cell[size][size];
        for(int r = 0; r<cell.length; r++)
        {
            for(int c = 0; c<cell[r].length; c++)
            {
                cell[r][c] = new Cell();
                copy[r][c] = new Cell();
                add(cell[r][c]);
            }
        }
    }

    public void reset()
    {
        for(int r = 0; r<cell.length; r++)
        {
            for(int c = 0; c<cell[r].length; c++)
            {
                copy[r][c].setAlive(false);
            }
        }
        set();
    }

    public void step()
    {
        Copy();
        for(int r = 0; r<cell.length; r++)
        {
            for(int c = 0; c<cell[r].length; c++)
            {
                if(LOD(r,c,1)==3 && !cell[r][c].isAlive())
                {
                    copy[r][c].setAlive(true);
                }else
                if(cell[r][c].isAlive())
                {
                    if(LOD(r,c,1)>3 ||LOD(r,c,1)<2)
                    {
                        copy[r][c].setAlive(false);
                    }
                }
            }
        }
        set();
    }

    public void Copy()
    {
        for(int r = 0; r<cell.length; r++)
        {
            for(int c = 0; c<cell[r].length; c++)
            {
                copy[r][c].setAlive(cell[r][c].isAlive());
            }
        }
    }

    public void set()
    {
        for(int r = 0; r<cell.length; r++)
        {
            for(int c = 0; c<cell[r].length; c++)
            {
                cell[r][c].setAlive(copy[r][c].isAlive());
            }
        }
    }

    public int LOD(int x, int y, int distance)
    {
        int number=0;
        for(int a = distance; a>=-distance; a--)
        {
            for(int b = distance; b>=-distance; b--)
            {
                if(x+a>=0 && x+a < cell[x].length && y+b>=0 && y+b < cell[y].length)
                {
                    if(cell[x+a][y+b].isAlive())
                    {
                        if(!(a==0 && b==0))
                        {
                            number++;
                        }
                    }
                }
            }

        }
        return number;
    }
}