
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.LogitechGamepad;
import org.usfirst.frc.team6179.robot.OI;

/**
 *
 */
public class DriveTrain extends Subsystem {

    TalonSRX leftMotor;
    TalonSRX rightMotor;

    // Multiplies the speed to be set when setting the speed
    public double speedMultiplier = 0.8;

    // Multiplies the turning speed to be set when setting the turning speed
    public double turnMultiplier = 0.6;

    // Indicates whether the speed input should be squared
    public boolean squaredInput = false;

    private RobotDrive drive;

    public DriveTrain(int left, int right) {
        leftMotor = new TalonSRX(left);
        rightMotor = new TalonSRX(right);
        drive = new RobotDrive(leftMotor, rightMotor);
    }

//    public DriveTrain(int motor, double speed) {
//        TalonSRX Motor = new TalonSRX(motor);
//        Motor.set(speed);
//    }
    
    public void arcadeDrive(double movement, double rotation) {
        drive.arcadeDrive(movement * speedMultiplier, rotation * turnMultiplier, squaredInput);
    }

    public void tankDrive(double leftMovement, double rightMovement) {
        drive.tankDrive(leftMovement * speedMultiplier, rightMovement * speedMultiplier, squaredInput);
    }

    public void stop() {
        drive.arcadeDrive(0, 0);
    }

    public void initDefaultCommand() {
        //		setDefaultCommand(new DriveWithJoystick());
    }

}

