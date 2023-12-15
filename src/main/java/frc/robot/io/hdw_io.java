package frc.robot.io;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj.xrp.XRPGyro;

public class hdw_io {
    //Look at the edu.wpi.first.wpilibj.xrp packages, there's one for every function of the thing




    //Motors
    public static final XRPMotor motorLeft = new XRPMotor(0);
    public static final XRPMotor motorRight = new XRPMotor(1);
    public static final XRPMotor unusedMotor1 = new XRPMotor(2);
    public static final XRPMotor unusedMotor2 = new XRPMotor(3);

    //Servos
    public static final XRPServo servo = new XRPServo(4); //There's only the one servo on it with compat for another

    //Encoders
    /*
     * Encoder Channels (All DIO):
     * Left Encoder Quadrature Channel A: 4
     * Left Encoder Quadrature Channel B: 5
     * Right Encoder Quadrature Channel A: 6
     * Right Encoder Quadrature Channel B: 7
     * 8-11 are for unused motors following same pattern as motor 1 + 2
     */
    public static final Encoder encoderLeft = new Encoder(4, 5);
    public static final Encoder encoderRight = new Encoder(6, 7);
    
    //There is apparently 3-axis gyro+accelerometer, dunno how to access that, will work on it
    //"Inertial Measurement Unit
    // The XRP includes an STMicroelectronics LSM6DSOX Inertial Measurement Unit (IMU) which contains a 3-axis gyro and a 3-axis accelerometer."
    public static final XRPGyro gyro = new XRPGyro();
    
    
    public static final XRPOnBoardIO dioObject = new XRPOnBoardIO(); 



        

    //Left Reflectance Sensor AnalogInput0
    //Right Reflectance Sense AnalogInput1
    //The return values from this should be 0V (pure white) to 5V (pure black)

    //Ultrasonic Rangefinder AnalogInput2
    //The return value of this is 0V (20mm) to 5V (4000mm)
    //Math wise, this should be [(value/5) * 3980 + 20) to get accurate distance

}