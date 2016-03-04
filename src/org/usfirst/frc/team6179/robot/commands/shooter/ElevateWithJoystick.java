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
        double output = Robot.instance.oi.getShooterElevatorInput();
        // if the designated output signal is to raise the Shooter, and the limit switch is activated, don't allow the elevator mechanism to move.
        // and this part is wrong.
        if (output > 0 && !Robot.instance.elevator.limitSwitch.get()) {
            output = 0;
        }
        Robot.instance.elevator.elevatorActuator.set(output);

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
