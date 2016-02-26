package org.usfirst.frc.team6179.robot.commands;

public class TankDriveWithJoystick extends CommandBase {

    public TankDriveWithJoystick() {
    	requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	drivetrain.drive(oi.getJoystick_3D());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	drivetrain.drive(0, 0);
    }

    protected void interrupted() {
    }
} 
