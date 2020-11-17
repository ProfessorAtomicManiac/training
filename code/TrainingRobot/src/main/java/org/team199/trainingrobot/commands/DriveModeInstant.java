/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class DriveMode extends InstantCommand {
    Drive driving;

    public DriveMode (Drive d) {
    // Use addRequirements() here to declare subsystem dependencies
        driving = d;
    }

    // Called when the command is initially scheduled.
     @Override
    public void initialize() {
        if (driving.arcadeMode()) {
            driving.setArcadeMode(false);
        }
        else {
            driving.setArcadeMode(true);
        }
    }

     // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}