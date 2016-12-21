package org.usfirst.frc.team5951.subsystems.Arm;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * Class containing the components of the Arm
 * @author User
 */
public class ArmComponents {
	public static CANTalon liftMotor = new CANTalon(RobotMap.k_LIFT_MOTOR_TALON); // declare the CANTalon
}
