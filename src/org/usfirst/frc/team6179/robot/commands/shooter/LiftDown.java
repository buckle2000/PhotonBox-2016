package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class LiftDown extends CommandBase {

    public LiftDown() {
    	requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.liftDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
