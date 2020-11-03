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
  private Motors motors;
  private Joystick leftJoy;
  private Joystick rightJoy;

  /**
   * Creates a new RunMotorsWithJoystick.
   */
  public RunMotorsWithJoystick(Motors motors, Joystick leftJoy,Joystick rightJoy) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.motors = motors);
    this.leftJoy = leftJoy;
    this.rightJoy = rightJoy;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motors.run(leftJoy.getY());
    
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
