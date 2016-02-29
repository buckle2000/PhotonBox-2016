
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.commands.drivetrain.ArcadeDriveWithJoystick;
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
    public boolean squaredInput = false;

    public double angle;

    private RobotDrive drive;


    public DriveTrain() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
=======
    public boolean squaredInput = true;

    // private BMA220Accelerometer accelerometer;
    public GY521GyroAccelerometer gy521;

    public double angle;

    private RobotDrive drive;

    private Timer timer;

    public DriveTrain() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        timer = new Timer();
        gy521 = new GY521GyroAccelerometer();
        timer.start();
//        accelerometer = new BMA220Accelerometer();
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    public double getAngularVelocity() {
        double angularVelocity = gy521.getGyroZ();
        angle += timer.get() * angularVelocity;
        timer.reset();
        return gy521.getGyroZ();
    }

>>>>>>> Stashed changes
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveWithJoystick());
    }

}

