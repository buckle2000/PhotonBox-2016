package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class PushrodStop extends CommandBase {

    public PushrodStop() {
    	requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	shooter.pushrodStop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
