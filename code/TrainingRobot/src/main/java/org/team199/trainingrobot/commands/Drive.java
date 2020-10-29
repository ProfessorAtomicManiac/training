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

public class Drive extends CommandBase {
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private boolean arcadeMode;

    public Drive (Joystick left, Joystick right) {
    // Use addRequirements() here to declare subsystem dependencies
        left = leftJoystick;
        right = rightJoystick;
    }

    // Called when the command is initially scheduled.
     @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (arcadeMode) {

        }
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
