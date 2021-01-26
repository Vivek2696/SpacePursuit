import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class SimulationFrame extends JFrame implements ActionListener {
    //Coordinates and Labels
    XYPanel xyPanel;
    YZPanel yzPanel;
    JLabel xylabel;
    JLabel yzlabel;
    //timer
    //int timer = 20;
    Timer timer;
    int counter = 0;
    //constants for laser
    final int LASER_ALPHA = 30;
    final int LASER_MAX_DIST = 84;

    //Space Variables
    int SpaceShipA_Speed;
    int SpaceShipB_Speed;

    int SpaceShipA_X;
    int SpaceShipA_Y;
    int SpaceShipA_Z;

    int SpaceShipB_X;
    int SpaceShipB_Y;
    int SpaceShipB_Z;

    boolean isSimulationTimeOut = false;

    //Simulation initial values
    SimulationParameters simulationValues;

    SimulationFrame(SimulationParameters param){
        this.setTitle("Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,1080);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
        this.getContentPane().setBackground(Color.WHITE);

        this.simulationValues = param;

        SpaceShipA_X = simulationValues.getSpaceShipA_Start_X();
        SpaceShipA_Y = simulationValues.getSpaceShipA_Start_Y();
        SpaceShipA_Z = simulationValues.getSpaceShipA_Start_Z();

        SpaceShipB_X = simulationValues.getSpaceShipB_Start_X();
        SpaceShipB_Y = simulationValues.getSpaceShipB_Start_Y();
        SpaceShipB_Z = simulationValues.getSpaceShipB_Start_Z();

        SpaceShipA_Speed = simulationValues.getSpaceShipASpeed();
        SpaceShipB_Speed = simulationValues.getSpaceShipBSpeed();

        xyPanel = new XYPanel(SpaceShipA_X,SpaceShipA_Y,SpaceShipB_X,SpaceShipB_Y);
        yzPanel = new YZPanel(SpaceShipA_Y,SpaceShipA_Z,SpaceShipB_Y,SpaceShipB_Z);
        this.CreateLabels();

        this.add(xyPanel);
        this.add(yzPanel);
        this.add(xylabel);
        this.add(yzlabel);

        this.setVisible(true);
        checkForAttack();
        this.startTimer();
    }

    public void startTimer(){
        timer = new Timer(500, this);
        timer.start();
    }

    public void CreateLabels(){
        xylabel = new JLabel();
        xylabel.setText("X-Y Co-ordinates");
        xylabel.setVerticalTextPosition(JLabel.CENTER);
        xylabel.setPreferredSize(new Dimension(500,25));
        xylabel.setFont(new Font("Arial Black", Font.BOLD, 18));

        yzlabel = new JLabel();
        yzlabel.setText("Y-Z Co-ordinates");
        yzlabel.setVerticalTextPosition(JLabel.CENTER);
        yzlabel.setPreferredSize(new Dimension(500,25));
        yzlabel.setFont(new Font("Arial Black", Font.BOLD, 18));
    }

    public void updateSpaceShipA(){
        int v2_x = SpaceShipB_X;
        int v2_y = SpaceShipB_Y;
        int v2_z = SpaceShipB_Z;

        int v1_x = SpaceShipA_X;
        int v1_y = SpaceShipA_Y;
        int v1_z = SpaceShipA_Z;

        double distance = Math.sqrt(Math.pow((v2_x - v1_x),2) + Math.pow((v2_y - v1_y),2) + Math.pow((v2_z - v1_z),2));

        SpaceShipA_X += (SpaceShipA_Speed * ((v2_x - v1_x)/distance));
        SpaceShipA_Y += (SpaceShipA_Speed * ((v2_y - v1_y)/distance));
        SpaceShipA_Z += (SpaceShipA_Speed * ((v2_z - v1_z)/distance));

    }

    public void updateSpaceShipB(){
        int v2_x = simulationValues.getSpaceShipB_End_X();
        int v2_y = simulationValues.getSpaceShipB_End_Y();
        int v2_z = simulationValues.getSpaceShipB_End_Z();

        int v1_x = SpaceShipB_X;
        int v1_y = SpaceShipB_Y;
        int v1_z = SpaceShipB_Z;

        double distance = Math.sqrt(Math.pow((v2_x - v1_x),2) + Math.pow((v2_y - v1_y),2) + Math.pow((v2_z - v1_z),2));

        SpaceShipB_X += (SpaceShipB_Speed * ((v2_x - v1_x)/distance));
        SpaceShipB_Y += (SpaceShipB_Speed * ((v2_y - v1_y)/distance));
        SpaceShipB_Z += (SpaceShipB_Speed * ((v2_z - v1_z)/distance));
    }

    public void checkForAttack(){
        //Get the cylindrical angle and distance between two spaceship
        int v2_x = SpaceShipB_X;
        int v2_y = SpaceShipB_Y;
        int v2_z = SpaceShipB_Z;

        int v1_x = SpaceShipA_X;
        int v1_y = SpaceShipA_Y;
        int v1_z = SpaceShipA_Z;

        double distance = Math.sqrt(Math.pow((v2_x - v1_x),2) + Math.pow((v2_y - v1_y),2) + Math.pow((v2_z - v1_z),2));

        double theta = Math.acos((v2_z-v1_z)/distance);
        double phi = Math.atan((double)((v2_y-v1_y)/(v2_x-v1_x)));

        //check if the target is in the range
        if((int)theta <= LASER_ALPHA && (int)distance <= LASER_MAX_DIST){
            timer.stop();
            xyPanel.refreshPanel(true);
            yzPanel.refreshPanel(true);
            JOptionPane.showMessageDialog(null, "Space Ship A destroyed Space Ship B with laser beam",
                    "Simulation Over", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        else if(isSimulationTimeOut){
            timer.stop();
            JOptionPane.showMessageDialog(null, "Timeout no clash between spaceships",
                    "Simulation Over", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(counter >= 60){
            isSimulationTimeOut = true;
        }

        updateSpaceShipA();
        updateSpaceShipB();

        xyPanel.setSpaceShipA(SpaceShipA_X, SpaceShipA_Y);
        xyPanel.setSpaceShipB(SpaceShipB_X, SpaceShipB_Y);

        yzPanel.setSpaceShipA(SpaceShipA_Y, SpaceShipA_Z);
        yzPanel.setSpaceShipB(SpaceShipB_Y, SpaceShipB_Z);

        checkForAttack();

        xyPanel.refreshPanel(false);
        yzPanel.refreshPanel(false);

        counter++;
    }
}
