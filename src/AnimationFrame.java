import java.awt.*;
import javax.swing.*;

public class AnimationFrame extends JFrame
{
    private JPanel animationPanel = new AnimationPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");

    AnimationFrame()
    {
        animationPanel.setBackground(Color.gray);
        animationPanel.setPreferredSize(new Dimension(300, 300));

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        startButton.setPreferredSize(new Dimension(100, 30));

        stopButton.setPreferredSize(new Dimension(100, 30));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Animation");
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(animationPanel);
        this.pack();
        this.setVisible(true);
        repaint();
    }
    
    
}
