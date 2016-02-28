package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

public class Climber extends Subsystem {
    public Servo lockServo = new Servo(RobotMap.climberLockServo);
    public SpeedController climberMotor = new Victor(RobotMap.climberMotor);
    public Encoder climberMotorEncoder = new Encoder(RobotMap.channelA, RobotMap.channelB, true, Encoder.EncodingType.k4X);

    public Climber() {
        LiveWindow.addActuator("Climber", "Servo", lockServo);
        LiveWindow.addActuator("Wrist", "GearMotor", (TalonSRX) climberMotor);
        LiveWindow.addSensor("Wrist", "Encoder", climberMotorEncoder);
    }

    public void initDefaultCommand() {
    }

    public void log() {
        SmartDashboard.putNumber("GearMotor Distance", climberMotorEncoder.getDistance());
        SmartDashboard.putNumber("GearMotor Speed", climberMotorEncoder.getRate());
        SmartDashboard.putNumber("GearMotor RawData", climberMotorEncoder.getRaw());
        SmartDashboard.putNumber("GearMotor FPGAIndex", climberMotorEncoder.getFPGAIndex());
        SmartDashboard.putNumber("GearMotor Get", climberMotorEncoder.get());
    }
}

