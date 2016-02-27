package org.usfirst.frc.team6179.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.ClimberConfig;

/**
 * Created by huangzhengcheng1 on 2/27/16.
 */
public class ResetClimberLock extends Command {
    @Override
    protected void initialize() {
        Robot.instance.climber.lockServo.setAngle(ClimberConfig.lockServoLockedPosition);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        // The reset lock action needn't keep running after the lock is reset
        return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
