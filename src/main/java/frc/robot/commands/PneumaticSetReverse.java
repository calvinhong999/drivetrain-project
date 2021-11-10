// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticArm;

public class PneumaticSetReverse extends CommandBase {

  private final PneumaticArm m_pneumaticArm;

  public PneumaticSetReverse(PneumaticArm m_pneumaticArm) {

      this.m_pneumaticArm = m_pneumaticArm;

    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_pneumaticArm.setReverse();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

}
