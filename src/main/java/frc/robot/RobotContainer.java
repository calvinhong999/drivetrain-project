// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.MoveWithPID;
import frc.robot.commands.SetBrakeMode;
import frc.robot.commands.SetCoastMode;
import frc.robot.subsystems.ArmMotor;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static final class Config {

    public static final int joystickPort = 1;
    public static final int breakButton = 6;
    public static final int coastButton = 9;
    public static final int armUpButton = 2;
    public static final int armDownButton = 3;
    public static final int moveWithPIDButton = 4;
  }
  //defines final joystick, drivetrain, and arcadedrive
  private final DriveTrain m_drivetrain = new DriveTrain();
  private final Joystick m_joystick = new Joystick(Config.joystickPort);
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(m_joystick, m_drivetrain);
  private final JoystickButton m_breakButton = new JoystickButton(m_joystick, Config.breakButton);
  private final JoystickButton m_coastButton = new JoystickButton(m_joystick, Config.coastButton);
  private final ArmMotor m_armMotor = new ArmMotor();
  private final JoystickButton m_armDownButton = new JoystickButton(m_joystick, Config.armDownButton);
  private final JoystickButton m_armUpButton = new JoystickButton(m_joystick, Config.armUpButton);
  private final JoystickButton m_moveWithPIDButton = new JoystickButton(m_joystick, Config.moveWithPIDButton);
    
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  public Command getTeleopCommand() {

    m_drivetrain.setDefaultCommand(arcadeDrive);
     return arcadeDrive;
  }

 



  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_breakButton.whenPressed( new SetBrakeMode(m_drivetrain));
    m_coastButton.whenPressed( new SetCoastMode(m_drivetrain));
    m_armUpButton.whenPressed( new ArmUp(m_armMotor));
    m_armDownButton.whenPressed(new ArmDown(m_armMotor));
    m_moveWithPIDButton.whenPressed(new MoveWithPID(m_drivetrain, 5));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
