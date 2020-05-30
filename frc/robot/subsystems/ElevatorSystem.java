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

public class ElevatorSystem extends SubsystemBase {
  
  public static PWMVictorSPX elevatorMotor = new PWMVictorSPX(ShooterConstants.ELEVATOR);

  public ElevatorSystem() {
    elevatorMotor.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climber(double speed) {
    elevatorMotor.set(speed);
  }

  public void stop() {
    elevatorMotor.set(0);
  }
}
