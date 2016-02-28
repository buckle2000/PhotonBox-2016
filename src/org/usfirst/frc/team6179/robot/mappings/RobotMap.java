package org.usfirst.frc.team6179.robot.mappings;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Actuators
    public static final int leftMotor = 1;
    public static final int rightMotor = 0;
    public static final int climberMotor = 2;
    public static final int climberLockServo = 7;
    public static final int shooterElevator = 3;
    public static final int shooterMotor = 4;
    public static final int armMotor = 5;
    public static final int shooterTriggerServo = 6;

    // Sensors
    public static final int channelA = 0;
    public static final int channelB = 1;

    // Cameras
    public static final String shooterCamera = "cam0";
}
