import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel
{
    private ImageIcon blobIcon = new ImageIcon("water.gif");

    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(blobIcon.getImage(), 50, 50, null);
    }
}
