package org.usfirst.frc.team5951.subsystems.Dropper;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class Dropper {
	private CANTalon leftDropperMotor;
	private CANTalon rightDropperMotor;
//	private DigitalInput microSwitchHigh;
//	private DigitalInput microSwitchLow;

	public Dropper() {
		leftDropperMotor = DropperComponents.leftDropperMotor;
		rightDropperMotor = DropperComponents.rightDropperMotor;
		leftDropperMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightDropperMotor.changeControlMode(TalonControlMode.PercentVbus);
		leftDropperMotor.setInverted(true);
//		microSwitchHigh = new DigitalInput(RobotMap.k_MICROSWITCH_HIGH);
//		microSwitchLow = new DigitalInput(RobotMap.k_MICROSWITCH_LOW);
//		rightDropperMotor.reverseOutput(true);
//		leftDropperMotor.reverseOutput(false);
	}
	
	/**
	 * This function gets the value from the higher microswitch. while the limit switch is pressed (held), both talons will
	 * be set to 1, meaning the weigh will be taken forward until the limit switch gets released.
	 */
	public void intake() {
//		if(microSwitchHigh.get() && !microSwitchLow.get()){
//			leftDropperMotor.set(1);
//			rightDropperMotor.set(1);
//		} else {
//			leftDropperMotor.set(0);
//			rightDropperMotor.set(0);
//		}
		leftDropperMotor.set(-1);
		rightDropperMotor.set(-1);
	}
	
	/**
	 *This function put the talon on lowest power (-1) and the effect of this is that the wheels on the dropper go reverse 
	 */
	public void reverse() {
		rightDropperMotor.set(1);
		leftDropperMotor.set(1);
	}

	/**
	 *  This function put the talons on high power(1) and the effect of this is that the wheels on the dropper go forward 
	 */
	public void forward() {
		rightDropperMotor.set(-1);
		leftDropperMotor.set(-1);
	}

	/**
	 * This function put the talons on zero power and the effect of this is that the wheels on the dropper stop
	 */
	public void stop() {
		rightDropperMotor.set(0);
		leftDropperMotor.set(0);
	}

}
