import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControlPanel extends JPanel
{
    private JButton btnStep, btnRun, btnReset;
    private Timer t;
    private World w;
    public ControlPanel(World world){
        btnStep = new JButton("Step");
        add(btnStep);
        btnStep.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    w.step();
                }
            }
        );
        btnRun = new JButton("Run");
        add(btnRun);
        btnRun.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    if(btnRun.getText().equals("Run")){
                        btnRun.setText("Stop");
                        t.start();
                        t.setRepeats(true);
                    }else{
                        btnRun.setText("Run");
                        t.stop();
                    }
                }
            }
        );
        btnReset = new JButton("Reset");
        add(btnReset);
        btnReset.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    w.reset();
                }
            }
        );
        w = world;
        t = new Timer(1000,
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    w.step();
                }
            }
            );
    }
}
