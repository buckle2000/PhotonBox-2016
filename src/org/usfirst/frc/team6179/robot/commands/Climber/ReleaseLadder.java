package org.usfirst.frc.team6179.robot.commands;

public class ReleaseLadder extends CommandBase {

    public ReleaseLadder() {
    	requires(climbing);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climbing.release();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
