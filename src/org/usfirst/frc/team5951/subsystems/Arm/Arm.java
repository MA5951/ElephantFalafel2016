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
	 * constructor
	 */
	public Arm() {
		liftMotor = ArmTalons.liftMotor;
		liftMotor.changeControlMode(TalonControlMode.PercentVbus);
	}

	/**
	 * method for raising the arm
	 */
	public void armUp() {
		liftMotor.set(1);

	}

	/**
	 * method for lowering the arm
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
/*
 * last update: 8.12.16 
 * programmed by Omer Libai changed:
 *  Created class ArmTalons and put the CATTalon there.
 *  added method dontMove
 *  update before: 2.12.16 programmed by
 *  Omer Libai
 */
