package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.subsystems.Arm.Arm;
import org.usfirst.frc.team5951.subsystems.Dropper.Dropper;
import org.usfirst.frc.team5951.subsystems.chassis.ChassisArcade;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
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
	private SendableChooser dropStack;

	public Robot() {
		mainDriverStick = new Joystick(ButtonPorts.k_MAIN_DRIVER_JOYSTICK); // Main driver's joystick
		systemsDriver = new Joystick(ButtonPorts.k_SYSTEMS_DRIVER_JOYSTICK); //Systems driver's joystick 

		arm = new Arm(); /**{@link Arm} init*/
		dropper = new Dropper(); /**{@link Dropper} init*/
		chassisArcade = new ChassisArcade(); /**{link ChassisArcade} init*/
	}

	public void robotInit() {
		//Choosers init
		passAutoLineOnly = new SendableChooser();
		rightOrLeft = new SendableChooser();
		dropStack = new SendableChooser();
		
		
		//Pass autonomous line only chooser options
		passAutoLineOnly.addDefault("No", false);
		passAutoLineOnly.addObject("Yes", true);
		SmartDashboard.putData("Pass autonomous line only?", passAutoLineOnly);
		
		//Right or left chooser options
		rightOrLeft.addDefault("Left", "Left");
		rightOrLeft.addObject("Right", "Right");
		SmartDashboard.putData("Starting left or right of target", rightOrLeft);
		
		//Drop or not drop, that is the question (of the chooser)
		dropStack.addDefault("Yes", true);
		dropStack.addObject("no", false);
		SmartDashboard.putData("Drop stack?", dropStack);		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * if-else structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomous() {
		AutonomousRunner.run((boolean) passAutoLineOnly.getSelected(), (String) rightOrLeft.getSelected(), (boolean)dropStack.getSelected());
	}

	/**
	 * Runs the motors with arcade steering.
	 */
	public void operatorControl() {
		while (isEnabled() && isOperatorControl()) {
			//Drives the robot by the values from the joystick.
			this.chassisArcade.tankDrive(mainDriverStick.getAxis(AxisType.kX), mainDriverStick.getAxis(AxisType.kY));
			
			//Arm functionality
			if (mainDriverStick.getPOV() == ButtonPorts.k_POV_UP) { // 0 is up on the POV, so we raise the arm.
				this.arm.armUp();
			}
			else if (mainDriverStick.getPOV() == ButtonPorts.k_POV_DOWN) { // 180 is down on the POV, so we lower the arm.
				this.arm.armDown();
			} else {
				// Stops the arm
				this.arm.stop();
			}
			
			//Dropper functionality
			if(mainDriverStick.getRawButton(ButtonPorts.k_DROP_ALL_BLACKS)){
				this.dropper.forward();
			} else if (mainDriverStick.getRawButton(ButtonPorts.k_INTAKE)){
				this.dropper.intake();
			} else if (mainDriverStick.getRawButton(ButtonPorts.k_OUTAKE)){
				this.dropper.outTake();
			} else {
				this.dropper.stop();
			}
			
			Timer.delay(0.05);
		}
	}

	/**
	 * Runs during test mode
	 */
	public void test() {
	}
}