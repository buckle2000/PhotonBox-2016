package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class LiftUp extends CommandBase {

    public LiftUp() {
    	requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.liftUp();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
