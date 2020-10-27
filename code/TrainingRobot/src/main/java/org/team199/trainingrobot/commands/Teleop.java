/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Teleop extends CommandBase {
  /**
   * Creates a new Teleop.
   */

  private WPI_TalonSRX leftLeader, rightLeader;

  private Joystick leftJoystick;
  private Joystick rightJoystick;
  private boolean isArcade;


  public Teleop(Joystick newLeftJoystick, Joystick newRightJoystick, WPI_TalonSRX theLeftLeader, WPI_TalonSRX theRightLeader, 
    BaseMotorController leftFollower1,BaseMotorController leftFollower2, BaseMotorController rightFollower1, BaseMotorController rightFollower2) {
    // Use addRequirements() here to declare subsystem dependencies.
    isArcade = true;
    leftJoystick = newLeftJoystick;
    rightJoystick = newRightJoystick;
    
    leftFollower1.follow(leftLeader);
    leftFollower2.follow(leftLeader);
    leftLeader = theRightLeader;

    rightFollower1.follow(rightLeader);
    rightFollower2.follow(rightLeader);
    rightLeader = theLeftLeader;


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (isArcade) {
      double speed = leftJoystick.getY();
      double rotation = rightJoystick.getX();

      if (Math.abs(rotation) < 0.001 ) {
        leftLeader.set(speed);
        rightLeader.set(speed);
      } else {
        leftLeader.set(rotation);
        rightLeader.set(-rotation);
      }
    } else { // tank mode
      double leftSpeed = leftJoystick.getY();
      double rightSpeed = rightJoystick.getY();

      if (Math.abs(leftSpeed) < 0.001) {
        leftSpeed = 0;
      }
      if (Math.abs(rightSpeed) < 0.001) {
        rightSpeed = 0;
      }

      leftLeader.set(leftSpeed);
      rightLeader.set(rightSpeed);

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
