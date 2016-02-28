package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 * A command that constantly sends back gyro data.
 * Used for recording data.
 */
public class PutGyroData extends Command {
    public PutGyroData() {

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Angular Velocity", Robot.instance.driveTrain.gy521.getGyroZ() / DriveTrainConfig.gyroSensitivity);
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
