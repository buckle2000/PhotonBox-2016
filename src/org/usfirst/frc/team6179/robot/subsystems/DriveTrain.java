
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.commands.drivetrain.ArcadeDriveWithJoystick;
import org.usfirst.frc.team6179.robot.commands.shooter.ShootBoulder;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;
import org.usfirst.frc.team6179.robot.sensors.BMA220Accelerometer;
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
    public boolean squaredInput = false;

//    private BMA220Accelerometer accelerometer;
    public GY521GyroAccelerometer gy521;

    private RobotDrive drive;

    public DriveTrain() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        gy521 = new GY521GyroAccelerometer();
//        accelerometer = new BMA220Accelerometer();
    }

    public void arcadeDrive(double movement, double rotation) {
        drive.arcadeDrive(movement * speedMultiplier, rotation * turnMultiplier, squaredInput);
    }

    public void tankDrive(double leftMovement, double rightMovement) {
        drive.tankDrive(leftMovement * speedMultiplier, rightMovement * speedMultiplier, squaredInput);
    }

    public void stop() {
        drive.arcadeDrive(0, 0);
    }

    /** Gets the forward acceleration of the robot in g-force */
//    public double getForwardAcceleration() {
//        return accelerometer.getY();
//    }

//    /**
//     * Gets the angular acceleration of the robot in g-force.
//     * Positive values for clockwise accelerations, negative values for counterclockwise accelerations.
//     */
//    public double getAngularAcceleration() {
//        double aX = accelerometer.getX();
//        double deltaX = DriveTrainConfig.accelerometerOffsetX;
//        double deltaY = DriveTrainConfig.accelerometerOffsetY;
//
//        return aX * deltaX + aX * deltaX * deltaX / deltaY;
//    }

    public double getAngularVelocity() {
        return gy521.getGyroZ();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveWithJoystick());
    }

}

