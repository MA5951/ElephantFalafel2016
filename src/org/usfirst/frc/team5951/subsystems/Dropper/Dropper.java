package org.usfirst.frc.team5951.subsystems.Dropper;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class Dropper {
	private CANTalon leftDropperMotor;
	private CANTalon rightDropperMotor;
	private DigitalInput microSwitch;
	
	public Dropper() {
		leftDropperMotor= new CANTalon(RobotMap.k_DROPPER_TALON_A);
		rightDropperMotor= new CANTalon(RobotMap.k_DROPPER_TALON_B);
		leftDropperMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightDropperMotor.changeControlMode(TalonControlMode.PercentVbus);
		microSwitch= new DigitalInput(RobotMap.k_MICROSWITCH);
	}
	
	public void intake() {
		if(!microSwitch.get()) {
			rightDropperMotor.set(1);
			leftDropperMotor.set(1);
		}
		else {
			rightDropperMotor.set(0);
			leftDropperMotor.set(0);
		}
	}
	public void reverse(){
		rightDropperMotor.set(-1);
		leftDropperMotor.set(-1);
	}
	public void forward(){
		rightDropperMotor.set(1);
		leftDropperMotor.set(1);
	}
	public void stop(){
		rightDropperMotor.set(0);
		leftDropperMotor.set(0);
	}
}
