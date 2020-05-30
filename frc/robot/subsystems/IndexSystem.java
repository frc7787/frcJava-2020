/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class IndexSystem extends SubsystemBase {
  
  PWMVictorSPX indexMotor = new PWMVictorSPX(ShooterConstants.SETTER);

  public IndexSystem() {
    indexMotor.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setter() {
    indexMotor.set(0.5);
  }

  public void stop() {
    indexMotor.set(0);
  }

  public void dumper() {
    indexMotor.set(-0.4);
  }

}
