package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase{
 
    public static final class Config{
        //motor ids
        public static final int leftMasterMotorID = 2;
        public static final int rightMasterMotorID = 1;
        //public static final int leftSlaveMotorID = 4;
        //public static final int rightSlaveMotorID = 2;
    
    }
    //defines motors
    private CANSparkMax leftMasterMotor = new CANSparkMax(Config.leftMasterMotorID, MotorType.kBrushless);
    private CANSparkMax rightMasterMotor = new CANSparkMax(Config.rightMasterMotorID, MotorType.kBrushless);
    //private CANSparkMax leftSlaveMotor = new CANSparkMax(Config.leftSlaveMotorID, MotorType.kBrushless);
    //private CANSparkMax rightSlaveMotor = new CANSparkMax(Config.rightSlaveMotorID, MotorType.kBrushless);
        
    //differential drive(two sides drive differently)
    public DifferentialDrive m_Drive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);
    

    public DriveTrain () {
        //invert the motors cuz robots wack
        leftMasterMotor.setInverted(true);
        rightMasterMotor.setInverted(true);
        
        //make the slaves follow the masters(motors)
        //leftSlaveMotor.follow(leftMasterMotor);
        //rightSlaveMotor.follow(rightMasterMotor);
    }

    public void setBrakeMode() {
        //sets motors to brakemode
        leftMasterMotor.setIdleMode(IdleMode.kBrake);
        rightMasterMotor.setIdleMode(IdleMode.kBrake);
        //leftSlaveMotor.setIdleMode(IdleMode.kBrake);
        //rightSlaveMotor.setIdleMode(IdleMode.kBrake);
        
    }
   
    public void setCoastMode() {
        //sets motor to coast mode(bad)
        leftMasterMotor.setIdleMode(IdleMode.kCoast);
        rightMasterMotor.setIdleMode(IdleMode.kCoast);
        //leftSlaveMotor.setIdleMode(IdleMode.kCoast);
        //rightSlaveMotor.setIdleMode(IdleMode.kCoast);
        
    }
    

    public DifferentialDrive getDifferentialDrive() {
        //sets to differential drive (duh)
        return m_Drive;
    }

    public IdleMode getMotorMode(){
        return rightMasterMotor.getIdleMode();
    }
}
    
