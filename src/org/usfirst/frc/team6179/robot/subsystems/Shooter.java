package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

/**
 * A subsystem representing the Shooter on the robot,
 * not including the elevator mechanism,
 * dealing exclusively with shooting and collecting boulders.
 */
public class Shooter extends Subsystem {

    // Actuators
    /**
     * The two motors that actuate the shooter wheels.
     * (There are two motors that are being controlled by this one speed controller because 麦麦说了).
     */
    public TalonSRX shootMotor = new TalonSRX(RobotMap.shooterMotor);
    public Servo triggerServo = new Servo(RobotMap.shooterTriggerServo);

    public Shooter() {
        LiveWindow.addActuator("Shooter", "Shooter Motor", shootMotor);
        LiveWindow.addSensor("Shooter", "Servo", triggerServo);
    }

    public void initDefaultCommand() {
    }

    // TODO: add easy control for motor direction.

}


