public class SimulationParameters {
    int spaceShipASpeed;
    int spaceShipBSpeed;

    int SpaceShipA_Start_X;
    int SpaceShipA_Start_Y;
    int SpaceShipA_Start_Z;

    int SpaceShipB_Start_X;
    int SpaceShipB_Start_Y;
    int SpaceShipB_Start_Z;

    int SpaceShipA_End_X;
    int SpaceShipA_End_Y;
    int SpaceShipA_End_Z;

    int SpaceShipB_End_X;
    int SpaceShipB_End_Y;
    int SpaceShipB_End_Z;

    SimulationParameters(){
        //Default speed for spaceships
        spaceShipASpeed = 6;
        spaceShipBSpeed = 3;

        //Add positions later
        SpaceShipA_Start_X = 0;
        SpaceShipA_Start_Y = 0;
        SpaceShipA_Start_Z = 80;

        SpaceShipB_Start_X = 250;
        SpaceShipB_Start_Y = 250;
        SpaceShipB_Start_Z = 0;

        SpaceShipA_End_X = 450;
        SpaceShipA_End_Y = 250;
        SpaceShipA_End_Z = 500;

        SpaceShipB_End_X = 250;
        SpaceShipB_End_Y = 250;
        SpaceShipB_End_Z = 500;
    }

    //set speed for spaceship A
    public int getSpaceShipASpeed(){
        return spaceShipASpeed;
    }
    public void setSpaceShipASpeed(int speed){
        spaceShipASpeed = speed;
    }

    //set speed for spaceship B
    public int getSpaceShipBSpeed(){
        return spaceShipBSpeed;
    }
    public void setSpaceShipBSpeed(int speed){
        spaceShipBSpeed = speed;
    }

    //Space ship A starting coordinate
    public int getSpaceShipA_Start_X(){
        return  SpaceShipA_Start_X;
    }
    public void setSpaceShipA_Start_X(int x){
        SpaceShipA_Start_X = x;
    }
    public int getSpaceShipA_Start_Y(){
        return  SpaceShipA_Start_Y;
    }
    public void setSpaceShipA_Start_Y(int y){
        SpaceShipA_Start_Y = y;
    }
    public int getSpaceShipA_Start_Z(){
        return  SpaceShipA_Start_Z;
    }
    public void setSpaceShipA_Start_Z(int z){
        SpaceShipA_Start_Z = z;
    }

    //Space Ship B start position
    public int getSpaceShipB_Start_X(){
        return  SpaceShipB_Start_X;
    }
    public void setSpaceShipB_Start_X(int x){
        SpaceShipB_Start_X = x;
    }
    public int getSpaceShipB_Start_Y(){
        return  SpaceShipB_Start_Y;
    }
    public void setSpaceShipB_Start_Y(int y){
        SpaceShipB_Start_Y = y;
    }
    public int getSpaceShipB_Start_Z(){
        return  SpaceShipB_Start_Z;
    }
    public void setSpaceShipB_Start_Z(int z){
        SpaceShipB_Start_Z = z;
    }


    //End point for Space Ship A
    public int getSpaceShipA_End_X(){
        return  SpaceShipA_End_X;
    }
    public void setSpaceShipA_End_X(int x){
        SpaceShipA_End_X = x;
    }
    public int getSpaceShipA_End_Y(){
        return  SpaceShipA_End_Y;
    }
    public void setSpaceShipA_End_Y(int y){
        SpaceShipA_End_Y = y;
    }
    public int getSpaceShipA_End_Z(){
        return  SpaceShipA_End_Z;
    }
    public void setSpaceShipA_End_Z(int z){
        SpaceShipA_End_Z = z;
    }


    //End Point for Space Ship B
    public int getSpaceShipB_End_X(){
        return  SpaceShipB_End_X;
    }
    public void setSpaceShipB_End_X(int x){
        SpaceShipB_End_X = x;
    }
    public int getSpaceShipB_End_Y(){
        return  SpaceShipB_End_Y;
    }
    public void setSpaceShipB_End_Y(int y){
        SpaceShipB_End_Y = y;
    }
    public int getSpaceShipB_End_Z(){
        return  SpaceShipB_End_Z;
    }
    public void setSpaceShipB_End_Z(int z){
        SpaceShipB_End_Z = z;
    }

}
