package org.usfirst.frc.team5951.subsystems.chassis;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;
import util.ChassisUtil;

/* Chassis Arcade lass, used to control the chassis during the operator control period
 * Uses calculations from the util package to calculate power to the left side of the chassis
 * and power to the right side of the chassis
 * @author Yair Ziv
 */
public class ChassisArcade {
	
	private CANTalon chassisLeftFront;
	private CANTalon chassisLeftRear;
	private CANTalon chassisRightFront;
	private CANTalon chassisRightRear;
	
	/**	
	 *	{@link ChassisArcade} Constructor, initiates components.
	*/
	public ChassisArcade(){
		chassisLeftFront = ChassisComponents.chassisLeftFront;
		chassisLeftRear = ChassisComponents.chassisLeftRear;
		chassisRightFront = ChassisComponents.chassisRightFront;
		chassisRightRear = ChassisComponents.chassisRightRear;
		chassisRightRear.reverseOutput(true);
		chassisLeftRear.setInverted(true);
		chassisLeftFront.enableBrakeMode(false);
		chassisLeftRear.enableBrakeMode(false);
		chassisRightFront.enableBrakeMode(false);
		chassisRightRear.enableBrakeMode(false);
		chassisLeftFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisLeftRear.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightRear.changeControlMode(TalonControlMode.PercentVbus);
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
	public void setLeftChassisPower(double power){
		this.chassisLeftFront.set(power);
		this.chassisLeftRear.set(power);
	}
	
	/**
	 * Since we send the same power to both motors of the chassis, 
	 * I created a method to set them both at the same time.
	 * @param power - power to send to each of the motors
	 */
	public void setRightChassisPower(double power){
		this.chassisRightFront.set(power);
		this.chassisRightRear.set(power);
	}
	
	
}
