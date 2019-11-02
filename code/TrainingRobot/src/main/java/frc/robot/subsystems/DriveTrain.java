/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX lefttalon;
  private WPI_VictorSPX leftVictorSPX1;
  private WPI_VictorSPX leftVictorSPX2;

  private WPI_TalonSRX righttalon;
  private WPI_VictorSPX rightVictorSPX1;
  private WPI_VictorSPX rightVictorSPX2;

  private  boolean arcadeMode;
  public DriveTrain(WPI_TalonSRX lefttalon, WPI_VictorSPX leftVictorSPX1, WPI_VictorSPX leftVictorSPX2,WPI_TalonSRX righttalon, WPI_VictorSPX rightVictorSPX1, WPI_VictorSPX rightVictorSPX2) {
    this.lefttalon = lefttalon;
    this.leftVictorSPX1 = leftVictorSPX1;
    this.leftVictorSPX2 = leftVictorSPX2;

    this.righttalon = righttalon;
    this.rightVictorSPX1 = rightVictorSPX1;
    this.rightVictorSPX2 = rightVictorSPX2;
    arcadeMode = true;
  }

  public boolean arcadeMode(){
    return arcadeMode;
  }

  public void setArcadeMode(boolean arcadeMode){
    this.arcadeMode = arcadeMode;
  }
  
  public void run(double leftspeed,double rightspeed) {
    lefttalon.set(leftspeed);
    leftVictorSPX1.set(leftspeed);
    leftVictorSPX2.set(leftspeed);

    righttalon.set(rightspeed);
    rightVictorSPX1.set(rightspeed);
    rightVictorSPX2.set(rightspeed);
  }

  public void arcaderun(double xspeed, double zrotation) {
    lefttalon.set(xspeed + zrotation);
    leftVictorSPX1.set(xspeed + zrotation);
    leftVictorSPX2.set(xspeed + zrotation);

    righttalon.set(xspeed - zrotation);
    rightVictorSPX1.set(xspeed - zrotation);
    rightVictorSPX2.set(xspeed - zrotation);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
