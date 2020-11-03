/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.team199.trainingrobot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Teleoperated extends CommandBase {
    private Drivetrain drivetrain;
    private WPI_TalonSRX frontRight;
    private WPI_TalonSRX frontLeft;
    private WPI_TalonSRX midRight;
    private WPI_TalonSRX midLeft;
    private WPI_TalonSRX backRight;
    private WPI_TalonSRX backLeft;
    private Joystick rightJoy;
    private Joystick leftJoy;
    public Teleoperated() {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(this.drivetrain);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        boolean switchMode = leftJoy.getTopPressed();
        if (switchMode == true){
            //Arcade Mode
            drivetrain.run(frontRight, rightJoy.getX());
            drivetrain.run(frontLeft, rightJoy.getX());
            drivetrain.run(midRight, leftJoy.getY());
            drivetrain.run(midLeft, leftJoy.getY());
            drivetrain.run(backRight, leftJoy.getY());
            drivetrain.run(backLeft, leftJoy.getY());
         }
         else{
            //Tank Mode
            drivetrain.run(frontLeft, leftJoy.getY());
            drivetrain.run(midLeft, leftJoy.getY());
            drivetrain.run(backLeft, leftJoy.getY());
            drivetrain.run(frontRight, rightJoy.getY());
            drivetrain.run(midRight, leftJoy.getX());
            drivetrain.run(backRight, rightJoy.getY());
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


