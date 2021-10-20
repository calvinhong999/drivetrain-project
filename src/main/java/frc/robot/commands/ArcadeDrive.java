package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
    
    public static final class Config {
        static int leftStickX = 6;
        static int rightStickX = 9;
        static double speedMult =  .1;
        static double turnMult = .2;
    }

    private final Joystick m_joystick;
    private final DriveTrain m_drivetrain;

    public ArcadeDrive (Joystick joystick, DriveTrain drivetrain) {

        addRequirements(m_drivetrain);

        m_joystick = joystick;
        m_drivetrain = drivetrain;

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        double speed = m_joystick.getRawAxis(Config.leftStickX) * Config.speedMult;
        double turn = m_joystick.getRawAxis(Config.rightStickX) * Config.turnMult;
        m_drivetrain.getDifferentialDrive().arcadeDrive(speed, turn);
    }

    public void end() {
        
    }

}

