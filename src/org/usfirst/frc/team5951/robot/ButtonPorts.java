package org.usfirst.frc.team5951.robot;

/**
 * ButtonPorts class, remember to put all button ports in this class, 
 * as public static final int number.
 * @author Yair Ziv
 */
public class ButtonPorts {
	
	//Joystick ports
	public static final int k_MAIN_DRIVER_JOYSTICK = 0;
	public static final int k_SYSTEMS_DRIVER_JOYSTICK = 1;
	
	//Button ports
	public static final int k_INTAKE = 6;
	public static final int k_OUTAKE = 5;
	public static final int k_DROP_ALL_BLOCKS = 1; //Drops the cubes
	public static final int k_ARM_MICROSWITCH_FAIL_SAFE = 8;
	
	//POV values
	public static final int k_POV_UP_MIN = 45;
	public static final int k_POV_UP_MAX = 315;
	public static final int k_POV_DOWN_MIN = 135;
	public static final int k_POV_DOWN_MAX = 225;
}
