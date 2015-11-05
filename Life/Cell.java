import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Cell extends JButton implements ActionListener
{
    private boolean alive;
    public boolean isAlive(){
        return alive;
    }
    public Cell(){
        super(" ");
        alive = false;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent event){
        alive = !alive;
        update();
    }
    
    public void setAlive(boolean state){
        alive = state;
        update();
    }
    private void update(){
        if(alive){
            setText("X");
        }else{
            setText(" ");
        }
    }
}
