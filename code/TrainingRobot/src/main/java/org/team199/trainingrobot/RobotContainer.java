package org.team199.trainingrobot;

import org.team199.trainingrobot.Constants;
import org.team199.trainingrobot.subsystems.Motors;
import org.team199.trainingrobot.commands.RunMotor;
import org.team199.trainingrobot.commands.Teleop;
import org.team199.trainingrobot.commands.TeleopDriveMode;
import org.team199.trainingrobot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
    private final Motors motors = new Motors();
    private final Joystick controller = new Joystick(Constants.OI.Controller.kPort);
    private final Joystick rightJoystick = new Joystick(Constants.OI.Controller.X);
    private final Joystick leftJoystick = new Joystick(Constants.OI.Controller.A);
    private final Drivetrain drivetrain = new Drivetrain();

    public RobotContainer() {
        configureButtonBindingsController();
        // set default commands here
        drivetrain.setDefaultCommand(new Teleop(drivetrain, leftJoystick, rightJoystick));
    }
    private void configureButtonBindingsController() {
        new JoystickButton(controller, Constants.OI.Controller.kRunMotorsButton).whenPressed(new RunMotor(motors));
        new JoystickButton(controller, Constants.OI.Controller.X).whenPressed(new TeleopDriveMode(drivetrain));
    }

    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}