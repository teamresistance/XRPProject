package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import frc.robot.io.hdw_io;
import frc.robot.io.io;

public class servo {
    private static XRPServo servo = hdw_io.servo;
    private static boolean servoState = false;

    public static void updateServo() {
        if(io.buttonCirclePressed) {
            servoState = !servoState;
        }

        if(servoState) {
            servo.setAngle(90);
        } else {
            servo.setAngle(20);
        }
    }

    public static void setServoState(boolean newServoState) {
        servoState = newServoState;
    }

    public static void toggleServoState() {
        servoState = !servoState;
    }

    public static boolean getServoState() {
        return servoState;
    }
}
