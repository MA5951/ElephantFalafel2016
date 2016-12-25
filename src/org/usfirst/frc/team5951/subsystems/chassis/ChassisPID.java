package org.usfirst.frc.team5951.subsystems.chassis;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private  CANTalon chassisRightRear;
	
	//Encoders
	private Encoder chassisEncoderLeft;
	private Encoder chassisEncoderRight;
	
	//Gyro
	private ADXRS450_Gyro gyro;
	
	//PIDControllers
	private PIDController leftController;
	private PIDController rightController;
	
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
		chassisRightRear.reverseOutput(true);
		
		chassisLeftRear.changeControlMode(TalonControlMode.Follower);
        chassisRightRear.changeControlMode(TalonControlMode.Follower);
        chassisLeftFront.changeControlMode(TalonControlMode.PercentVbus);
        chassisRightFront.changeControlMode(TalonControlMode.PercentVbus);
		
        chassisRightFront.setInverted(true);
        chassisLeftRear.reverseOutput(true);
        chassisLeftFront.setInverted(true);
        
		//Encoders init
		chassisEncoderLeft = ChassisComponents.leftChassisEncoder;
		chassisEncoderRight = ChassisComponents.rightChassisEncoder;
		chassisEncoderRight.setDistancePerPulse(Math.PI*15.24 / 265);
        chassisEncoderLeft.setDistancePerPulse(Math.PI*15.24 / 360);
        
        //GyroInit
        gyro = ChassisComponents.gyro;
		
		//PIDControllers init
		leftController = new PIDController(k_KP_LEFT, k_KI_LEFT, k_KD_LEFT, chassisEncoderLeft, chassisLeftFront);
		rightController = new PIDController(k_KP_RIGHT, k_KI_RIGHT, k_KD_RIGHT, chassisEncoderRight, chassisRightFront);
		
		//Controllers data
		leftController.setAbsoluteTolerance(0.01);
		rightController.setAbsoluteTolerance(0.01);
	}
	
	
	/**
	 * Chassis drives to a certain distance
	 * @param distance - distance in meters
	 */
	public void drive(double distance){
		leftController.setSetpoint(distance);
		rightController.setSetpoint(distance);
		
		chassisEncoderRight.reset();
		chassisEncoderLeft.reset();
		
		gyro.reset();
		
		enableAllControllers();
		
		while(!leftController.onTarget() || !rightController.onTarget()){
			chassisLeftRear.set(chassisLeftFront.getDeviceID());
			chassisRightRear.set(chassisRightFront.getDeviceID());
		}
		
		leftController.disable();
    	rightController.disable();
    	while(!isAbsoluteTolerance(gyro.getAngle(), 0.1)) {
    		chassisLeftFront.set(gyro.getAngle() > 0 ? -0.1 : 0.1);
    		chassisRightFront.set(gyro.getAngle() > 0 ? 0.1 : -0.1);
    		chassisLeftRear.set(chassisLeftFront.getDeviceID());
            chassisRightRear.set(chassisRightFront.getDeviceID());
            
    	}		
		
		disableAllControllers();
		
		stopChassis();
	}
	
	
	/**
	 * Enables all of the controllers at the same time and resets the encoders
	 */
	private void enableAllControllers(){
		leftController.enable();
		rightController.enable();
		
		chassisEncoderLeft.reset();
		chassisEncoderRight.reset();
	}
	
	
	/**
	 * Disables all controllers at the same time
	 */
	private void disableAllControllers(){
		leftController.disable();  
		rightController.disable(); 
		
		chassisLeftFront.set(0);
		chassisLeftRear.set(0);
		chassisRightFront.set(0);
		chassisRightRear.set(0);
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
		return this.leftController.onTarget() && this.rightController.onTarget();
	}
	
	 private static boolean isAbsoluteTolerance(double value, double tolerance){
	    	return value <= tolerance && value >= -tolerance;
	    }
	
}