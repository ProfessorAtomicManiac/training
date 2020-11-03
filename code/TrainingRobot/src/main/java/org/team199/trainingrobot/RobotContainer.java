package org.team199.trainingrobot;

import org.team199.trainingrobot.Constants;
import org.team199.trainingrobot.subsystems.Motors;
import org.team199.trainingrobot.commands.RunMotor;
import org.team199.trainingrobot.commands.RunMotorsWithJoystick;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final Motors motors = new Motors();
    private final Joystick leftJoy = new Joystick(Constants.OI.Controller.kPort);
    private final Joystick rightJoy = new Joystick(Constants.OI.Controller.kPort);

    public RobotContainer() {
        configureButtonBindingsController();
        // set default commands here
        motors.setDefaultCommand(new RunMotorsWithJoystick(motors, leftJoy, rightJoy));
    }
    private void configureButtonBindingsController() {
        new JoystickButton(leftJoy, Constants.OI.Controller.kRunMotorsButton).whenHeld(new RunMotor(motors));
        new JoystickButton(rightJoy, Constants.OI.Controller.kRunMotorsButton).whenHeld(new RunMotor(motors));
        // configure to add the command object when mode button is pressed
    }

    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}