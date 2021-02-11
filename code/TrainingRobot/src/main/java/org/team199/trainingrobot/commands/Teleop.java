/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team199.trainingrobot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;

public class Teleop extends CommandBase {

    private Drivetrain drivetrain;
    private Joystick leftJoystick;
    private Joystick rightJoystick;

    public Teleop(Drivetrain drive, Joystick left, Joystick right) {
    // Use addRequirements() here to declare subsystem dependencies
        drivetrain = drive;
        leftJoystick = left;
        rightJoystick = right;
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
     @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(drivetrain.isArcadeMode()) {
            double speed = leftJoystick.getY();
            double rotation = rightJoystick.getX();
            drivetrain.arcadeDrive(speed, rotation);
        }
        else { //tank mode
            double leftSpeed = leftJoystick.getY();
            double rightSpeed = rightJoystick.getY();
            drivetrain.tankDrive(leftSpeed, rightSpeed);
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
