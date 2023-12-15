// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import frc.robot.Subsystems.drivetrain;
import frc.robot.Subsystems.servo;
import frc.robot.io.hdw_io;
import frc.robot.io.io;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private final SendableChooser<String> m_chooser = new SendableChooser<>();


	// private final XRPDrivetrain m_drivetrain = new XRPDrivetrain();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
		m_chooser.addOption("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);

	}

	/**
	 * This function is called every 20 ms, no matter the mode. Use this for items
	 * like diagnostics
	 * that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different
	 * autonomous modes using the dashboard. The sendable chooser code works with
	 * the Java
	 * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
	 * chooser code and
	 * uncomment the getString line to get the auto name from the text box below the
	 * Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure
	 * below with additional strings. If using the SendableChooser make sure to add
	 * them to the
	 * chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);

		// m_drivetrain.resetEncoders();
	}

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {
		hdw_io.encoderLeft.reset();
		hdw_io.encoderRight.reset();
		hdw_io.gyro.reset();

		//So, I was going to make autonomous and it was going to be super cool and stuff
		//The issue is that the gyro on this thing doesn't work. It's broken.
		//For some reason, even if it's stationary, on the floor, it constantly detects
		//an increase in the angle.
		//I could try to work around this, in fact, I could, but... why should I?
		//Like, that's too much work to try to get something that doesn't work, to work
		//We'll just discuss how it SHOULD work :)

	}

	/** This function is called once when teleop is enabled. */
	@Override
	public void teleopInit() {
	}

	/** This function is called periodically during operator control. */
	private static double multiplier = 0;

	@Override
	public void teleopPeriodic() {
		io.updateController();

		multiplier = Math.abs((io.triggerR2 + 1.0) / 2.0);
		drivetrain.tankDrive(io.leftThumbstickY * multiplier, io.rightThumbstickY * multiplier * -1);
		
		servo.updateServo();

		hdw_io.dioObject.setLed(io.buttonCross);

		if (hdw_io.dioObject.getUserButtonPressed()) {
			System.out.println("IT HAPPENED!!");
		}

	}

	/** This function is called once when the robot is disabled. */
	@Override
	public void disabledInit() {
	}

	/** This function is called periodically when disabled. */
	@Override
	public void disabledPeriodic() {
	}

	

	/** This function is called once when test mode is enabled. */
	@Override
	public void testInit() {
		hdw_io.gyro.reset();
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {
		System.out.println(hdw_io.gyro.getAngleZ() + " | " + hdw_io.gyro.getRateZ());
	}
}
