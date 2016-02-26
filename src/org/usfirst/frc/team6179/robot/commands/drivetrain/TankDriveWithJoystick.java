package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

public class TankDriveWithJoystick extends Command {

    public TankDriveWithJoystick() {
        requires(Robot.instance.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.instance.driveTrain.tankDrive(Robot.instance.oi.getLeftMovement(), Robot.instance.oi.getRightMovement());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
    }

}
