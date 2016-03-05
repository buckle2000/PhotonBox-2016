package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 */
public class DriveStraight extends Command {

    private double speed;
    private double turningIncrement;

    public DriveStraight() {
        requires(Robot.instance.driveTrain);
        speed = SmartDashboard.getNumber("Speed");
        turningIncrement = SmartDashboard.getNumber("Turning Increment");
    }

    @Override
    protected void initialize() {
        Robot.instance.driveTrain.arcadeDrive(speed, 0);
        Robot.instance.gyro.angle = 0;
    }

    @Override
    protected void execute() {
        if(Robot.instance.gyro.angle > 0) {
            Robot.instance.driveTrain.arcadeDrive(speed, turningIncrement * Robot.instance.gyro.angle / 0.1);
        } else if(Robot.instance.gyro.angle < 0) {
            Robot.instance.driveTrain.arcadeDrive(speed, turningIncrement * Robot.instance.gyro.angle / 0.1);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.instance.driveTrain.stop();
    }

    @Override
    protected void interrupted() {
        Robot.instance.driveTrain.stop();
    }
}
