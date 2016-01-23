package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by upawar on 1/21/16.
 */
public class TestTurnLeft extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    final static double TURNLEFTDELTA = 0.5;
    final static double BASESPEED = 1.0;
    final static double SPEEDDELTA=0.2;

    @Override
    public void init() {
        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        dcfrontright.setTargetPosition(6000);
    }

    @Override
    public void loop() {
        if(Math.abs(dcfrontright.getCurrentPosition())<= 6000) {
            dcfrontright.setPower(BASESPEED * -1 );
            dcfrontleft.setPower(0.2 * -1);
            dcbackleft.setPower(0.2 * -1);
            dcbackright.setPower((BASESPEED - SPEEDDELTA) *-1);
        }else {
            dcbackright.setPower(0.0);
            dcbackleft.setPower(0.0);
            dcfrontleft.setPower(0.0);
            dcfrontright.setPower(0.0);

        }

    }
}
