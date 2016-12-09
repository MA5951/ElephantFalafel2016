package org.usfirst.frc.team5951.subsystems.chassis;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Components for the chassis e.g. motors, sensors etc.
 * @author Yair Ziv
 *
 */
public class ChassisComponents {
	//Motors
	public static CANTalon chassisLeftFront = new CANTalon(RobotMap.k_CHASSIS_LEFT_FRONT);   
	public static CANTalon chassisLeftRear = new CANTalon(RobotMap.k_CHASSIS_LEFT_REAR);    
	public static CANTalon chassisRightFront = new CANTalon(RobotMap.k_CHASSIS_RIGHT_FRONT);  
	public static CANTalon chassisRightRear = new CANTalon(RobotMap.k_CHASSIS_RIGHT_REAR);
	
	//Sensors
	//Encoders
	public static Encoder leftChassisEncoder = new Encoder(RobotMap.k_CHASSIS_LEFT_ENCODER_A, RobotMap.k_CHASSIS_LEFT_ENCODER_B);
	public static Encoder rightChassisEncoder = new Encoder(RobotMap.k_CHASSIS_RIGHT_ENCODER_A, RobotMap.k_CHASSIS_RIGHT_ENCODER_B);	
}