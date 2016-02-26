package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class HoldBoulder extends CommandBase {

    public HoldBoulder() {
    	requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.hold();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
