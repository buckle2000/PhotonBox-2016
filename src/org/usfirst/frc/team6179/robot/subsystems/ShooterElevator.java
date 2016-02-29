package org.usfirst.frc.team6179.robot.subsystems;

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

    public ShooterElevator() {
        LiveWindow.addActuator("Shooter", "电动推杆", elevatorActuator);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ElevateWithJoystick());
    }

}
