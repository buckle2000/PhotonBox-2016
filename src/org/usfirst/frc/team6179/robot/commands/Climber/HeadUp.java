package org.usfirst.frc.team6179.robot.commands;

public class HeadUp extends CommandBase {

    public HeadUp() {
    	requires(climbing);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climbing.headUp();
    	climbing.log();
    }

    protected boolean isFinished() {
        return false;
        //return Math.abs(wrist.getPosition()-setpoint)<0.5;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
