package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by upawar on 11/28/15.
 */
public class servopos0 extends OpMode{
    Servo frontrights;

    @Override
    public void init() {
        frontrights = hardwareMap.servo.get("srv_right_front");
    }

    @Override
    public void loop() {
frontrights.setPosition(0.0);
    }
}
