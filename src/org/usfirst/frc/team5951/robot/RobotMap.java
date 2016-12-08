package org.usfirst.frc.team5951.robot;

/**
 * RobotMap class, remember to put all ports in this class, as public static final int number.
 * @author Yair Ziv
 */
public class RobotMap {
	//Talon ports
	//Chassis ports
	public static final int k_CHASSIS_LEFT_FRONT = 1;
	public static final int k_CHASSIS_LEFT_REAR = 2;
	public static final int k_CHASSIS_RIGHT_FRONT = 3;
	public static final int k_CHASSIS_RIGHT_REAR  =4;
	
	//Sensors ports
	//Encoders
	public static final int k_CHASSIS_LEFT_ENCODER_A = 1;
	public static final int k_CHASSIS_LEFT_ENCODER_B = 2;
	public static final int k_CHASSIS_RIGHT_ENCODER_A = 3;
	public static final int k_CHASSIS_RIGHT_ENCODER_B = 4;
	
	
	public static final int k_LIFTMOTORTALON = 5951; // port for CANTalon for arm/lift
	public static final int k_PCMPORT = 420; // pcm port
	
}
