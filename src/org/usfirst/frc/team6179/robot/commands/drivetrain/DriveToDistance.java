package org.usfirst.frc.team6179.robot.commands;

public class DriveToDistance extends CommandBase {
	double distance,speed,endTime;
	
    public DriveToDistance(double distance,double speed,double endTime) {
    	requires(drivetrain);
    	this.distance=distance;
    	this.speed=speed;
    	this.endTime=endTime;
    }

    protected void initialize() {
    }

    protected void execute() {
    	drivetrain.drive(speed, -speed);
    }

    protected boolean isFinished() {
        return Math.abs(distance/speed)>endTime;
    }

    protected void end() {
    	drivetrain.drive(0, 0);
    }

    protected void interrupted() {
    }
}
