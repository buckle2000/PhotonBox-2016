package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class ShootBoulder extends CommandBase {

    public ShootBoulder() {
        requires(shooter);
        //setTimeout(8);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.shoot();
    }

    protected boolean isFinished() {
        return false;//isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
