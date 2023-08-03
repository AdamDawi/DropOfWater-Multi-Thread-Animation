import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel
{
    private Thread thread;
    AnimationPanel()
    {
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(300, 300));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D)g;
        drawWater(G2D);
    }

    public void drawWater(Graphics2D G2D)
    {
        G2D.setColor(Color.blue);
        G2D.fillOval(50, 50 , 10, 10);
    }

    class Water
    {
        private int x=50;
        private int y=50;

        public int getX(){return x;}
        public int getY() {return y;}
        public void setX(int x){this.x=x;}
        public void setY(int y){this.y=y;}

    }
}
