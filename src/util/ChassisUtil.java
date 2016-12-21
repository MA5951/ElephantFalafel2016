package util;
/**
 * Utility functions for the Chassis subsystem
 */
public class ChassisUtil {
	/**
	 * Converts rotate and move values to tank values
	 * @param rotateValue - given rotate value (0-1)
	 * @param moveValue - given move value (0-1)
	 * @return Tank drive values
	 */
	public static double[] arcadeDrive(double rotateValue, double moveValue){
		rotateValue *= -1;
		double leftMotorSpeed;
		double rightMotorSpeed;
		if (true) {

		      if (moveValue >= 0.0) {
		        moveValue = (moveValue * moveValue);
		      } else {
		        moveValue = -(moveValue * moveValue);
		      }
		      if (rotateValue >= 0.0) {
		        rotateValue = (rotateValue * rotateValue);
		      } else {
		        rotateValue = -(rotateValue * rotateValue);
		      }
		    }

		    if (moveValue > 0.0) {
		      if (rotateValue > 0.0) {
		        leftMotorSpeed = moveValue - rotateValue;
		        rightMotorSpeed = moveValue > rotateValue ? moveValue : rotateValue;
		      } else {
		        leftMotorSpeed = Math.max(moveValue, -rotateValue); 
		        rightMotorSpeed = moveValue + rotateValue;
		      }
		    } else {
		      if (rotateValue > 0.0) {
		        leftMotorSpeed = -Math.max(-moveValue, rotateValue);
		        rightMotorSpeed = moveValue + rotateValue;
		      } else {
		        leftMotorSpeed = moveValue - rotateValue;
		        rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
		      }
		    }
    	double[] result = {leftMotorSpeed, rightMotorSpeed};
    	return result;
	}
	/**
	 * Calculates distance per pulse for given wheel radius
	 * @param wheelRadius - Raduis of wheel connected to encoder (centimeters)
	 * @return Distance per pulse value (centimeters) 
	 */
	public static double getDPPByRadius(double wheelRadius){
		return (wheelRadius*2*Math.PI)/360;
		
	}
}
