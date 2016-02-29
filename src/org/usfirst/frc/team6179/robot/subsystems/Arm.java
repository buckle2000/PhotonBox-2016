package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.configurations.ArmConfig;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

public class Arm extends Subsystem {
    private Victor armMotor = new Victor(RobotMap.armMotor);

    public Arm(){
        LiveWindow.addActuator("Arm", "ArmMotor", armMotor);
    }
	
    public void initDefaultCommand() {
    }
    
    public void moveUp(){
        armMotor.set(ArmConfig.moveSpeed);
    }
    
    public void moveDown(){
        armMotor.set(-ArmConfig.moveSpeed);
    }
    
    public void stop(){
    	armMotor.set(0);
    }
}

