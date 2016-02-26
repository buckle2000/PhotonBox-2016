package org.usfirst.frc.team6179.robot.commands;

public class MoveArm extends CommandBase {

    public MoveArm() {
    	requires(arm);
    }

    protected void initialize() {
    }

    protected void execute() {
    	arm.moveUp();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
