package util;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Helper class that displays PID objects on the {@link SmartDashboard}
 * @author Yoav Rosen
 * @see <a href="http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/PIDController.html">PIDController</a> 
 */
public class DisplayPID{
	protected PIDController controller; // Notice me senpai
	protected String name;
	/**
	 * Constructor - Minimal
	 * @param controller - Controller to display.
	 */
	public DisplayPID(PIDController controller) {
		this(controller, controller.toString());
	}
	/**
	 * Constructor
	 * @param controller - Controller to display.
	 * @param name - Name to display on the {@link SmartDashboard}.
	 */
	public DisplayPID(PIDController controller, String name){
		this.controller = controller;
		this.name = name;
	}
	/**
	 * Update data displayed on the {@link SmartDashboard}.
	 */
	public void display(){
		SmartDashboard.putNumber("DisplayPIDSetpoint", controller.getSetpoint());
		SmartDashboard.putNumber("DisplayPIDValue - " + name, controller.get());
		
	}
}
