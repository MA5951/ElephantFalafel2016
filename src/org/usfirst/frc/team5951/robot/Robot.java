package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.subsystems.Arm.Arm;
import org.usfirst.frc.team5951.subsystems.Dropper.Dropper;
import org.usfirst.frc.team5951.subsystems.chassis.ChassisArcade;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main control class
 */
public class Robot extends SampleRobot {
	// Joysticks
	private Joystick mainDriverStick;
	private Joystick systemsDriver;

	// Subsystems
	private ChassisArcade chassisArcade;
	public Arm arm; // declaring the arm
	public Dropper dropper;	
	
	//Autonomous stuff
	private SendableChooser passAutoLineOnly;
	private SendableChooser rightOrLeft;
	
	//Camera
	private CameraServer cameraServer;
	/**
	 * Autonomous {@link Runnable} instance
	 */
	private Runnable autonomousRunnable = () -> {
		AutonomousRunner.run((boolean) passAutoLineOnly.getSelected(), (String) rightOrLeft.getSelected());
	};
	/**
	 * Teleop {@link Runnable} instance
	 */
	private Runnable teleopRunnable = () -> {
		//Drives the robot by the values from the joystick.
		while(true) {
			this.chassisArcade.tankDrive(-mainDriverStick.getAxis(AxisType.kX), mainDriverStick.getAxis(AxisType.kY));
			this.arm.control(systemsDriver);
			this.dropper.control(systemsDriver);	
			Timer.delay(0.05);
		}
	};
	/**
	 * Initializes camera
	 */
	private Runnable cameraThread = () -> {
		/*while(!cameraServer.isAutoCaptureStarted()) {
			cameraServer = CameraServer.getInstance();
			cameraServer.startAutomaticCapture("cam0");
			Timer.delay(5);
		}*/
	};
	
	/**
	 * Constructor
	 */
	public Robot() {
		mainDriverStick = new Joystick(ButtonPorts.k_MAIN_DRIVER_JOYSTICK); // Main driver's joystick
		systemsDriver = new Joystick(ButtonPorts.k_SYSTEMS_DRIVER_JOYSTICK); //Systems driver's joystick 

		arm = new Arm(); /**{@link Arm} init*/
		dropper = new Dropper(); /**{@link Dropper} init*/
		chassisArcade = new ChassisArcade(); /**{link ChassisArcade} init*/
		//Camera init
		System.out.println("started");
		//new Thread(cameraThread).start();
		
		cameraServer = CameraServer.getInstance();
		cameraServer.setQuality(50);
		cameraServer.startAutomaticCapture("cam0");
	}
	/**
	 * Robot initialize function
	 */
	public void robotInit() {
		initChoosers();	
	}
	
	/**
	 * Initialize chooser objects
	 */
	private void initChoosers(){
		passAutoLineOnly = new SendableChooser();
		rightOrLeft = new SendableChooser();
		
		
		//Pass autonomous line only chooser options
		passAutoLineOnly.addDefault("No", false);
		passAutoLineOnly.addObject("Yes", true);
		SmartDashboard.putData("Pass autonomous line only?", passAutoLineOnly);
		
		//Right or left chooser options
		rightOrLeft.addDefault("Left", "Left");
		rightOrLeft.addObject("Right", "Right");
		SmartDashboard.putData("Starting left or right of target", rightOrLeft);
	}

	/**
	 * Spawns autonomous thread
	 */
	@SuppressWarnings("deprecation")
	public void autonomous() {
		Thread autonomousThread = new Thread(autonomousRunnable);
		autonomousThread.start();
		while(isAutonomous() && isEnabled()){Timer.delay(0.05);}
		autonomousThread.stop();
	}

	/**
	 * Spawns teleop thread
	 */
	@SuppressWarnings("deprecation")
	public void operatorControl() {
		Thread teleopThread = new Thread(teleopRunnable);
		teleopThread.start();
		while (isOperatorControl() && isEnabled()) {}
		teleopThread.stop();
	}

	/**
	 * Runs during test mode
	 */
	public void test() {
	}
}