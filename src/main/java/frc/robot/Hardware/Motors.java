package frc.robot.Hardware;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;

public class Motors {
    public static final XRPMotor motorLeft = new XRPMotor(0);
    public static final XRPMotor motorRight = new XRPMotor(1);
    public static final Encoder encoderLeft = new Encoder(4, 5);
    public static final Encoder encoderRight = new Encoder(6, 7);


}