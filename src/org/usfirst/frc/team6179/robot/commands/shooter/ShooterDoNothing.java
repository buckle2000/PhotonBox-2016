package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class ShooterDoNothing extends CommandBase {

    public ShooterDoNothing() {
        requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.shooterStop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
