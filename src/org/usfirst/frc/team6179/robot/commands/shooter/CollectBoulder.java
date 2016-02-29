package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.ShooterConfig;

/**
 * A command which makes the Shooter enter a state where it can collect boulder, and exit that state when the command ends.
 */
public class CollectBoulder extends Command {

    public CollectBoulder() {
        requires(Robot.instance.shooter);
    }

    protected void initialize() {
        // start the wheels when the command starts.
        Robot.instance.shooter.shootMotor.set(-1);
        // move back the trigger just in case if it isn't.
        Robot.instance.shooter.shooterServo.setAngle(ShooterConfig.triggerServoBackPosition);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        // the command won't terminate on it's own.
        return false;
    }

    protected void end() {
        // stop the wheels when the command ends.
        Robot.instance.shooter.shootMotor.set(0);
    }

    protected void interrupted() {
        // stop the wheels when the command ends.
        Robot.instance.shooter.shootMotor.set(0);
    }
}
