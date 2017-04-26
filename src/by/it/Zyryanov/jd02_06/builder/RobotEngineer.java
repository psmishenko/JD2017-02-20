package by.it.Zyryanov.jd02_06.builder;


public class RobotEngineer {


    private RobotBuilder robotBuilder;

    public RobotEngineer(RobotBuilder robotBuilder){

        this.robotBuilder = robotBuilder;

    }

    public Robot getRobot(){

        return this.robotBuilder.getRobot();

    }

    public void makerobot(){

        this.robotBuilder.buildRobotArms();
        this.robotBuilder.buildRobotHead();
        this.robotBuilder.buildRobotLegs();
        this.robotBuilder.buildRobotTorso();

    }



}
