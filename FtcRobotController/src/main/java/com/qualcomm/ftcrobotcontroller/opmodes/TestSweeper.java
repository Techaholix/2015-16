package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by upawar on 1/21/16.
 */
public class TestSweeper extends OpMode {

    DcMotor sweeperarm;


    @Override
    public void init() {
        sweeperarm = hardwareMap.dcMotor.get("dc_sweep");
    }

    @Override
    public void loop() {
        sweeperarm.setPower(gamepad2.right_stick_y);

    }

}
