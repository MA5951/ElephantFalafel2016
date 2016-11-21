package org.usfirst.frc.team5951.subsystems.chassis;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

public class ChassisTalons {
	protected static CANTalon chassisLeftFront = new CANTalon(RobotMap.k_CHASSIS_LEFT_FRONT);   
	protected static CANTalon chassisLeftRear = new CANTalon(RobotMap.k_CHASSIS_LEFT_REAR);    
	protected static CANTalon chassisRightFront = new CANTalon(RobotMap.k_CHASSIS_RIGHT_FRONT);  
	protected static CANTalon chassisRightRear = new CANTalon(RobotMap.k_CHASSIS_RIGHT_REAR);  
}
