package org.team199.lib;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.PWMTalonSRX;
import com.ctre.phoenix.motorcontrol.can.PWMVictorSPX;

public class MotorControllerFactory {
    public static PWMTalonSRX createTalon(int id) {
        PWMTalonSRX talon = new PWMTalonSRX(id);
    
        // Put all configurations for the talon motor controllers in here.
        talon.enableCurrentLimit(true);
        talon.setNeutralMode(NeutralMode.Brake);
    
        return talon;
    }

    public static PWMVictorSPX createVictor(int port) {
        PWMVictorSPX victor = new PWMVictorSPX(port);
    
        // Put all configurations for the victor motor controllers in here.
        victor.setNeutralMode(NeutralMode.Brake);
    
        return victor;
    }
}