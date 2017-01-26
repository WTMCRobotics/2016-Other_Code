package org.usfirst.frc.team6101.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6101.robot.RobotMap;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
  	DigitalInput upperLimit = new DigitalInput(0);
		DigitalInput lowerLimit = new DigitalInput(1);
		VictorSP armMotor = new VictorSP(2);
		// Counter increments when the sensor is triggered
		// May need to use int with a repeatedly called method
		// that checks if the limits have been hit. Then, increment
		// when they have been hit.
 		Counter upperCounter = new Counter(upperLimit);
		Counter lowerCounter = new Counter(lowerLimit);
		Joystick armJoystick = new Joystick(1);
		
		public Arm() {
			upperLimit.reset();
			lowerLimit.reset();
		}
	
		public boolean upperLimitReached() {
			boolean upperLimitMaxed = upperCounter.get() > 0;
			return upperLimitMaxed;
		}
	
		public boolean lowerLimitReached() {
			boolean lowerLimitMaxed = lowerCounter.get() > 0;
			return lowerLimitMaxed;
		}
	
		public double getInput() {
			double yAxis = -armJoystick.getRawAxis(1);
			return yAxis;
		}
		
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
}
