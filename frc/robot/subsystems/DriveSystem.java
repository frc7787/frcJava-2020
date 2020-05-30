/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveConstants;


public class DriveSystem extends SubsystemBase {

  public static DifferentialDrive drive;
  public static PWMVictorSPX leftBack = new PWMVictorSPX(driveConstants.LEFTBACK);
  public static PWMVictorSPX leftFront = new PWMVictorSPX(driveConstants.LEFTFRONT);
  public static PWMVictorSPX rightBack = new PWMVictorSPX(driveConstants.RIGHTBACK);
  public static PWMVictorSPX rightFront = new PWMVictorSPX(driveConstants.RIGHTFRONT);

  public DriveSystem() {
    leftFront.setInverted(true);
    leftBack.setInverted(false);
    rightFront.setInverted(true);
    rightBack.setInverted(false);
  } 

    public void drive (double speed, double rotation) {

      double right, left;

      if(speed < 0) {
        right = speed - rotation;
        left = speed + rotation;
      } else {
        right = speed + rotation;
        left = speed - rotation;
      }

      drive.tankDrive(left, right);

    }
    
    public void initDrive() {
      
      SpeedControllerGroup left = new SpeedControllerGroup(leftFront,leftBack);
      SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack);

      drive = new DifferentialDrive(left, right);

      drive.setDeadband(0);

      drive.setSafetyEnabled(false);

      System.out.println("DriveSystem initialized");
    }

    public void stop() {
      leftFront.set(0);
      leftBack.set(0);
      rightFront.set(0);
      rightBack.set(0);
    }
}
