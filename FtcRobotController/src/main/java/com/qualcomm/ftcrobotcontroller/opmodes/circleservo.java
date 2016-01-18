package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 1/2/2016.
 */
public class circleservo extends OpMode {
    Servo srvcirc;
    @Override
    public void init() {
        srvcirc = hardwareMap.servo.get("servcirc");
        srvcirc.setPosition(0.0);

    }

    @Override
    public void loop() {
srvcirc.setPosition(0.5);
    }
}
