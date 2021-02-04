/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import org.team199.trainingrobot.subsystems.Drivetrain;


public class TeleopDriveMode extends InstantCommand {
    private Drivetrain drivetrain;

    public TeleopDriveMode (Drivetrain d) {
    // Use addRequirements() here to declare subsystem dependencies
    drivetrain = d;
    }

    // Called when the command is initially scheduled.
     @Override
    public void initialize() {
        if (drivetrain.isArcadeMode()) {
            drivetrain.setArcade(false);
        }
        else {
            drivetrain.setArcade(true);
        }
    }

}