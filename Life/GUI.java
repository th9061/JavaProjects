import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame
{
    public GUI(){
        super("Life");
        setLayout(new BorderLayout());
        World world = new World(15);
        add(world,BorderLayout.CENTER);
        add(new ControlPanel(world), BorderLayout.SOUTH);
        setVisible(true);
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
