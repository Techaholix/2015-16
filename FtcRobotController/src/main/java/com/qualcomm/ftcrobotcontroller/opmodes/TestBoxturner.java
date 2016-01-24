package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by upawar on 1/21/16.
 */
public class TestBoxturner extends OpMode {
    Servo boxturner;

    @Override
    public void init() {
        boxturner = hardwareMap.servo.get("boxturner");
        boxturner.setPosition(1.0
        );
    }

    @Override
    public void loop() {
        boxturner.setPosition(Math.abs(gamepad2.left_stick_y));

    }
}


