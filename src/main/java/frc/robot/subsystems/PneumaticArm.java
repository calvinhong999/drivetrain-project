// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class PneumaticArm extends SubsystemBase {
  /** Creates a new PneumaticSystem. */
  

  public static final class Config {

    public static final int moduleNumber = 4;
    public static final int forwardChannel = 2;
    public static final int reverseChannel = 0;      

  }

  private final DoubleSolenoid m_solenoid = new DoubleSolenoid(Config.moduleNumber, Config.forwardChannel, Config.reverseChannel);
  //new solenoid


  public PneumaticArm() {
  
  }

  public void setOff() {
    m_solenoid.set(Value.kOff);
  }

  public void setForward() {
    m_solenoid.set(Value.kForward);
  }

  public void setReverse() {
    m_solenoid.set(Value.kReverse);
  }
  //all of these are pretty self explanatory(sets the pneumatic arm to off, forward, and reverse)

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
