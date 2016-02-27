package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team6179.robot.mappings.Extreme3DProKeyMapping;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Extreme3DPro implements OI {

    private Joystick stick;

    public Extreme3DPro() {
        stick = new Joystick(0);
    }

    @Override
    public double getMovement() {
        return 0;
    }

    @Override
    public double getRotation() {
        return 0;
    }

    @Override
    public double getShooterElevatorInput() {
        return 0;
    }

    @Override
    public double getLeftMovement() {
        return 0;
    }

    @Override
    public double getRightMovement() {
        return 0;
    }
}

