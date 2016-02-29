package org.usfirst.frc.team6179.robot.sensors;

import edu.wpi.first.wpilibj.I2C;

import java.nio.ByteBuffer;

/**
 * A class that reads data from the BMA220 accelerometer
 */
public class BMA220Accelerometer {
    private I2C i2C;

    public BMA220Accelerometer() {
        i2C = new I2C(I2C.Port.kOnboard, 0x0A);
    }

    /** Gets the acceleration along X-axis in g-force */
    public double getX() {
        return getBuffer().getShort() * 0.0625;
    }

    /** Gets the acceleration along Y-axis in g-force */
    public double getY() {
        return getBuffer().getShort(2) * 0.0625;
    }

    /** Gets the acceleration along Z-axis in g-force */
    public double getZ() {
        return getBuffer().getShort(4) * 0.0625;
    }

    /** Gets the acceleration along three axes */
    public double[] getAccelerometerData() {
        ByteBuffer buffer = getBuffer();
        double[] data = {buffer.getShort(), buffer.getShort(), buffer.getShort()};
        return data;
    }

    private ByteBuffer getBuffer() {
        byte[] buffer = new byte[6];

        i2C.read(0x04, 6, buffer);

        return ByteBuffer.wrap(buffer);
    }

}
