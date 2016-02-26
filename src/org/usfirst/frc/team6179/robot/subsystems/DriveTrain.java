
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    public double speedMultiplier = 0.8;
    public double turnMultiplier = 0.6;

    private RobotDrive drive;

    public DriveTrain(int left, int right) {
        TalonSRX leftMotor = new TalonSRX(left);
        TalonSRX rightMotor = new TalonSRX(right);
        drive = new RobotDrive(leftMotor, rightMotor);
    }

    public DriveTrain(int motor, double speed) {
        TalonSRX Motor = new TalonSRX(motor);
        Motor.set(speed);
    }

    public void arcadeDrive(double movement, double rotation) {
        drive.arcadeDrive(movement * speedMultiplier, rotation * turnMultiplier);
    }

    public void initDefaultCommand() {
        //		setDefaultCommand(new DriveWithJoystick());
    }

}

