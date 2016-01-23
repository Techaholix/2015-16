package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by techaholix on 1/21/2016.
 */
public class TestWheelTime extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    int time_threshold = 5;
    boolean startmotors = true;
    @Override
    public void init() {
        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
    }
    @Override
    public void loop() {
        if (startmotors) {
            dcfrontright.setPower(-1.0);
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(1.0);
//            try {
//               Thread.sleep(time_threshold);
//                dcfrontright.setPower(0.0);
//                dcfrontleft.setPower(0.0);
//                dcbackright.setPower(0.0);
//                dcbackleft.setPower(0.0);
//                startmotors = false;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
