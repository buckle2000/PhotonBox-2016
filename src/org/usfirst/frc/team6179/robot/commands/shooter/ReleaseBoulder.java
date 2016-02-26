package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class ReleaseBoulder extends CommandBase {

    public ReleaseBoulder() {
    	requires(shooter);
    	setTimeout(3);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.release();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
