package org.usfirst.frc.team5951.subsystems.Dropper;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class DropperTalons {
	public static CANTalon leftDropperMotor = new CANTalon(RobotMap.k_DROPPER_TALON_A);
	public static CANTalon rightDropperMotor = new CANTalon(RobotMap.k_DROPPER_TALON_B);
}
