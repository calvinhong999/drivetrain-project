package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
    
    public static final class Config {
    //configures the speed mult and turn mult, as well as the left and right stick port(?)
        static int leftStickX = 6;
        static int rightStickX = 9;
        static double speedMult = .8;
        static double turnMult = .7;
    }
    //defining joystick and drivetrain
    private final Joystick m_joystick;
    private final DriveTrain m_drivetrain;
    //uses arcade drive method with joystick and drivetrain
    public ArcadeDrive (Joystick joystick, DriveTrain drivetrain) {
        m_joystick = joystick;
        m_drivetrain = drivetrain;

        addRequirements(m_drivetrain);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        //gets rawaxis from left and right stick, and multiplies it by the speedn and turn multiplier
        double speed = m_joystick.getRawAxis(Config.leftStickX) * Config.speedMult;
        double turn = m_joystick.getRawAxis(Config.rightStickX) * Config.turnMult;
        m_drivetrain.getDifferentialDrive().arcadeDrive(speed, turn);
    }

    public void end(boolean interrupted) {
       m_drivetrain.getDifferentialDrive().stopMotor();
    }
    //its never finished
    public boolean isFinished() {
        return false;
    }

}

