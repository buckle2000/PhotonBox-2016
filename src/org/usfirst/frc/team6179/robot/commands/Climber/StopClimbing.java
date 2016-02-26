package org.usfirst.frc.team6179.robot.commands;

public class StopClimbing extends CommandBase {

    public StopClimbing() {
    	requires(climbing);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climbing.stop();
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
