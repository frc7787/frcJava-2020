/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexSystem;
import frc.robot.subsystems.IntakeSystem;

public class SIntakeIndex extends CommandBase {
  
  IntakeSystem sIntake;
  IndexSystem sIndex;
  
  public SIntakeIndex(IntakeSystem intakeSystem, IndexSystem indexSystem) {
    sIntake = intakeSystem;
    sIndex = indexSystem;
    addRequirements(sIntake, sIndex);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sIntake.stop();
    sIndex.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sIntake.stop();
    sIndex.stop();
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
