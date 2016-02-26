package org.usfirst.frc.team6179.robot.subsystems;

import org.usfirst.frc.team6179.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Arm extends Subsystem {
	private SpeedController armMotor=new TalonSRX(RobotMap.armMotor);
	
	public static final double speed=0.2;//TEST
	
	public Arm(){
		LiveWindow.addActuator("Arm", "SnowMotor", (TalonSRX)armMotor);
	}
	
    public void initDefaultCommand() {
    }
    
    public void moveUp(){
    	armMotor.set(speed);
    }
    
    public void moveDown(){
    	armMotor.set(-speed);
    }
    
    public void stop(){
    	armMotor.set(0);
    }
}

