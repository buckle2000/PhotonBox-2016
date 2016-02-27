package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.commands.arm.LowerArm;
import org.usfirst.frc.team6179.robot.commands.arm.RaiseArm;
import org.usfirst.frc.team6179.robot.commands.shooter.CollectBoulder;
import org.usfirst.frc.team6179.robot.commands.shooter.ShootBoulder;
import org.usfirst.frc.team6179.robot.commands.vision.SendVideo;
import org.usfirst.frc.team6179.robot.mappings.LogitechGamepadKeyMapping;

/**
 * Created by CC on 2/26/16.
 */
public class LogitechGamepad implements OI {

    private Joystick stick;

    public LogitechGamepad() {
        stick = new Joystick(0);

        // bind buttons to commands. //
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_Y).whileHeld(new RaiseArm());
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_A).whileHeld(new LowerArm());
        // bind buttons to commands. //

        // display commands on dashboard for easy testing. //
        // Shooter
        SmartDashboard.putData("Shoot Boulder", new ShootBoulder());
        SmartDashboard.putData("Collect Boulder", new CollectBoulder());
        // Vision
        SmartDashboard.putData("Display Shooter Camera Video", new SendVideo(Robot.instance.shooterVision));
        // display commands on dashboard for easy testing. //

    }

    @Override
    public double getMovement() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
    }

    @Override
    public double getRotation() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
    }

    @Override
    public double getLeftMovement() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
    }

    @Override
    public double getRightMovement() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
    }

    @Override
    public double getShooterElevatorInput() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
    }

}
