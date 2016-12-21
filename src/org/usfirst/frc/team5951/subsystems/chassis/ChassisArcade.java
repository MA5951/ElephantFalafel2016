package org.usfirst.frc.team5951.subsystems.chassis;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;
import util.ChassisUtil;

/**
 * ChassisArcade class, used to control the chassis during the operator control period
 * Uses calculations from the util package to calculate power to the left side of the chassis
 * and power to the right side of the chassis
 * @author Yair Ziv
 */
public class ChassisArcade {
	
	//Talons
	private CANTalon chassisLeftFront;
	private CANTalon chassisLeftRear;
	private CANTalon chassisRightFront;
	private CANTalon chassisRightRear;
	
	//Encoder
	private Encoder encoderLeft;
	private Encoder encoderRight;
	
	/**	
	 *	{@link ChassisArcade} Constructor, initiates components.
	*/
	public ChassisArcade(){
		chassisLeftFront = ChassisComponents.chassisLeftFront;
		chassisLeftRear = ChassisComponents.chassisLeftRear;
		chassisRightFront = ChassisComponents.chassisRightFront;
		chassisRightRear = ChassisComponents.chassisRightRear;
		
		chassisLeftFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisLeftRear.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightRear.changeControlMode(TalonControlMode.PercentVbus);
		chassisLeftRear.setInverted(true);
//		chassisRightRear.setInverted(true);
//		chassisRightFront.setInverted(true);
//		chassisLeftFront.setInverted(true);
		
		encoderLeft = ChassisComponents.leftChassisEncoder;
		encoderRight = ChassisComponents.rightChassisEncoder;
		
//		encoderLeft.
		encoderRight.setReverseDirection(false);
	
		encoderLeft.setDistancePerPulse(1.0 / 438);
		encoderRight.setDistancePerPulse(1.0 / 632); 
	}
	
	/**
	 * Sends the values to the motors after being calculated by the {@link ChassisUtil}
	 * @param rotateValue - Gotten from the driver's joystick
	 * @param moveValue - Gotten from the driver's joystick
	 */
	public void tankDrive(double rotateValue, double moveValue){
		double[] values = util.ChassisUtil.arcadeDrive(rotateValue, moveValue);
		
		this.setLeftChassisPower(values[0]);
		this.setRightChassisPower(values[1]);
	}
		
	/**
	 * Since we send the same power to both motors of the chassis, 
	 * I created a method to set them both at the same time
	 * @param power - power to send to each of the motors
	 */
	private void setLeftChassisPower(double power){
		this.chassisLeftFront.set(power);
		this.chassisLeftRear.set(power);
	}
	
	/**
	 * Since we send the same power to both motors of the chassis, 
	 * I created a method to set them both at the same time.
	 * @param power - power to send to each of the motors
	 */
	private void setRightChassisPower(double power){
		this.chassisRightFront.set(power);
		this.chassisRightRear.set(power);
	}
	
	
	public double getEncoderVlaueLeft(){
		return this.encoderLeft.getDistance();
	}
	
	public double getEncoderValueRight(){
		return this.encoderRight.getDistance();
	}
	
	public void resetEncoders(){
		this.encoderLeft.reset();
		this.encoderRight.reset();
	}
	
}
