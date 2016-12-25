package org.usfirst.frc.team5951.subsystems.Arm;

import org.usfirst.frc.team5951.robot.ButtonPorts;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;

/**
 * Class for the Arm subsystem.
 * Last updated: 2.12.16
 * @author Omer Libai
 */
public class Arm {

	private CANTalon liftMotor;
	private DigitalInput microswitch;
	private boolean isSensorsWorking;

	/**
	 * Constructor
	 */
	public Arm() {
		liftMotor = ArmComponents.liftMotor;
		liftMotor.changeControlMode(TalonControlMode.PercentVbus);
		microswitch = ArmComponents.microswitch;
		isSensorsWorking = true;
	}
	
	/**
	 * Arm functionality
	 * @param stick - {@link Joystick} to control arm with
	 */
	public void control(Joystick stick){
		if(stick.getPOV() == -1){
			this.stop();
			stick.setRumble(RumbleType.kLeftRumble, 0);
			stick.setRumble(RumbleType.kRightRumble, 0);
		}else if (stick.getPOV() <= ButtonPorts.k_POV_UP_MIN || stick.getPOV() >= ButtonPorts.k_POV_UP_MAX) { // 0 is up on the POV, so we raise the arm.
			this.armUp();
		}
		else if (stick.getPOV() >= ButtonPorts.k_POV_DOWN_MIN || stick.getPOV() <= ButtonPorts.k_POV_DOWN_MAX) { // 180 is down on the POV, so we lower the arm.
			this.armDown(stick);
		} else if(stick.getRawButton(ButtonPorts.k_ARM_MICROSWITCH_FAIL_SAFE)){
			this.isSensorsWorking = false;
		} else {
			// Stops the arm
			this.stop();
			stick.setRumble(RumbleType.kLeftRumble, 0);
			stick.setRumble(RumbleType.kRightRumble, 0);
		}
	}
	/**
	 * Method for raising the arm
	 */
	public void armUp() {
		this.liftMotor.set(1);
	}

	/**
	 * Method for lowering the arm
	 */
	public void armDown(Joystick stick) {
		if(!this.isSensorsWorking){
			this.liftMotor.set(-1);
		} else if(this.microswitch.get()){
			this.stop();
			stick.setRumble(RumbleType.kLeftRumble, 100);
			stick.setRumble(RumbleType.kRightRumble, 100);
		} else {
			this.liftMotor.set(-1);
		}
	}

	/**
	 * Stops the lift
	 */
	public void stop() {
		liftMotor.set(0);
	}
}

