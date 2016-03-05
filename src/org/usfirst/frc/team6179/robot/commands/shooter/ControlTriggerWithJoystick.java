package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by CC on 3/5/16.
 */
public class ControlTriggerWithJoystick extends Command {

    private double position = 0.5;
    private double maxMoveSpeed = 0.5;

    public ControlTriggerWithJoystick() {
        requires(Robot.instance.shooter);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        position += maxMoveSpeed * Robot.instance.oi.getShooterTriggerServoMovement();
        Robot.instance.shooter.triggerServo.set(position);

        SmartDashboard.putNumber("Shooter Trigger Servo Position", position);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }

}
