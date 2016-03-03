package org.usfirst.frc.team6179.robot;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 */
public class Util {
    public static int limit(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
