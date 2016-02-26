package org.usfirst.frc.team6179.robot.commands.driveTrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/26/16.
 */
public class ArcadeDriveWithJoystick extends Command {

    public ArcadeDriveWithJoystick() {
        requires(Robot.instance.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.instance.driveTrain.arcadeDrive(Robot.instance.oi.getY(), Robot.instance.oi.getRotation());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        endCommand();
    }

    protected void interrupted() {

    }

    private void endCommand() {
        Robot.instance.driveTrain.stop();
    }
}
