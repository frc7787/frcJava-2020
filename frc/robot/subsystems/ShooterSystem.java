/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSystem extends SubsystemBase {
  
  CANSparkMax shooter = new CANSparkMax(ShooterConstants.CAN_NEO, MotorType.kBrushless);

  public ShooterSystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot() {
    shooter.set(-0.90);
  }

  public void autoshoot() {
    shooter.set(-1);
  }

  public void halfpower() {
    shooter.set(-0.3);
  }

  public void stop() {
    shooter.set(0);
  }

  public void dumper() {
    shooter.set(0.4);
  }

  public void intake() {
    shooter.set(1);
  }
}
