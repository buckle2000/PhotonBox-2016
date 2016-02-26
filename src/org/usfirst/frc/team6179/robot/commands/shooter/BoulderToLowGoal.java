package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BoulderToLowGoal extends CommandGroup {
    
    public  BoulderToLowGoal() {
    	addSequential(new ShootBoulder());
    	addSequential(new ReleaseBoulder());
    	addSequential(new ShooterDoNothing());
    	addSequential(new HoldBoulder());
    }
}
