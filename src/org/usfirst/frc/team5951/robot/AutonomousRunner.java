package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.subsystems.Arm.Arm;
import org.usfirst.frc.team5951.subsystems.Dropper.Dropper;
import org.usfirst.frc.team5951.subsystems.chassis.ChassisArcade;
import org.usfirst.frc.team5951.subsystems.chassis.ChassisComponents;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Class to run the autonomous command.
 * 
 * @author Yair Ziv, Omer Libai, Tomer Asher
 */
public class AutonomousRunner {
	static Dropper dropper = Robot.dropper;
	static ChassisArcade chassisArcade = Robot.chassisArcade;
	static Arm arm = Robot.arm;
	static ADXRS450_Gyro gyro = ChassisComponents.gyro;
	/*static Ultrasonic frontUltrasonic = 
			new Ultrasonic(RobotMap.k_FRONT_ULTRASONIC_PING, RobotMap.k_FRONT_ULTRASONIC_ECHO);*/
	static DigitalInput in = new DigitalInput(9);
	/**
	 * Runs autonomous
	 * @param passAutoOnly - choosser parameter
	 * @param leftOrRight - chooser parameter
	 * @param dropStack - chooser parameter
	 */
	public static void run() {
		//double targetAngle = Math.toDegrees(Math.atan(12290.8-RobotMap.k_ROBOT_HEIGHT/1500+RobotMap.k_ROBOT_WIDTH));
		//double dist = Math.sqrt(Math.pow(12290.8-RobotMap.k_ROBOT_HEIGHT, 2) + Math.pow(1500+RobotMap.k_ROBOT_WIDTH, 2));
		double initTime = Timer.getFPGATimestamp();
		final int SECONDS = 5;
		while(Timer.getFPGATimestamp() - initTime < SECONDS){
			chassisArcade.setLeftChassisPower(0.4);
			chassisArcade.setRightChassisPower(0.4);
		}
		final int ARMSECONDS = 6;
		initTime = Timer.getFPGATimestamp();
		while(Timer.getFPGATimestamp() - initTime < ARMSECONDS){
			arm.armUp();
		}
		final int DROPPERSECONDS = 4;
		initTime = Timer.getFPGATimestamp();
		while(Timer.getFPGATimestamp() - initTime < DROPPERSECONDS){
			dropper.forward();
		}
		
	}
	/*private static boolean isAbsoluteTolerance(double value, double tolerance){
    	return value <= tolerance && value >= -tolerance;
	}*/
	public static void gyroCalibrate(){
		gyro.calibrate();
		
	}
}
