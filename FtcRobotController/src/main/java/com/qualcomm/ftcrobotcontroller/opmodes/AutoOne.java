package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by upawar on 1/21/16.
 */
public class AutoOne extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    final static double SPEEDDELTA=0.2;
    final static double BASESPEED=1.0;
    final static double COUNTS =5000;

    Boolean taskOneDone = false;
    Boolean taskTwoDone = false;
    Boolean taskThreeDone = false;

    @Override
    public void init() {

        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        dcbackleft.setTargetPosition((int) COUNTS);
        dcfrontright.setTargetPosition((int) COUNTS);
        dcbackright.setTargetPosition((int) COUNTS);
        dcfrontleft.setTargetPosition((int) COUNTS);

    }

    @Override
    public void loop() {

        if (taskOneDone == false) {
            telemetry.addData("in task 1",1);
                try {
                Thread.sleep(1000);
                taskOneDone = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            telemetry.addData("done task 1",1);

        }

        double lbcp = Math.abs(dcbackleft.getCurrentPosition());

        if ( (taskOneDone == true) && (taskTwoDone == false) ) {
            telemetry.addData("in task 2",2);


            if (lbcp >= COUNTS) {
                dcfrontright.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcbackleft.setPower(0.0);
                dcbackright.setPower(0.0);
                dcfrontright.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
                telemetry.addData("task 2 rfcp", lbcp);
                taskTwoDone = true;
                telemetry.addData("done task 2", 2);
                dcfrontright.setTargetPosition((int) COUNTS);
            } else {
                dcfrontright.setPower(0.5);
                dcfrontleft.setPower((0.5 - SPEEDDELTA) * -1);
                dcbackleft.setPower((0.5 - SPEEDDELTA) * -1);
                dcbackright.setPower(0.5 - SPEEDDELTA);
            }
        }
        if(((taskOneDone == true) && taskTwoDone==true)&& (taskThreeDone==false)) {
            telemetry.addData("in task 3", 3);
            lbcp = Math.abs(dcbackleft.getCurrentPosition());

            if (lbcp <= 6000) {
                dcfrontright.setPower(BASESPEED * -1);
                dcfrontleft.setPower(0.2 * -1);
                dcbackleft.setPower(0.2 * -1);
                dcbackright.setPower((BASESPEED - SPEEDDELTA) * -1);

            } else {
                dcbackright.setPower(0.0);
                dcbackleft.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcfrontright.setPower(0.0);
                taskThreeDone= true;
                telemetry.addData("task 3 done", 3);
            }
        }
    }

}
