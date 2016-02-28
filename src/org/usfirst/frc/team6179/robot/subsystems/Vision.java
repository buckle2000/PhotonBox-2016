package org.usfirst.frc.team6179.robot.subsystems;

import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.configurations.VisionConfig;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import com.ni.vision.NIVision.GetImageSizeResult;
import com.ni.vision.NIVision.Point;

/**
 * Created by huangzhengcheng1 on 2/27/16.
 * A subsystem that encapsulates the use of a camera.
 */
public class Vision extends Subsystem {

    /**
     * An object used to automatically capture images and send them back to driver's computer.
     */
    private CameraServer server;
    /**
     * An index value used to reference a camera during a NIVision camera session.
     */
    private int session;

    /**
     * The name of the camera currently used by this Vision object.
     */
    private String cameraName;

    private Image frame;
    private GetImageSizeResult size;

    public Vision(String cameraName) {
        this.cameraName = cameraName;

        frame = NIVision.imaqCreateImage(ImageType.IMAGE_RGB, 0);
    }

    @Override
    protected void initDefaultCommand() {
    }

    /**
     * Start automatically sending video feed back to driver's computer using a CameraServer instance.
     * This can only be called once, and no other features related to image processing should be used on this camera after the call.
     */
    public void startAutoCapture() {
        server = CameraServer.getInstance();
        server.setQuality(VisionConfig.autoCaptureImageQuality);
        server.startAutomaticCapture(cameraName);
    }

    /**
     * Start a NIVision session using this camera, enabling it to capture images.
     * This must be called prior to using any features related to image processing.
     *
     * @return an index value used to reference a camera during a NIVision camera session.
     */
    public int useCamera() {
        session = NIVision.IMAQdxOpenCamera(cameraName, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        NIVision.IMAQdxStartAcquisition(session);

        return session;
    }

    public Image grabPicture() {
        NIVision.IMAQdxGrab(session, frame, 1);
        size = NIVision.imaqGetImageSize(frame);

        Point crossStart = new Point(size.width / 2 - VisionConfig.crosshairSize, size.height);
        Point crossEnd = new Point(size.width / 2 + VisionConfig.crosshairSize, size.height);

        Point verticalStart = new Point(size.width, size.height / 2 - VisionConfig.crosshairSize);
        Point verticalEnd = new Point(size.width, size.height / 2 + VisionConfig.crosshairSize);

        NIVision.imaqDrawLineOnImage(frame, frame, NIVision.DrawMode.DRAW_VALUE, crossStart, crossEnd, 1);
        NIVision.imaqDrawLineOnImage(frame, frame, NIVision.DrawMode.DRAW_VALUE, verticalStart, verticalEnd, 1);

        return frame;
    }

    /**
     * Stops the current NIVision session with this camera, making it stop capturing images.
     * After this call, any other feature related to image processing should not be used any more.
     */
    public void stopCamera() {
        NIVision.IMAQdxStopAcquisition(session);
        NIVision.IMAQdxCloseCamera(session);

        cameraName = null;
    }
}