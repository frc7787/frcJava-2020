/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.IndexSystem;
import frc.robot.subsystems.ShooterSystem;

public class Auto extends CommandBase {
  
  DriveSystem auto;
  ShooterSystem autoShooter;
  IndexSystem autoIndex;

  public Auto(DriveSystem driveSystem, ShooterSystem shooterSystem, IndexSystem indexSystem) {
    auto = driveSystem;
    autoShooter = shooterSystem;
    autoIndex = indexSystem;
    addRequirements(auto, autoShooter, autoIndex);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    auto.initDrive();
    System.out.println("Auto Init");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autoShooter.autoshoot();
    Timer.delay(3);
    autoIndex.setter();
    Timer.delay(2);
    autoShooter.stop();
    autoIndex.stop(); 
    auto.drive(0.5, 0);
    Timer.delay(2);
    auto.stop();
    System.out.println("Auto Done");

    //If front of line, power is 90 percent
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
