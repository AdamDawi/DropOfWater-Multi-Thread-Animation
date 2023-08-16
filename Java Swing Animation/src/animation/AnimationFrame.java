package animation;
import java.awt.*;
import javax.swing.*;

public class AnimationFrame extends JFrame
{
    public AnimationPanel animationPanel = new AnimationPanel();

    AnimationFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("water.jpg").getImage());
        this.setLocationRelativeTo(null);
        this.setTitle("Animation");
        this.getContentPane().add(animationPanel);
        this.getContentPane().add(new ButtonPanel(animationPanel), BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
}
