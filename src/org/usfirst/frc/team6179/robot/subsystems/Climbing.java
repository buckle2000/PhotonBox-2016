package org.usfirst.frc.team6179.robot.subsystems;

import org.usfirst.frc.team6179.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climbing extends Subsystem {
    private Servo climbingServo=new Servo(RobotMap.climbingServo);
    private SpeedController wristMotor=new TalonSRX(RobotMap.wristMotor);
    private Encoder wristEncoder=new Encoder(RobotMap.channel_A,RobotMap.channel_B,true,Encoder.EncodingType.k4X);
    
    public static final double DEGREE=90;
    
    public Climbing(){
    	LiveWindow.addActuator("Climbing", "Servo", climbingServo);
    	LiveWindow.addActuator("Wrist", "GearMotor", (TalonSRX)wristMotor);
		LiveWindow.addSensor("Wrist", "Encoder", wristEncoder);
    }
    
    public void initDefaultCommand() {
    }
    
    //climbingServo
    //TEST
    public void release(){
    	climbingServo.setAngle(DEGREE);
    }
    public void climbingReset(){
    	climbingServo.setAngle(-DEGREE);
    }
    
    //wristMotor
    public void recuperate(Joystick stick){
    	wristMotor.set(stick.getRawAxis(3));
    }
    
    public void headUp(){
    	wristMotor.set(1);
    }
    
    public void headDown(){
    	wristMotor.set(-1);
    }
    
    public void stop(){
    	wristMotor.set(0);
    }
    
    //wristEncoder
    public void encoderReset(){
    	wristEncoder.reset();
    }
    
    public void log(){
		SmartDashboard.putNumber("GearMotor Distance", wristEncoder.getDistance());
		SmartDashboard.putNumber("GearMotor Speed", wristEncoder.getRate());
		SmartDashboard.putNumber("GearMotor RawData", wristEncoder.getRaw());
		SmartDashboard.putNumber("GearMotor FPGAIndex", wristEncoder.getFPGAIndex());
		SmartDashboard.putNumber("GearMotor Get", wristEncoder.get());
    }
}

