// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class MoveWithPID extends CommandBase {
  
  /** Creates a new MoveWithPID. */

  private final DriveTrain m_drivetrain;
  private final double m_setPoint;
  
  private PIDController m_PID = new PIDController(DriveTrain.Config.kP, DriveTrain.Config.kI, DriveTrain.Config.kD);
  
  public MoveWithPID(DriveTrain drivetrain, double setPoint) {
    m_drivetrain = drivetrain;
    m_setPoint = setPoint;
    addRequirements(m_drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetEncoderPosition();
    m_PID.setSetpoint(m_setPoint);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     double speed = m_PID.calculate(m_drivetrain.returnEncoderPosition());
     m_drivetrain.getDifferentialDrive().tankDrive(speed,speed, false);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    m_drivetrain.getDifferentialDrive().stopMotor();
    
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_PID.atSetpoint();
  }
}
