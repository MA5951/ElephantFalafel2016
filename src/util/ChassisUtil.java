package util;

public class ChassisUtil {

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
	
}
