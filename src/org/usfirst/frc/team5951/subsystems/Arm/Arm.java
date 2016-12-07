package org.usfirst.frc.team5951.subsystems.Arm;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

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
	 * method for lifting the arm up
	 */
	public void liftUp() {
		liftMotor.set(1);

	}

	/**
	 * method for making the arm go down
	 */
	public void liftDown() {
		liftMotor.set(-1);
	}

}
/*
 * last update: 7.12.16 programmed by Omer Libai changed: Created class
 * ArmTalons and put the CATTalon there. update before: 2.12.16 programmed by
 * Omer Libai
 */
