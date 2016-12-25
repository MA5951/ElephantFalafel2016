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
	public static final int k_CHASSIS_RIGHT_REAR = 4;
	
	//Encoder distance per pulse
	public static final double k_CHASSIS_ENCODER_DEGREES = 1;
	public static final double k_CHASSIS_ENCODER_RAD = (2*Math.PI)/360;
	
	//Sensors ports
	//Encoders
	public static final int k_CHASSIS_LEFT_ENCODER_A = 8;
	public static final int k_CHASSIS_LEFT_ENCODER_B = 7;
	public static final int k_CHASSIS_RIGHT_ENCODER_A =6;
	public static final int k_CHASSIS_RIGHT_ENCODER_B = 5;

	//Arm ports
	public static final int k_LIFT_MOTOR_TALON = 7; // port for CANTalon for arm/lift
	public static final int k_LIFT_MICROSWITCH = 4;
	
	//Dropper Ports
	public static final int k_DROPPER_TALON_LEFT = 5;
	public static final int k_DROPPER_TALON_RIGHT = 6;
	


}