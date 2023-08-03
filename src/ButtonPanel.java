import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel
{
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
    ButtonPanel()
    {
        startButton.setPreferredSize(new Dimension(100, 30));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
            }
        });

        stopButton.setPreferredSize(new Dimension(100, 30));

        this.add(startButton);
        this.add(stopButton);
    }
}
