package org.usfirst.frc.team5951.subsystems.Arm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * Class for the Arm subsystem.
 * Last updated: 2.12.16
 * @author Omer Libai
 */
public class Arm {

	private CANTalon liftMotor;

	/**
	 * Constructor
	 */
	public Arm() {
		liftMotor = ArmComponents.liftMotor;
		liftMotor.changeControlMode(TalonControlMode.PercentVbus);
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

