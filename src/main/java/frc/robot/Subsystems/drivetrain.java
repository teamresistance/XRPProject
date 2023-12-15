package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.xrp.XRPMotor;
import frc.robot.io.hdw_io;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Why use this one and not XRP's? 
 * Because I dun wanna.
 * That is the only reason. Usually we'd use it.
 * But, I don't want to. So, meh. 
 */
public class drivetrain {
    //The right motor is generally more powerful than left, so I'll be basing
    //everthing on the speed of left.



    //Hardcoded as of now, but you can easily make it instantiated if you want
    //Example:
    /*
     * public drivetrain(XRPMotor motorLeft, XRPMotor motorRight, Encoder encoderLeft, Encoder encoderRight) {
     *      this.motorLeft = motorLeft;
     *      this.motorRight = motorRight;
     *      this.encoderLeft = encoderLeft;
     *      this.encoderRight = encoderRight;
     * }
     */


    //References to simplify everything
    private static XRPMotor motorLeft = hdw_io.motorLeft;
    private static XRPMotor motorRight = hdw_io.motorRight;
    private static Encoder encoderLeft = hdw_io.encoderLeft;
    private static Encoder encoderRight = hdw_io.encoderRight;

    /**
     * Differential Drive handles all the actual math and driving stuff for us!
     * This is pretty much how we do it on the actual robot, if you can make someone
     * else do all the hard stuff, then let them.
     */
    private static DifferentialDrive diffDrive = new DifferentialDrive(motorLeft, motorRight);
    
    /**
     * Put in the power values and it'll set the motors for you
     * @param leftSide The speed you want the left side to go (you can easily just put joystick values into this)
     * @param rightSide The speed you want the right side to go (you can easily just put joystick values into this)
     */
    public static void tankDrive(double leftSide, double rightSide) {
        diffDrive.tankDrive(leftSide, rightSide);
    }

    /**
     * Allows you to move using only one joystick if you want
     * @param movement How fast you want to go forward or backward (negative for backward)
     * @param rotate How fast you want to rotate (positive for clockwise, negative for counter)
     */
    public static void arcadeDrive(double movement, double rotate) {
        diffDrive.arcadeDrive(rotate, movement);
    }



}