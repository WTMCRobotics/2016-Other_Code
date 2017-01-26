package org.usfirst.frc.team6101.robot.commands;

import org.usfirst.frc.team6101.robot.RobotMap;

import org.usfirst.frc.team6101.robot.Robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6101.robot.subsystems.Drivetrain;


/**
 *
 */
public class Calibration extends Command {
	
	public Calibration() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.resetEncoders();
    	// Way to set a specific amount of time until encoders stop
    	double[] bothRevs = Robot.driveTrain.getRevolutions();    
	
    	// bothRevs[0] = left; bothRevs[1] = right;
    	if (bothRevs[1] > bothRevs[0]) {
		Robot.driveTrain.slowRight(bothRevs[0], bothRevs[1]);
    	//if number of the right motor is more than the left motor the robot will turn right
    	} 
    	else if (bothRevs[1] < bothRevs[0]) {
		Robot.driveTrain.slowLeft(bothRevs[0], bothRevs[1]);
    	//if number of the right motor is less than the left motor the robot will turn left
    	} 
    	else{
 		Robot.driveTrain.motorSame();	
    	//If the number of revolutions for both the left and right motors they both won’t change the direction (stay straight)
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
