/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.lib.MotorControllerFactory;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Add your docs here.
 */
public class Drivetrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  private WPI_TalonSRX leftTalon;
  private WPI_VictorSPX leftVictor1;
  private WPI_VictorSPX leftVictor2;
  private WPI_TalonSRX rightTalon;
  private WPI_VictorSPX rightVictor1;
  private WPI_VictorSPX rightVictor2;
  private static boolean isArcadeMode;
  

  public Drivetrain() {
    isArcadeMode = true;
    leftTalon = MotorControllerFactory.createTalon(0);
    leftVictor1 = MotorControllerFactory.createVictor(2);
    leftVictor2 = MotorControllerFactory.createVictor(4);
    rightTalon = MotorControllerFactory.createTalon(1);
    rightVictor1 = MotorControllerFactory.createVictor(3);
    rightVictor2 = MotorControllerFactory.createVictor(5);
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
