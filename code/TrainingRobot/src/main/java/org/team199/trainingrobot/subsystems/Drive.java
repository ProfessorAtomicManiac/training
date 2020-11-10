/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  private PWMTalonSRX leftTalon;
  private PWMVictorSPX leftVictor1;
  private PWMVictorSPX leftVictor2;
  private PWMTalonSRX rightTalon;
  private PWMVictorSPX rightVictor1;
  private PWMVictorSPX rightVictor2;
  private  boolean arcadeMode;
  
  public Drivetrain(PWMTalonSRX lt, PWMVictorSPX lv1, PWMVictorSPX lv2,PWMTalonSRX rt, PWMVictorSPX rv1, PWMVictorSPX rv2, Encoder le, Encoder re) {
    lt = leftTalon;
    lv1 = leftVictor1;
    lv2 = leftVictor2;
    rt = rightTalon;
    rv1 = rightVictor1;
    rv2 = rightVictor2;
    arcadeMode = true;
  }

  public boolean arcadeMode(){
    return arcadeMode;
  }

  public void setArcade(boolean arcade){
    arcadeMode = arcade;
  }
  
  public void tankDrive(double leftSpeed,double rightSpeed) {
    lefttalon.set(-leftSpeed);
    leftVictor1.set(-leftSpeed);
    leftVictor2.set(-leftSpeed);

    righttalon.set(rightSpeed);
    rightVictor1.set(rightSpeed);
    rightVictor2.set(rightSpeed);
  }

  public void arcadeDrive(double speed, double rotation) {
    leftTalon.set(-speed + rotation);
    leftVictor1.set(-speed + rotation);
    leftVictor2.set(-speed + rotation);

    righttalon.set(speed + rotation);
    rightVictor1.set(speed + rotation);
    rightVictor2.set(speed + rotation);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
