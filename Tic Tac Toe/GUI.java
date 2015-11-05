import javax.swing.*;

public class GUI extends JFrame
{

    public GUI()
    {
        add(new TTTBoard());
        setTitle("Tic Tac Toe");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
