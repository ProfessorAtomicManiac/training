/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunMotorsWithJoystick extends CommandBase {
  /**
   * Creates a new RunMotorsWithJoystick.
   */
  private Motors motors;
  private Joystick joystick;


  public RunMotorsWithJoystick(Motors newMotors, Joystick newJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    motors = newMotors;
    joystick = newJoystick;
    addRequirements(newMotors);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motors.run(joystick.getY());
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
