package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.subsystems.Arm.Arm;
import org.usfirst.frc.team5951.subsystems.Dropper.Dropper;
import org.usfirst.frc.team5951.subsystems.chassis.ChassisPID;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * Class to run the autonomous command.
 * 
 * @author Yair Ziv, Omer Libai, Tomer Asher
 */
public class Autonomous {
	static ChassisPID chassisPID = new ChassisPID();
	static Arm autoArm = new Arm();
	static Dropper dropper = new Dropper();
	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public static void run(boolean passAutoOnly, String leftOrRight, boolean dropStack) {
		gyro.reset();
		if (passAutoOnly) {

			chassisPID.drive(2.4);

		} else {
			// Dropping the stack
			if (dropStack) {
				chassisPID.drive(-2);
				chassisPID.drive(2);
			}

			// Moving forward
			chassisPID.drive(2.12);

			// Turning right or left according to the chooser, continues straight and turning back again.
			if (leftOrRight.equals("Left")) {
				while (gyro.getAngle() < 90) {
					chassisPID.rotateRight();
				}
				chassisPID.stopChassis();
				chassisPID.drive(3.5);
				gyro.reset();
				while (gyro.getAngle() > 270 || gyro.getAngle() == 0) {
					chassisPID.rotateLeft();
				}
				chassisPID.stopChassis();
			} else {
				while (gyro.getAngle() > 270 || gyro.getAngle() == 0) {
					chassisPID.rotateLeft();
				}
				chassisPID.stopChassis();
				chassisPID.drive(3.5);
				gyro.reset();
				while (gyro.getAngle() < 0) {
					chassisPID.rotateRight();
				}
				chassisPID.stopChassis();
			}
		}
	}
}
