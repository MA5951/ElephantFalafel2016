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
	private PIDController rightFrontController;
	
	//Other variables
	private final double k_KP_LEFT = 0.0045;
	private final double k_KI_LEFT = 0.00003;
	private final double k_KD_LEFT = 0;
	
	private final double k_KP_RIGHT = 0.004;
	private final double k_KI_RIGHT = 0.00003;
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
		chassisLeftRear.changeControlMode(TalonControlMode.Follower);
		chassisRightFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightRear.changeControlMode(TalonControlMode.Follower);
		
		chassisRightFront.setInverted(true);
        chassisLeftRear.reverseOutput(true);
        chassisLeftFront.setInverted(true);
		
		//Encoders init
		chassisEncoderLeft = ChassisComponents.leftChassisEncoder;
		chassisEncoderRight = ChassisComponents.rightChassisEncoder;
		chassisEncoderLeft.setDistancePerPulse(Math.PI * 15.24 / 360);
		chassisEncoderRight.setDistancePerPulse(Math.PI * 15.24 / 265); 
		
		//PIDControllers init
		leftFrontController = new PIDController(k_KP_LEFT, k_KI_LEFT, k_KD_LEFT, chassisEncoderLeft, chassisLeftFront);
		rightFrontController = new PIDController(k_KP_RIGHT, k_KI_RIGHT, k_KD_RIGHT, chassisEncoderRight, chassisRightFront);
		
		//Controllers data
		leftFrontController.setAbsoluteTolerance(0.1);
		rightFrontController.setAbsoluteTolerance(0.1);
	}
	
	
	/**
	 * Chassis drives to a certain distance
	 * @param distance - distance in meters
	 */
	public void drive(double distance){
		leftFrontController.setSetpoint(distance);
		rightFrontController.setSetpoint(distance);
		
		enableAllControllers();
		
		
		
		disableAllControllers();
	}
	
	
	/**
	 * Enables all of the controllers at the same time and resets the encoders
	 */
	private void enableAllControllers(){
		leftFrontController.enable();
		rightFrontController.enable();
		
		chassisEncoderLeft.reset();
		chassisEncoderRight.reset();
	}
	
	
	/**
	 * Disables all controllers at the same time
	 */
	private void disableAllControllers(){
		leftFrontController.disable();    
		rightFrontController.disable(); 
		
		chassisLeftFront.set(0);
		chassisLeftRear.set(0);
		chassisRightFront.set(0);
		chassisRightRear.set(0);
	}
	
	private void setSetpoint(double setpoint){
		this.leftFrontController.setSetpoint(setpoint);
		this.rightFrontController.setSetpoint(setpoint);
	}
	
	/**
	 * Rotates the robot to the left.
	 */
	public void rotateLeft(){
		chassisLeftFront.set(-0.8);
		chassisLeftRear.set(-0.8);
		chassisRightFront.set(0.8);
		chassisRightRear.set(0.8);
	}
	
	/**
	 * Rotates the robot to the right.
	 */
	public void rotateRight(){
		chassisLeftFront.set(0.8);
		chassisLeftRear.set(0.8);
		chassisRightFront.set(-0.8);
		chassisRightRear.set(-0.8);
	}
	
	/**
	 * Stops the chassis
	 */
	public void stopChassis(){
		chassisLeftFront.set(0);
		chassisLeftRear.set(0);
		chassisRightFront.set(0);
		chassisRightRear.set(0);
	}
	
	public boolean isInAllowedRange(){
		return this.leftFrontController.onTarget() && this.rightFrontController.onTarget();
	}
	
}