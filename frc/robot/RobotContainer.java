/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.Auto;
import frc.robot.commands.Eject;
import frc.robot.commands.Elevator;
import frc.robot.commands.Intake;
import frc.robot.commands.IntakeIndex;
import frc.robot.commands.SIntake;
import frc.robot.commands.SIntakeIndex;
import frc.robot.commands.SSetter;
import frc.robot.commands.SShooter;
import frc.robot.commands.SShooterIntake;
import frc.robot.commands.Setter;
import frc.robot.commands.Shooter;
import frc.robot.commands.ShooterHalfPower;
import frc.robot.commands.ShooterIntake;
import frc.robot.commands.TriggerDrive;
import frc.robot.commands.WinchClimb;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ElevatorSystem;
import frc.robot.subsystems.IndexSystem;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.subsystems.ShooterSystem;
import frc.robot.subsystems.Winch;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSystem driveSystem = new DriveSystem();
  private final IntakeSystem intakeSystem = new IntakeSystem();
  private final ShooterSystem shooterSystem = new ShooterSystem();
  private final ElevatorSystem elevatorSystem = new ElevatorSystem();
  private final IndexSystem indexSystem = new IndexSystem();
  private final Winch winchSystem = new Winch();

  private final Auto auto = new Auto(driveSystem, shooterSystem, indexSystem);

  Joystick stick = new Joystick(Constants.Driver_Controller);
  
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveSystem.setDefaultCommand(new TriggerDrive(driveSystem, ()->getForward(), ()->getTurn()));

    elevatorSystem.setDefaultCommand(new Elevator(elevatorSystem, ()->getClimb()));

    winchSystem.setDefaultCommand(new WinchClimb(winchSystem, ()->winchClimb()));
  }

  public double getForward() {
    double Trigger = stick.getRawAxis(3) - stick.getRawAxis(2);
    return Trigger;
  }

  public double getTurn() {
    double leftStick = stick.getRawAxis(0);
    return leftStick;
  }

  public double getClimb() {
    double rightStick = stick.getRawAxis(5);
    return -rightStick;
  }

  public double winchClimb() {
    double dPad = stick.getPOV();
    return dPad;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(stick, 1).whileHeld(new Intake(intakeSystem));
    new JoystickButton(stick, 1).whenReleased(new SIntake(intakeSystem));
    new JoystickButton(stick, 3).whileHeld(new Eject(intakeSystem));
    new JoystickButton(stick, 3).whenReleased(new SIntake(intakeSystem));
    new JoystickButton(stick, 5).whileHeld(new Setter(indexSystem));
    new JoystickButton(stick, 5).whenReleased(new SSetter(indexSystem));
    new JoystickButton(stick, 6).whileHeld(new Shooter(shooterSystem));
    new JoystickButton(stick, 6).whenReleased(new SShooter(shooterSystem));
    new JoystickButton(stick, 4).whileHeld(new IntakeIndex(intakeSystem, indexSystem));
    new JoystickButton(stick, 4).whenReleased(new SIntakeIndex(intakeSystem, indexSystem));
    new JoystickButton(stick, 2).whileHeld(new ShooterHalfPower(shooterSystem));
    new JoystickButton(stick, 2).whenReleased(new SShooter(shooterSystem));
    new JoystickButton(stick, 7).whileHeld(new ShooterIntake(indexSystem, shooterSystem));
    new JoystickButton(stick, 7).whenReleased(new SShooterIntake(indexSystem, shooterSystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Auto getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return auto;
  }
}
