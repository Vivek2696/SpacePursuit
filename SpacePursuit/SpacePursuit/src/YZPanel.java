import javax.swing.*;
import java.awt.*;

public class YZPanel extends JPanel {
    int A_Y;
    int A_Z;

    int B_Y;
    int B_Z;

    boolean isSimulationOver = false;

    YZPanel(int A_Y, int A_Z, int B_Y, int B_Z){
        this.A_Y = A_Y;
        this.A_Z = A_Z;
        this.B_Y = B_Y;
        this.B_Z = B_Z;
        this.setPreferredSize(new Dimension(510,510));
        this.setBackground(Color.WHITE);
    }

    public void setSpaceShipA(int y, int z){
        this.A_Y = y;
        this.A_Z = z;
    }

    public void setSpaceShipB(int y, int z){
        this.B_Y = y;
        this.B_Z = z;
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
        g2d.fillOval(A_Y,A_Z,5,5);
        g2d.setColor(Color.BLUE);
        g2d.fillOval(B_Y,B_Z,5,5);
        if(isSimulationOver){
            //draw ending line
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.RED);
            g2d.drawLine(A_Y,A_Z,B_Y,B_Z);
        }
    }

    public void refreshPanel(boolean isLaserShoot){
        if(isLaserShoot){
            this.isSimulationOver = true;
        }
        repaint();
    }

}
