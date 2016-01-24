package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by upawar on 1/21/16.
 */
public class AutoTwo extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    final static double SPEEDDELTA=0.2;
    final static double BASESPEED=1.0;
    final static int COUNTS =5000;
    final static int RIGHT_ANGLE_COUNT = 5000;

    Boolean taskOneDone = false;
    Boolean taskTwoDone = false;
    Boolean taskThreeDone = false;

    @Override
    public void init() {

        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        dcbackleft.setTargetPosition(COUNTS);

        double lbcp = Math.abs(dcbackleft.getCurrentPosition());

        while(true) {
            lbcp = Math.abs(dcbackleft.getCurrentPosition());

            if (lbcp < COUNTS) {

                dcfrontright.setPower(BASESPEED);
                dcfrontleft.setPower((BASESPEED - SPEEDDELTA) * -1);
                dcbackleft.setPower((BASESPEED - SPEEDDELTA) * -1);
                dcbackright.setPower(BASESPEED - SPEEDDELTA);
            } else {
                dcfrontright.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcbackleft.setPower(0.0);
                dcbackright.setPower(0.0);
                //dcbackleft.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                break;
            }
        }

//        try {
//            Thread.sleep(5000);
//            taskOneDone = true;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        while(true) {
//            lbcp = Math.abs(dcbackleft.getCurrentPosition());
//
//            if (lbcp < COUNTS) {
//
//                dcfrontright.setPower(BASESPEED);
//                dcfrontleft.setPower((BASESPEED - SPEEDDELTA) * -1);
//                dcbackleft.setPower((BASESPEED - SPEEDDELTA) * -1);
//                dcbackright.setPower(BASESPEED - SPEEDDELTA);
//            } else {
//                dcfrontright.setPower(0.0);
//                dcfrontleft.setPower(0.0);
//                dcbackleft.setPower(0.0);
//                dcbackright.setPower(0.0);
//                break;
//            }
//        }
    }

    @Override
    public void loop() {
    }

}
