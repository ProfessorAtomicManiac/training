package org.team199.trainingrobot.subsystems;

import org.team199.trainingrobot.Constants;
import org.team199.trainingrobot.commands.RunMotorsWithJoystick;
import org.team199.trainingrobot.commands.Teleoperated;
import org.team199.lib.MotorControllerFactory;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX  frontRight= MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final WPI_TalonSRX frontLeft = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final WPI_TalonSRX midRight = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final WPI_TalonSRX midLeft = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final WPI_TalonSRX backRight = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final WPI_TalonSRX backLeft = MotorControllerFactory.createTalon(Constants.Drive.kTalon);  
  private Joystick leftJoy;
  private Joystick rightJoy;
  
  // here. Call these from Commands.

    
  public Drivetrain() {
      boolean teleop = rightJoy.getTopPressed();
      if (teleop == true) {
          new Teleoperated();
      }
      }
      
      
  
  public void run(WPI_TalonSRX controller, double speed) {
      controller.set(speed);
  }

 
  
}
