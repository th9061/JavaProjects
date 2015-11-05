import java.awt.*;
import javax.swing.*;
public class Square extends JButton
{
    private int player;
    private boolean available;
    /**
     * Constructor for objects of class Square
     */
    public Square()
    {
        player = 0;
    }

    public void setPlayer(int s)
    {
        player = s;
        if(s==1)
        {
            setText("X");
        } 
        if(s==2)
        {
            setText("O");
        }
    }

    public int getPlayer()
    {
        return player;
    }

    public boolean isAvailable()
    {
        return player == 0;
    }
}
