package by.it.Zyryanov.jd02_06.builder;


public class OldRobotBuilder implements RobotBuilder{

    private Robot robot;


    public OldRobotBuilder(){

        this.robot = new Robot();

    }


    @Override
    public void buildRobotHead() {

        robot.setRobotHead("Tin Head");

    }

    @Override
    public void buildRobotTorso() {

        robot.setRobotTorso("Tin Torso");

    }

    @Override
    public void buildRobotArms() {

        robot.setRobotArms("Tin arms");

    }

    @Override
    public void buildRobotLegs() {

        robot.setRobotLegs("Wheels");

    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}
