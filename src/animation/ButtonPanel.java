package animation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel
{
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");

    ButtonPanel(AnimationPanel animationPanel)
    {
        startButton.setPreferredSize(new Dimension(100, 30));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                animationPanel.addDropOfWater();
            }
        });

        stopButton.setPreferredSize(new Dimension(100, 30));
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                animationPanel.stop();
            }
        });

        this.add(startButton);
        this.add(stopButton);
    }
}
