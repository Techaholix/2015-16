package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by upawar on 11/28/15.
 */
public class frontrightdrive extends OpMode {
    DcMotor frontdrive;
    @Override
    public void init() {
        frontdrive = hardwareMap.dcMotor.get("dc_right_front");
    }

    @Override
    public void loop() {
        frontdrive.setPower(-0.2);

    }
}
