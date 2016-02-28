package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.commands.shooter.ElevateWithJoystick;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

/**
 * A subsystem representing the elevator mechanism on the robot which can raise and lower the Shooter.
 */
public class ShooterElevator extends Subsystem {

    public Victor elevatorActuator = new Victor(RobotMap.shooterElevator);

    public DigitalInput limitSwitch = new DigitalInput(RobotMap.shooterElevatorLimitSwitch);

    public ShooterElevator() {
        LiveWindow.addActuator("Shooter", "Elevator Motor", elevatorActuator);
        LiveWindow.addSensor("Shooter", "Limit Switch", limitSwitch);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ElevateWithJoystick());
    }

}
