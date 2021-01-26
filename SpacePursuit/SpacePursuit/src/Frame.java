import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.awt.*;

public class Frame extends JFrame {

    Frame() {
        //set up frame
        this.setTitle("SpacePursuit Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420,280);
        this.setLayout(new GridLayout(4,1,10,10));
        this.getContentPane().setBackground(Color.DARK_GRAY);

        SimulationParameters params = new SimulationParameters();

        JPanel titlePanel = new JPanel();
        JPanel spaceshipAPanel = new JPanel();
        JPanel spaceShipBPanel = new JPanel();
        JPanel actionPanel = new JPanel();

        titlePanel.setPreferredSize(new Dimension(200,20));
        spaceshipAPanel.setPreferredSize(new Dimension(200, 100));
        spaceShipBPanel.setPreferredSize(new Dimension(200, 250));
        actionPanel.setPreferredSize(new Dimension(200,20));
        titlePanel.setBackground(Color.WHITE);
        spaceshipAPanel.setBackground(Color.WHITE);
        spaceShipBPanel.setBackground(Color.WHITE);
        actionPanel.setBackground(Color.WHITE);

        //change Icon of this
        ImageIcon spaceImage = new ImageIcon("logo.png");
        this.setIconImage(spaceImage.getImage());

        this.add(titlePanel);
        this.add(spaceshipAPanel);
        this.add(spaceShipBPanel);
        this.add(actionPanel);

        //Add labels
        JLabel title = new JLabel();
        title.setText("Simulation Setup");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);

        //SpaceShip A label
        JLabel shipALabel = new JLabel();
        shipALabel.setText("Spaceship A");
        shipALabel.setFont(new Font("TimesRoman", Font.BOLD, 12));
        shipALabel.setForeground(Color.RED);
        shipALabel.setHorizontalAlignment(JLabel.CENTER);
        shipALabel.setVerticalAlignment(JLabel.CENTER);

        //SpaceShip B label
        JLabel shipBLabel = new JLabel();
        shipBLabel.setText("Spaceship B");
        shipBLabel.setFont(new Font("TimesRoman", Font.BOLD, 12));
        shipBLabel.setForeground(Color.BLUE);
        shipBLabel.setHorizontalAlignment(JLabel.CENTER);
        shipBLabel.setVerticalAlignment(JLabel.CENTER);

        //labels for ships
        JLabel startLabel = new JLabel();
        startLabel.setText("Start Position");
        startLabel.setFont(new Font("TimesRoman", Font.BOLD, 10));

        JLabel startLabel2 = new JLabel();
        startLabel2.setText("Start Position");
        startLabel2.setFont(new Font("TimesRoman", Font.BOLD, 10));

        JLabel endLabel = new JLabel();
        endLabel.setText("End Position");
        endLabel.setFont(new Font("TimesRoman", Font.BOLD, 10));

        JLabel speedLabel = new JLabel();
        speedLabel.setText("Speed");
        speedLabel.setFont(new Font("TimesRoman", Font.BOLD, 10));

        JLabel speedLabel2 = new JLabel();
        speedLabel2.setText("Speed");
        speedLabel2.setFont(new Font("TimesRoman", Font.BOLD, 10));

        JLabel xLabel = new JLabel();
        xLabel.setText("X:");
        xLabel.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel yLabel = new JLabel();
        yLabel.setText("Y:");
        yLabel.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel zLabel = new JLabel();
        zLabel.setText("Z:");
        zLabel.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel xLabel2 = new JLabel();
        xLabel2.setText("X:");
        xLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel yLabel2 = new JLabel();
        yLabel2.setText("Y:");
        yLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel zLabel2 = new JLabel();
        zLabel2.setText("Z:");
        zLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel xLabel3 = new JLabel();
        xLabel3.setText("X:");
        xLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel yLabel3 = new JLabel();
        yLabel3.setText("Y:");
        yLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        JLabel zLabel3 = new JLabel();
        zLabel3.setText("Z:");
        zLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        //text box for ships
        JNumberField startA_X = new JNumberField();
        startA_X.setPreferredSize(new Dimension(30,20));
        startA_X.setText(Integer.toString(params.getSpaceShipA_Start_X()));

        JNumberField startA_Y = new JNumberField();
        startA_Y.setPreferredSize(new Dimension(30,20));
        startA_Y.setText(Integer.toString(params.getSpaceShipA_Start_Y()));

        JNumberField startA_Z = new JNumberField();
        startA_Z.setPreferredSize(new Dimension(30,20));
        startA_Z.setText(Integer.toString(params.getSpaceShipA_Start_Z()));

        JNumberField startB_X = new JNumberField();
        startB_X.setPreferredSize(new Dimension(30,20));
        startB_X.setText(Integer.toString(params.getSpaceShipB_Start_X()));

        JNumberField startB_Y = new JNumberField();
        startB_Y.setPreferredSize(new Dimension(30,20));
        startB_Y.setText(Integer.toString(params.getSpaceShipB_Start_Y()));

        JNumberField startB_Z = new JNumberField();
        startB_Z.setPreferredSize(new Dimension(30,20));
        startB_Z.setText(Integer.toString(params.getSpaceShipB_Start_Z()));

        JNumberField endB_X = new JNumberField();
        endB_X.setPreferredSize(new Dimension(30,20));
        endB_X.setText(Integer.toString(params.getSpaceShipB_End_X()));

        JNumberField endB_Y = new JNumberField();
        endB_Y.setPreferredSize(new Dimension(30,20));
        endB_Y.setText(Integer.toString(params.getSpaceShipB_End_Y()));

        JNumberField endB_Z = new JNumberField();
        endB_Z.setPreferredSize(new Dimension(30,20));
        endB_Z.setText(Integer.toString(params.getSpaceShipB_End_Z()));

        JNumberField speedA = new JNumberField();
        speedA.setPreferredSize(new Dimension(30,20));
        speedA.setText(Integer.toString(params.getSpaceShipASpeed()));

        JNumberField speedB = new JNumberField();
        speedB.setPreferredSize(new Dimension(30,20));
        speedB.setText(Integer.toString(params.getSpaceShipBSpeed()));

        JButton startButton = new JButton("Start Simulation");
        startButton.setFocusable(false);
        startButton.addActionListener(e -> {
            this.dispose();
            params.setSpaceShipASpeed(Integer.parseInt(speedA.getText()));
            params.setSpaceShipBSpeed(Integer.parseInt(speedB.getText()));
            params.setSpaceShipA_Start_X(Integer.parseInt(startA_X.getText()));
            params.setSpaceShipA_Start_Y(Integer.parseInt(startA_Y.getText()));
            params.setSpaceShipA_Start_Z(Integer.parseInt(startA_Z.getText()));
            params.setSpaceShipB_Start_X(Integer.parseInt(startB_X.getText()));
            params.setSpaceShipB_Start_Y(Integer.parseInt(startB_Y.getText()));
            params.setSpaceShipB_Start_Z(Integer.parseInt(startB_Z.getText()));
            params.setSpaceShipB_End_X(Integer.parseInt(endB_X.getText()));
            params.setSpaceShipB_End_Y(Integer.parseInt(endB_Y.getText()));
            params.setSpaceShipB_End_Z(Integer.parseInt(endB_Z.getText()));
            new SimulationFrame(params);
        });

        titlePanel.add(title);
        actionPanel.add(startButton);

        spaceshipAPanel.add(shipALabel);
        spaceshipAPanel.add(startLabel);
        spaceshipAPanel.add(xLabel);
        spaceshipAPanel.add(startA_X);
        spaceshipAPanel.add(yLabel);
        spaceshipAPanel.add(startA_Y);
        spaceshipAPanel.add(zLabel);
        spaceshipAPanel.add(startA_Z);
        spaceshipAPanel.add(speedLabel);
        spaceshipAPanel.add(speedA);

        spaceShipBPanel.add(shipBLabel);
        spaceShipBPanel.add(startLabel2);
        spaceShipBPanel.add(xLabel2);
        spaceShipBPanel.add(startB_X);
        spaceShipBPanel.add(yLabel2);
        spaceShipBPanel.add(startB_Y);
        spaceShipBPanel.add(zLabel2);
        spaceShipBPanel.add(startB_Z);
        spaceShipBPanel.add(endLabel);
        spaceShipBPanel.add(xLabel3);
        spaceShipBPanel.add(endB_X);
        spaceShipBPanel.add(yLabel3);
        spaceShipBPanel.add(endB_Y);
        spaceShipBPanel.add(zLabel3);
        spaceShipBPanel.add(endB_Z);
        spaceShipBPanel.add(speedLabel2);
        spaceShipBPanel.add(speedB);

        this.setVisible(true);
    }
}
