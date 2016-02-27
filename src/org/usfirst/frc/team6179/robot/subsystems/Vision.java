package org.usfirst.frc.team6179.robot.subsystems;

import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by huangzhengcheng1 on 2/27/16.
 */
public class Vision extends Subsystem {

    private int session;
    private String cameraName = null;

    @Override
    protected void initDefaultCommand() {

    }

    public void useCamera(String cameraName) {
        session = NIVision.IMAQdxOpenCamera(cameraName, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        NIVision.IMAQdxStartAcquisition(session);

        this.cameraName = cameraName;
    }

    public void stopCamera() {
        NIVision.IMAQdxStopAcquisition(session);
        NIVision.IMAQdxCloseCamera(session);

        cameraName = null;
    }
}
