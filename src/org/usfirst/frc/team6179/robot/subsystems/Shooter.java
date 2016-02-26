package org.usfirst.frc.team6179.robot.subsystems;

import org.usfirst.frc.team6179.robot.Mappings.RobotMap;
import org.usfirst.frc.team6179.robot.commands.ShooterDoNothing;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Created by Caroline on 2/26/16.
 */
public class Shooter extends Subsystem {
    private SpeedController shootMotor = new TalonSRX(RobotMap.shootMotor),
            pushrod = new TalonSRX(RobotMap.pushrod);
    private Servo shooterServo = new Servo(RobotMap.shooterServo);

    public static final double ANGLE = 170;

    public Shooter() {
        LiveWindow.addActuator("Shooter", "Motor", (TalonSRX) shootMotor);
        LiveWindow.addActuator("Wrist", "Pushrod", (TalonSRX) pushrod);
        LiveWindow.addSensor("Shooter", "Servo", shooterServo);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterDoNothing());
    }

    //shootMotor
    public void shoot() {
        shootMotor.set(1);
    }

    public void collect() {
        shootMotor.set(-1);
    }

    public void shooterStop() {
        shootMotor.set(0);
    }

    //pushrod
    public void liftUp() {
        pushrod.set(1);
    }

    public void liftDown() {
        pushrod.set(-1);
    }

    public void pushrodStop() {
        pushrod.set(0);
    }

    //shooterServo
    //TEST
    public void hold() {
        shooterServo.setAngle(ANGLE);
    }

    public void release() {
        shooterServo.setAngle(-ANGLE);
    }
}


