package org.usfirst.frc.team6179.robot.sensors;

import edu.wpi.first.wpilibj.I2C;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;

import java.nio.ByteBuffer;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 */
public class GY521GyroAccelerometer {

    private I2C i2C;

    public GY521GyroAccelerometer() {
        i2C = new I2C(I2C.Port.kOnboard, 0x68);
        i2C.write(0x6B, 0);
    }

    public double getAccelerometerX() {
        return getRawData()[0];
    }

    public double getAccelerometerY() {
        return getRawData()[1];
    }

    public double getAccelerometerZ() {
        return getRawData()[2];
    }

    public double getGyroX() {
        return getRawData()[3];
    }

    public double getGyroY() {
        return getRawData()[4];
    }

    public double getGyroZ() {
        return getRawData()[5] / DriveTrainConfig.gyroSensitivity;
    }

    private double[] getRawData() {
        double[] rawData = new double[6];

        byte[] buffer = new byte[6];
        i2C.read(0x3B, 6, buffer);
        ByteBuffer wrappedBuffer = ByteBuffer.wrap(buffer);
        rawData[0] = wrappedBuffer.getShort();
        rawData[1] = wrappedBuffer.getShort();
        rawData[2] = wrappedBuffer.getShort();

        i2C.read(0x43, 6, buffer);
        wrappedBuffer = ByteBuffer.wrap(buffer);
        rawData[3] = wrappedBuffer.getShort();
        rawData[4] = wrappedBuffer.getShort();
        rawData[5] = wrappedBuffer.getShort();

        return rawData;
    }
}
