package org.usfirst.frc.team6179.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.ClimberConfig;

/**
 * Created by huangzhengcheng1 on 2/27/16.
 */
public class UnlockClimber extends Command {

    public UnlockClimber() {
        requires(Robot.instance.climber);
    }

    @Override
    protected void initialize() {
        Robot.instance.climber.lockServo.setAngle(ClimberConfig.lockServoUnlockedPosition);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        // The unlock action needn't keep running after the climber is unlocked
        return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
