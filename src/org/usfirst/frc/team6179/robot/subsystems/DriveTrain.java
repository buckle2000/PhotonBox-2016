
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.commands.drivetrain.ArcadeDriveWithJoystick;
import org.usfirst.frc.team6179.robot.commands.drivetrain.UseGyro;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;
import org.usfirst.frc.team6179.robot.sensors.GY521GyroAccelerometer;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Multiplies the speed to be set when setting the speed
    public double speedMultiplier = 0.8;

    // Multiplies the turning speed to be set when setting the turning speed
    public double turnMultiplier = 0.6;

    // Indicates whether the speed input should be squared
    public boolean squaredInput = true;

    // private BMA220Accelerometer accelerometer;
    public GY521GyroAccelerometer gy521;

    public double angle;

    private RobotDrive drive;

    public DriveTrain() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        gy521 = new GY521GyroAccelerometer();

        (new UseGyro()).start();
//        accelerometer = new BMA220Accelerometer();
    }

    public void arcadeDrive(double movement, double rotation) {
        drive.tankDrive(movement * speedMultiplier - rotation * turnMultiplier, rotation * turnMultiplier + rotation * turnMultiplier, squaredInput);
    }

    public void tankDrive(double leftMovement, double rightMovement) {
        drive.tankDrive(leftMovement * speedMultiplier, rightMovement * speedMultiplier, squaredInput);
    }

    public void stop() {
        drive.arcadeDrive(0, 0);
    }

    public double getAngularVelocity() {
        return gy521.getGyroZ() / DriveTrainConfig.gyroSensitivity - DriveTrainConfig.gyroOffset;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveWithJoystick());
    }

}

