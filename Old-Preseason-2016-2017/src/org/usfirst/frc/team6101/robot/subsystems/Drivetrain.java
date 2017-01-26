package org.usfirst.frc.team6101.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6101.robot.RobotMap;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Encoder rEncoder = new Encoder(RobotMap.EncoderMap.RIGHT_ENCODER_FIRST_PORT, RobotMap.EncoderMap.RIGHT_ENCODER_SECOND_PORT, false, Encoder.EncodingType.k4X); 
	public Encoder lEncoder = new Encoder(RobotMap.EncoderMap.LEFT_ENCODER_FIRST_PORT, RobotMap.EncoderMap.RIGHT_ENCODER_SECOND_PORT, false, Encoder.EncodingType.k4X);
	public double rDrift, lDrift;
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
	
	public void resetEncoders(){
		rEncoder.reset();
		lEncoder.reset();
	}
	
	public double[] getRevolutions(){
		double [] revCounts = new double[2];
		lEncoder.setDistancePerPulse(2.0);
		rEncoder.setDistancePerPulse(2.0);
		
		double lRevs = lEncoder.getDistance()/360;// number of revolutions in place of 0
		double rRevs = rEncoder.getDistance()/360 ; // number of revolutions in place of 0
		revCounts[0] = lRevs;
		revCounts[1] = rRevs;
		return (revCounts);
	}
	
	public void slowRight(double lRevs, double rRevs){
		rDrift = lRevs/rRevs;
		lDrift = 1;
	}
	
	public void slowLeft(double lRevs, double rRevs){
		rDrift = 1;
		lDrift = rRevs/lRevs;
	}
	
	public void motorSame(){
		rDrift = 1;
		lDrift = 1;
	}
}
