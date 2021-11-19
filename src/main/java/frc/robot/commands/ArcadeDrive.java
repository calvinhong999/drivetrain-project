package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase {
    
    public static final class Config {
    
        static int leftStickX = 6;
        static int rightStickX = 9;
        static double speedMult = .8;
        static double turnMult = .7;
        //configures the speed mult and turn mult, as well as the left and right stick port
    }
    
    private final Joystick m_joystick;
    private final Drivetrain m_drivetrain;
    //creates instance variables for joystick and drive train
    
    public ArcadeDrive (Joystick joystick, Drivetrain m_drivetrain2) {
        m_joystick = joystick;
        m_drivetrain = m_drivetrain2;
        //creates arcadedrive class with joystick and drive train

        addRequirements(m_drivetrain);
        //adds a drivetrain requirement

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double speed = m_joystick.getRawAxis(Config.leftStickX) * Config.speedMult;
        double turn = m_joystick.getRawAxis(Config.rightStickX) * Config.turnMult;
        m_drivetrain.getDifferentialDrive().arcadeDrive(speed, turn);
        //gets rawaxis from left and right stick, and multiplies it by the speedn and turn multiplier

    }

    public void end(boolean interrupted) {
       m_drivetrain.getDifferentialDrive().stopMotor();
       //stops the motors
    }
    //its never finished
    public boolean isFinished() {
        return false;
    }

}

