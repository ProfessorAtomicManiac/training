/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;

public class RunMotor extends CommandBase {
  private Motors motors;
  private Joystick joystick;

  public RunMotorWithJoystick(Motors m, Joystick j) {
    // Use addRequirements() here to declare subsystem dependencies
    m = motors;
    j = joystick;
    addRequirements(m);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motors.run(joystick.getY(), joystick.getX());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
}
