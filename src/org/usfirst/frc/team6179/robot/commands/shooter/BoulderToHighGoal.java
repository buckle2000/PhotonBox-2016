package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6179.robot.commands.DriveToDistance;
import org.usfirst.frc.team6179.robot.commands.Stow;

public class BoulderToHighGoal extends CommandGroup {
    
    public  BoulderToHighGoal() {
    	addSequential(new DriveToDistance(20,1,5));
    	addSequential(new Shoot());
    	addSequential(new Stow());
    }
}
