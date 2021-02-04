/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team199.trainingrobot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Encoder;

public class AutonomousCircles extends CommandBase {

    private Encoder rightEncoder;
    private Encoder leftEncoder;
    private Drivetrain driving;

    public AutonomousCircles (Encoder r, Encoder l, Drivetrain d) {
    // Use addRequirements() here to declare subsystem dependencies
        rightEncoder = r;
        leftEncoder = l;
        driving = d;
        rightEncoder.setDistancePerPulse(1/256);
        leftEncoder.setDistancePerPulse(1/256);
        addRequirements(driving);
    }

    // Called when the command is initially scheduled.
     @Override
    public void initialize() {
        rightEncoder.reset();
        leftEncoder.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
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
