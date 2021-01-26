import javax.swing.*;
import java.awt.*;

public class XYPanel extends JPanel {
    int A_X;
    int A_Y;

    int B_X;
    int B_Y;

    boolean isSimulationOver = false;

    XYPanel(int A_X, int A_Y, int B_X, int B_Y){
        this.A_X = A_X;
        this.A_Y = A_Y;
        this.B_X = B_X;
        this.B_Y = B_Y;
        this.setPreferredSize(new Dimension(510,525));
        this.setBackground(Color.WHITE);
    }

    public void setSpaceShipA(int x, int y){
        this.A_X = x;
        this.A_Y = y;
    }

    public void setSpaceShipB(int x, int y){
        this.B_X = x;
        this.B_Y = y;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0,5,0,500);
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0,500, 500, 500 );
        g2d.setColor(Color.RED);
        g2d.fillOval(A_X,A_Y,5,5);
        g2d.setColor(Color.BLUE);
        g2d.fillOval(B_X,B_Y,5,5);
        if(isSimulationOver){
            //draw ending line
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.RED);
            g2d.drawLine(A_X,A_Y,B_X,B_Y);
        }
    }

    public void refreshPanel(boolean isLaserShoot){
        if(isLaserShoot){
            this.isSimulationOver = true;
        }
        repaint();
    }

}
