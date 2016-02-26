package org.usfirst.frc.team6179.robot.commands;

import org.usfirst.frc.team6179.robot.Robot;

public class RecuperateLadder extends CommandBase {

    public RecuperateLadder() {
    	requires(climbing);
    }

    protected void initialize() {
    }

    protected void execute() {
    	climbing.recuperate(Robot.oi.getJoystick_3D());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
