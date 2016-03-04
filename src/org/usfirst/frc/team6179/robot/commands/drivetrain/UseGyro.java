package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 * A command that constantly sends back gyro data.
 * Used for recording data.
 */
public class UseGyro extends Command {

    private Timer timer;

    public UseGyro() {
        timer = new Timer();
    }

    @Override
    protected void initialize() {
        timer.start();

    }

    @Override
    protected void execute() {
        double angularVelocity = Robot.instance.driveTrain.getAngularVelocity();
        Robot.instance.driveTrain.angle += timer.get() * angularVelocity;
        timer.reset();

        SmartDashboard.putNumber("Angular Velocity", angularVelocity);
        SmartDashboard.putNumber("Angle", Robot.instance.driveTrain.angle);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
