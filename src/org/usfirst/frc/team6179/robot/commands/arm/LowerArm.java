package org.usfirst.frc.team6179.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by CC on 2/27/16.
 */
public class LowerArm extends Command {

    public LowerArm() {
        requires(Robot.instance.arm);
    }

    protected void initialize() {
        Robot.instance.arm.moveDown();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.instance.arm.stop();
    }

    protected void interrupted() {
        Robot.instance.arm.stop();
    }

}
