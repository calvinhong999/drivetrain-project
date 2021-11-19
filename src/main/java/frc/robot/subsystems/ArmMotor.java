// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmMotor extends SubsystemBase {
  /** Creates a new Arm. */
  
  public static final class Config {
    
    public static final int armMotorID = 1;
    //sets arm motor ID
    }
  
  private CANSparkMax armMotor = new CANSparkMax(Config.armMotorID, MotorType.kBrushless);
  //creates arm
    
    public ArmMotor() {
    
    
  }
  public void setArmUp(){
  armMotor.set(1);
  //sets arm to up

  }

  public void setArmDown(){
  armMotor.set(-1);
  //setes arm down
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
