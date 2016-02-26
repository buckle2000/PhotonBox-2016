package org.usfirst.frc.team6179.robot.commands;

public class ResetLadder extends CommandBase {

    public ResetLadder() {
    	requires(climbing);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climbing.climbingReset();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
