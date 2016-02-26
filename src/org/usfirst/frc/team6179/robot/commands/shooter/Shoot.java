package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
    
    public  Shoot() {
    	addParallel(new LiftUp());
    	addParallel(new ShootBoulder());
    	addParallel(new ReleaseBoulder());
    }
}
