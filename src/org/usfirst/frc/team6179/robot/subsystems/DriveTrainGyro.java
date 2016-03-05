package org.usfirst.frc.team6179.robot.subsystems;

import com.sun.scenario.animation.shared.TimerReceiver;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;
import org.usfirst.frc.team6179.robot.sensors.GY521GyroAccelerometer;

/**
 * Created by huangzhengcheng1 on 3/5/16.
 */
public class DriveTrainGyro extends Subsystem {

    public double angle;

    private GY521GyroAccelerometer gy521;
    private Timer timer;

    public DriveTrainGyro() {
        gy521 = new GY521GyroAccelerometer();
        angle = 0;
        timer = new Timer();
        timer.start();
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void updateDriveTrainData() {
        double angularVelocity = getAngularVelocity();
        angle += timer.get() * angularVelocity;
        timer.reset();

        SmartDashboard.putNumber("Angular Velocity", angularVelocity);
        SmartDashboard.putNumber("Angle", Robot.instance.gyro.angle);
    }

    public double getAngularVelocity() {
        return gy521.getGyroZ() / DriveTrainConfig.gyroSensitivity - DriveTrainConfig.gyroOffset;
    }
}
