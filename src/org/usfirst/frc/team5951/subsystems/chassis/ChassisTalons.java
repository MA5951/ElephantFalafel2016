package org.usfirst.frc.team5951.subsystems.chassis;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

public class ChassisTalons {
	public static CANTalon chassisLeftFront = new CANTalon(RobotMap.k_CHASSIS_LEFT_FRONT);   
	public static CANTalon chassisLeftRear = new CANTalon(RobotMap.k_CHASSIS_LEFT_REAR);    
	public static CANTalon chassisRightFront = new CANTalon(RobotMap.k_CHASSIS_RIGHT_FRONT);  
	public static CANTalon chassisRightRear = new CANTalon(RobotMap.k_CHASSIS_RIGHT_REAR);  
}
