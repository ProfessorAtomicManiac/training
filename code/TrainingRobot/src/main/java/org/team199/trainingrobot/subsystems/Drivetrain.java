/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Add your docs here.
 */
public class Drivetrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  private PWMTalonSRX leftTalon;
  private PWMVictorSPX leftVictor1;
  private PWMVictorSPX leftVictor2;
  private PWMTalonSRX rightTalon;
  private PWMVictorSPX rightVictor1;
  private PWMVictorSPX rightVictor2;
  private static boolean isArcadeMode;
  

  public Drivetrain() {
    isArcadeMode = true;
    leftTalon = new PWMTalonSRX(0);
    leftVictor1 = new PWMVictorSPX(0);
    leftVictor2 = new PWMVictorSPX(0);
    rightTalon = new PWMTalonSRX(1);
    rightVictor1 = new PWMVictorSPX(1);
    rightVictor2 = new PWMVictorSPX(1);
  }

  public static boolean isArcadeMode(){
    return isArcadeMode;
  }

  public void setArcade(boolean arcade){
    isArcadeMode = arcade;
  }
  
  public void tankDrive(double leftSpeed,double rightSpeed) {
    leftTalon.set(-leftSpeed);
    leftVictor1.set(-leftSpeed);
    leftVictor2.set(-leftSpeed);

    rightTalon.set(rightSpeed);
    rightVictor1.set(rightSpeed);
    rightVictor2.set(rightSpeed);
  }

  public void arcadeDrive(double speed, double rotation) {
    leftTalon.set(-speed + rotation);
    leftVictor1.set(-speed + rotation);
    leftVictor2.set(-speed + rotation);

    rightTalon.set(speed + rotation);
    rightVictor1.set(speed + rotation);
    rightVictor2.set(speed + rotation);
  }

}
