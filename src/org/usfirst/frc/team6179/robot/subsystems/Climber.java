package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

public class Climber extends Subsystem {
    /** The servo used to lock the climber */
    public Servo lockServo = new Servo(RobotMap.climberLockServo);

    /** The motor used controls the stretch of the climber by tightening or relaxing the rope that holds the climber */
    public Victor climberMotor = new Victor(RobotMap.climberMotor);

    /** The encoder that sends back data from the climber motor */
    public Encoder climberMotorEncoder = new Encoder(RobotMap.channelA, RobotMap.channelB, true, Encoder.EncodingType.k4X);

    public Climber() {
        LiveWindow.addActuator("Climber", "Lock Servo", lockServo);
        LiveWindow.addActuator("Wrist", "GearMotor", climberMotor);
        LiveWindow.addSensor("Wrist", "Encoder", climberMotorEncoder);
    }

    public void initDefaultCommand() {
    }

}

