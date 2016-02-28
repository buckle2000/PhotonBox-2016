package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 */
public class DriveStraight extends Command {

    private double speed = 0.5;
    private double turningIncrement = 0.2;

    public DriveStraight() {
        requires(Robot.instance.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.instance.driveTrain.arcadeDrive(speed, 0);
    }

    @Override
    protected void execute() {
        if(Robot.instance.driveTrain.angle > 0) {
            Robot.instance.driveTrain.arcadeDrive(speed, -turningIncrement);
        } else if(Robot.instance.driveTrain.angle < 0) {
            Robot.instance.driveTrain.arcadeDrive(speed, turningIncrement);
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
