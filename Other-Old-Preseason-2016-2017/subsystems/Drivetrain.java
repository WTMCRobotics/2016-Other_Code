package org.usfirst.frc.team6101.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6101.robot.RobotMap;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
  Joystick xbox = new Joystick(0);
  VictorSP leftMotor = new VictorSP(0);
  VictorSP rightMotor = new VictorSP(1);
  
  public double[] getAxisInputs() {
    double[] axisArray = new double[2];
		axisArray[0] = xbox.getRawAxis(1);
		// 1 = y-axis left stick
    axisArray[1] = -xbox.getRawAxis(5);
		// 5 = y-axis right stick
		
    return axisArray;
  }
  
  public void setMotorSpeed(double inputValues[]) {
    double leftInputSquared = inputValues[0] * inputValues[0];
    double rightInputSquared = inputValues[1] * inputValues[1];
    if (inputValues[0] < 0) {
      leftMotor.set(-leftInputSquared);
    } else {
      leftMotor.set(leftInputSquared);
    }
    if (inputValues[1] < 0) {
      rightMotor.set(-rightInputSquared);
    } else {
      rightMotor.set(rightInputSquared);
    }
  }
  
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
}
