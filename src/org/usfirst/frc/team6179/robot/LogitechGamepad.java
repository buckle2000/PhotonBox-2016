package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team6179.robot.mappings.LogitechGamepadKeyMapping;

/**
 * Created by CC on 2/26/16.
 */
public class LogitechGamepad implements OI {

    private Joystick stick;

    public LogitechGamepad() {
        stick = new Joystick(0);
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
