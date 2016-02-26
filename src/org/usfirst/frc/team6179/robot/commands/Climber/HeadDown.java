package org.usfirst.frc.team6179.robot.commands;

public class HeadDown extends CommandBase {

    public HeadDown() {
    	requires(climbing);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climbing.headDown();
    	climbing.log();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
