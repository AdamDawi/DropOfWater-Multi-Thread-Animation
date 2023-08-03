import java.awt.*;
import javax.swing.*;

public class AnimationFrame extends JFrame
{
    AnimationFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("water.jpg").getImage());
        this.setLocationRelativeTo(null);
        this.setTitle("Animation");
        this.getContentPane().add(new AnimationPanel());
        this.getContentPane().add(new ButtonPanel(), BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
}
