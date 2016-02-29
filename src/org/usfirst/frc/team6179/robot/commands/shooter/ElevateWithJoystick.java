package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * A command that allows the driver to control the elevator mechanism using joystick.
 */
public class ElevateWithJoystick extends Command {

    public ElevateWithJoystick() {
        requires(Robot.instance.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.instance.elevator.elevatorActuator.set(Robot.instance.oi.getShooterElevatorInput());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
