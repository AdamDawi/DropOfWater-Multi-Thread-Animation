package animation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel
{
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
    private JButton addButton = new JButton("Add");

    ButtonPanel(AnimationPanel animationPanel)
    {
        startButton.setPreferredSize(new Dimension(100, 30));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                animationPanel.start();
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

        addButton.setPreferredSize(new Dimension(100, 30));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                animationPanel.addDropOfWater();
            }
        });

        this.add(startButton);
        this.add(stopButton);
        this.add(addButton);
    }
}
