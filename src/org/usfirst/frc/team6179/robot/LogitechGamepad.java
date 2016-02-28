package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.commands.AimMode;
import org.usfirst.frc.team6179.robot.commands.drivetrain.DriveStraight;
import org.usfirst.frc.team6179.robot.commands.drivetrain.PutGyroData;
import org.usfirst.frc.team6179.robot.commands.shooter.CollectBoulder;
import org.usfirst.frc.team6179.robot.commands.shooter.ShootBoulder;
import org.usfirst.frc.team6179.robot.commands.vision.SendVideo;
import org.usfirst.frc.team6179.robot.mappings.LogitechGamepadKeyMapping;

public class LogitechGamepad implements OI {
    // TODO: Resolve keymap conflict

    private Joystick stick;

    public LogitechGamepad() {
        stick = new Joystick(0);

        // bind buttons to commands. //
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_X).toggleWhenPressed(new CollectBoulder());
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_LB).whenPressed(new ShootBoulder());
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_RB).whileHeld(new AimMode());
        // bind buttons to commands. //

        // display commands on dashboard for easy testing. //
        // Shooter
        SmartDashboard.putData("Shoot Boulder", new ShootBoulder());
        SmartDashboard.putData("Collect Boulder", new CollectBoulder());
        // Vision
        SmartDashboard.putData("Display Shooter Camera Video", new SendVideo(Robot.instance.shooterVision));
        SmartDashboard.putData("Put Gyro Data", new PutGyroData());
        SmartDashboard.putData("Drive Straight", new DriveStraight());
        // display commands on dashboard for easy testing. //

    }

    @Override
    public double getMovement() {
        return -stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
    }

    @Override
    public double getRotation() {
        return -stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
    }

    @Override
    public double getLeftMovement() {
//        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
        return 0;
    }

    @Override
    public double getRightMovement() {
//        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetX() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
    }

    @Override
    public double getScaledCrosshairOffsetY() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
    }

    @Override
    public double getArmMovement() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_TRIGGER) - stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_TRIGGER);
    }

    @Override
    public double getShooterElevatorInput() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
    }

}
