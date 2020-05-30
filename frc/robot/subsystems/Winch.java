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

public class Winch extends SubsystemBase {
  
  PWMVictorSPX winchMotor = new PWMVictorSPX(ShooterConstants.WINCH);

  public Winch() {
    winchMotor.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climb(double dPad) {
  
    if(dPad == 0) {
      winchMotor.set(1);
    } else if(dPad == 180) {
      winchMotor.set(-1);
    } else {
      winchMotor.set(0);
      winchMotor.stopMotor();
    }

  }
}
