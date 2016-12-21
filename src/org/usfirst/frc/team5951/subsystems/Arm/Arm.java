package org.usfirst.frc.team5951.subsystems.Arm;

import org.usfirst.frc.team5951.robot.ButtonPorts;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Class for the Arm subsystem.
 * Last updated: 2.12.16
 * @author Omer Libai
 */
public class Arm {

	private volatile CANTalon liftMotor;

	/**
	 * Constructor
	 */
	public Arm() {
		liftMotor = ArmComponents.liftMotor;
		liftMotor.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	/**
	 * Arm functionality
	 * @param stick - {@link Joystick} to control arm with
	 */
	public void control(Joystick stick){
		if (stick.getPOV() == ButtonPorts.k_POV_UP) { // 0 is up on the POV, so we raise the arm.
			this.armUp();
		}
		else if (stick.getPOV() == ButtonPorts.k_POV_DOWN) { // 180 is down on the POV, so we lower the arm.
			this.armDown();
		} else {
			// Stops the arm
			this.stop();
		}
	}
	/**
	 * Method for raising the arm
	 */
	public void armUp() {
		liftMotor.set(1);

	}

	/**
	 * Method for lowering the arm
	 */
	public void armDown() {
		liftMotor.set(-1);
	}

	/**
	 * Stops the lift
	 */
	public void stop() {
		liftMotor.set(0);
	}
}

