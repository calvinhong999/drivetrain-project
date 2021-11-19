package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drivetrain extends SubsystemBase{
 
    public static final class Config{
        //motor ids
        public static final int leftMasterMotorID = 2;
        public static final int rightMasterMotorID = 1;
        //public static final int leftSlaveMotorID = 4;
        //public static final int rightSlaveMotorID = 2;
        public static final double resetValue = 0;
        public static final double kP = .5;
        public static final double kI = .5;
        public static final double kD = .5;
        //PID values(subject to change)
    
    }
    //defines motors
    private CANSparkMax leftMasterMotor = new CANSparkMax(Config.leftMasterMotorID, MotorType.kBrushless);
    private CANSparkMax rightMasterMotor = new CANSparkMax(Config.rightMasterMotorID, MotorType.kBrushless);
    //private CANSparkMax leftSlaveMotor = new CANSparkMax(Config.leftSlaveMotorID, MotorType.kBrushless);
    //private CANSparkMax rightSlaveMotor = new CANSparkMax(Config.rightSlaveMotorID, MotorType.kBrushless);
    //defines motors 
    
    private CANEncoder leftEncoder = leftMasterMotor.getEncoder();
    private CANEncoder rightEncoder = rightMasterMotor.getEncoder();
    //defines encoders
        
    public DifferentialDrive m_Drive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);
    //makes differential drive(two sides can drive differently)

    public Drivetrain () {
        
        leftMasterMotor.setInverted(true);
        rightMasterMotor.setInverted(true);
        //inverts the motors cuz they need that for some reason
       
        //leftSlaveMotor.follow(leftMasterMotor);
        //rightSlaveMotor.follow(rightMasterMotor); 
        //make the slaves follow the masters(motors)
    }

    public void setBrakeMode() {
        
        leftMasterMotor.setIdleMode(IdleMode.kBrake);
        rightMasterMotor.setIdleMode(IdleMode.kBrake);
        //leftSlaveMotor.setIdleMode(IdleMode.kBrake);
        //rightSlaveMotor.setIdleMode(IdleMode.kBrake);
        //sets all the motors to brake mode
        
    }
   
    public void setCoastMode() {
        
        leftMasterMotor.setIdleMode(IdleMode.kCoast);
        rightMasterMotor.setIdleMode(IdleMode.kCoast);
        //leftSlaveMotor.setIdleMode(IdleMode.kCoast);
        //rightSlaveMotor.setIdleMode(IdleMode.kCoast);
        //sets all motors to coast mode(only for moving)
        
    }

    public void getEncoderPosition() {
         System.out.println("left encoder position: " + leftEncoder.getPosition());
         System.out.println("right encoder position: " + rightEncoder.getPosition());
         //prints encoder positions

    }
    
    public void resetEncoderPosition() {
        leftEncoder.setPosition(Config.resetValue);
        rightEncoder.setPosition(Config.resetValue);
        //resets encoders to 0

    }

    public double returnEncoderPosition(){
        return rightEncoder.getPosition();
        //gets right encoder position
    }


    

    public DifferentialDrive getDifferentialDrive() {
        //sets to differential drive (duh)
        return m_Drive;
    }

    public IdleMode getMotorMode(){
        return rightMasterMotor.getIdleMode();
    }
}
    
