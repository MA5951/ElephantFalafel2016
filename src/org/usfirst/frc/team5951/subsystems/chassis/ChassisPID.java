package org.usfirst.frc.team5951.subsystems.chassis;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * {@link ChassisPID} sub-subsystem, used to control the chassis in the autonomous period using PID
 * contol.
 * @author Yair Ziv
 */
public class ChassisPID {
	//Components
	//Motors
	private CANTalon chassisLeftFront;
	private CANTalon chassisLeftRear;
	private CANTalon chassisRightFront;
	private CANTalon chassisRightRear;
	
	//Encoders
	private Encoder chassisEncoderLeft;
	private Encoder chassisEncoderRight;
	
	//PIDControllers
	private PIDController leftFrontController;
	private PIDController leftRearController;
	private PIDController rightFrontController;
	private PIDController rightRearController;
	
	//Other variables
	private final double k_KP_LEFT = 0.3;
	private final double k_KI_LEFT = 0;
	private final double k_KD_LEFT = 0;
	
	private final double k_KP_RIGHT = 0.3;
	private final double k_KI_RIGHT = 0;
	private final double k_KD_RIGHT = 0;
	
	
	/**
	 * {@link ChassisPID} constructor
	 */
	public ChassisPID(){
		//Motors init
		chassisLeftFront = ChassisComponents.chassisLeftFront;
		chassisLeftRear = ChassisComponents.chassisLeftRear;
		chassisRightFront = ChassisComponents.chassisRightFront;
		chassisRightRear = ChassisComponents.chassisRightRear;
		
		chassisLeftFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisLeftRear.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightRear.changeControlMode(TalonControlMode.PercentVbus);
		
		//Encoders init
		chassisEncoderLeft = ChassisComponents.leftChassisEncoder;
		chassisEncoderRight = ChassisComponents.rightChassisEncoder;
		
		//PIDControllers init
		leftFrontController = new PIDController(k_KP_LEFT, k_KI_LEFT, k_KD_LEFT, chassisEncoderLeft, chassisLeftFront);
		leftRearController = new PIDController(k_KP_LEFT, k_KI_LEFT, k_KD_LEFT, chassisEncoderLeft, chassisLeftRear);
		rightFrontController = new PIDController(k_KP_RIGHT, k_KI_RIGHT, k_KD_RIGHT, chassisEncoderRight, chassisRightFront);
		rightRearController = new PIDController(k_KP_RIGHT, k_KI_RIGHT, k_KD_RIGHT, chassisEncoderRight, chassisRightRear);
		
		//Controllers data
		leftFrontController.setAbsoluteTolerance(0.1);
		leftRearController.setAbsoluteTolerance(0.1);
		rightFrontController.setAbsoluteTolerance(0.1);
		rightRearController.setAbsoluteTolerance(0.1);
	}
	
	
	/**
	 * Chassis drives to a certain distance
	 * @param distance - distance in meters
	 */
	public void drive(double distance){
		leftFrontController.setSetpoint(distance);
		leftRearController.setSetpoint(distance);
		rightFrontController.setSetpoint(distance);
		rightRearController.setSetpoint(distance);
		
		enableAllControllers();
		
		while(!leftFrontController.onTarget() && !leftRearController.onTarget()){
			
		}
		
		disableAllControllers();
	}
	
	
	/**
	 * Enables all of the controllers at the same time 
	 */
	private void enableAllControllers(){
		leftFrontController.enable();
		leftRearController.enable();
		rightFrontController.enable();
		rightRearController.enable();
	}
	
	
	/**
	 * Disables all controllers at the same time
	 */
	private void disableAllControllers(){
		leftFrontController.disable();  
		leftRearController.disable();   
		rightFrontController.disable(); 
		rightRearController.disable();  
		                               
	}
	
}
