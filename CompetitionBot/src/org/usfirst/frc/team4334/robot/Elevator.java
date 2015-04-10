package org.usfirst.frc.team4334.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class Elevator {
	
    public static CANTalon elevatorMoter = new CANTalon(3);
    public static CANTalon elevatorMoter2 = new CANTalon(4);
	
    private static void Move(double speed){
    	elevatorMoter.set(speed);
		elevatorMoter2.set(speed);
    }
    
	private static void GoUp(double speed){
		Move(-speed);
	}
	
	private static void GoDown(double speed){
		Move(speed);
	}
	
	public static void manual(){
		if (Robot.limit2.get() == false || Robot.miranda.getRawAxis(2) < 0.01 && Robot.miranda.getRawAxis(3) < 0.01 || Robot.miranda.getRawAxis(2) > 0.01 && Robot.miranda.getRawAxis(3) > 0.01){
			Move(0);
		}
		else{
			if(Robot.miranda.getRawAxis(2) > 0.01){
				GoDown(Robot.miranda.getRawAxis(2));
			}
			else if(Robot.miranda.getRawAxis(3) > 0.01){
				GoUp(Robot.miranda.getRawAxis(3));
			}
		}
	}
	
	public static void GotoSetpoint(int SetPoint){
		if(Robot.elevatorR > SetPoint && Robot.elevatorMax == true && Robot.elevatorMin == true){
			GoDown(0.6);
		}
		else if(Robot.elevatorR > SetPoint && Robot.elevatorMax == true && Robot.elevatorMin == true){
			GoUp(0.6);
		}
		else{
			Move(0);
		}
		Cam.Auto(true);
	}
}
