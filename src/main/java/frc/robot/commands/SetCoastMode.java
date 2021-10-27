// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import com.revrobotics.CANSparkMax.IdleMode;

public class SetCoastMode extends CommandBase {
  /** Creates a new SetCoastMode. */
  
  private final DriveTrain m_driveTrain;
  
  public SetCoastMode(DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
  m_driveTrain = driveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  m_driveTrain.setCoastMode();
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_driveTrain.getMotorMode() == IdleMode.kCoast;
  }
}
