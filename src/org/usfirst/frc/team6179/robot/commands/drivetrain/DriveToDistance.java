package org.usfirst.frc.team6179.robot.commands.driveTrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

public class DriveToDistance extends Command {
    double distance;
    double speed;
    double endTime;

    public DriveToDistance(double distance, double speed, double endTime) {
        requires(Robot.instance.driveTrain);
        this.distance = distance;
        this.speed = speed;
        this.endTime = endTime;
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.instance.driveTrain.arcadeDrive(speed, 0);
    }

    protected boolean isFinished() {
        return Math.abs(distance / speed) > endTime;
    }

    protected void end() {
        Robot.instance.driveTrain.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    }
}
