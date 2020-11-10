/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.subsystems;

import org.team199.trainingrobot.Constants;

import org.team199.lib.MotorControllerFactory;
import com.ctre.phoenix.motorcontrol.can.PWMTalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Motors extends SubsystemBase {
  private final PWMTalonSRX talon = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Motors() {
  }

  public void run(double speed) {
    talon.set(speed);
  }
}
