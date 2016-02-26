package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Created by CC on 2/26/16.
 */
public class LogitechGamepad implements OI {

    private Joystick stick;

    public LogitechGamepad() {
        stick = new Joystick(0);
    }

    public double getMovement() {
        return 0;
    }

    public double getRotation() {
        return 0;
    }

    public double getLeftMovement() {
        return 0;
    }

    public double getRightMovement() {
        return 0;
    }
}
