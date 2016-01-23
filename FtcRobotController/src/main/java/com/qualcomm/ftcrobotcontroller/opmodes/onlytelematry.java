package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by techaholix on 1/22/2016.
 */
public class onlytelematry extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
telemetry.addData("left_stick_x", gamepad1.left_stick_x);
    }
}
