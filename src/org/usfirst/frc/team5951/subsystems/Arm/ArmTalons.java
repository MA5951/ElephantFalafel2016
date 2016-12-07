package org.usfirst.frc.team5951.subsystems.Arm;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class ArmTalons {
	public static CANTalon liftMotor = new CANTalon(RobotMap.k_LIFTMOTORTALON); // declare the CANTalon
}
