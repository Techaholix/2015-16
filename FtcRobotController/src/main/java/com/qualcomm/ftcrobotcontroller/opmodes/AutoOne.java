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
    final static int COUNTS =5000;
    final static int RIGHT_ANGLE_COUNT = 2000;

    Boolean taskOneDone = false;
    Boolean taskTwoDone = false;
    Boolean taskThreeDone = false;
    Boolean taskFourDone= false;

    @Override
    public void init() {

        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        dcfrontright.setTargetPosition( COUNTS);

    }

    @Override
    public void loop() {

        if (taskOneDone == false) {
            telemetry.addData("in task 1", 1);
            try {
                Thread.sleep(5000);
                taskOneDone = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            telemetry.addData("done task 1", 1);
        }

        double rfcp = Math.abs(dcfrontright.getCurrentPosition());

        if ((taskOneDone == true) && (taskTwoDone == false)) {
            telemetry.addData("in task 2", 2);


            if (rfcp >= COUNTS) {
                dcfrontright.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcbackleft.setPower(0.0);
                dcbackright.setPower(0.0);
                telemetry.addData("task 2 rfcp", rfcp);
                telemetry.addData("done task 2", dcfrontright.getCurrentPosition());
                dcfrontright.setTargetPosition(RIGHT_ANGLE_COUNT);
                taskTwoDone = true;
            } else {
                dcfrontright.setPower(BASESPEED);
                dcfrontleft.setPower((BASESPEED - SPEEDDELTA) * -1);
                dcbackleft.setPower((BASESPEED - SPEEDDELTA) * -1);
                dcbackright.setPower(BASESPEED - SPEEDDELTA);
            }
        }
        if (((taskOneDone == true) && taskTwoDone == true) && (taskThreeDone == false)) {
            telemetry.addData("in task 3", 3);
            rfcp = Math.abs(dcfrontright.getCurrentPosition());
            telemetry.addData("in task rfcp is:", dcfrontright.getCurrentPosition());
            if (rfcp >= RIGHT_ANGLE_COUNT) {
                dcfrontright.setPower(BASESPEED * -1);
                dcfrontleft.setPower(0.4 * -1);
                dcbackleft.setPower(0.4 * -1);
                dcbackright.setPower((BASESPEED - SPEEDDELTA) * -1);

            } else {
                dcbackright.setPower(0.0);
                dcbackleft.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcfrontright.setPower(0.0);

                dcfrontright.setTargetPosition(dcfrontright.getCurrentPosition()+3000);
                taskThreeDone = true;
                telemetry.addData("task 3 done", dcfrontright.getCurrentPosition());
            }
        }

        if (((taskOneDone == true) && taskTwoDone == true) && (taskThreeDone == true) && (taskFourDone == false)) {
            rfcp=Math.abs(dcfrontright.getCurrentPosition());
            if (rfcp >=5000) {
                dcfrontright.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcbackleft.setPower(0.0);
                dcbackright.setPower(0.0);
                telemetry.addData("task 4 rfcp", rfcp);
                telemetry.addData("done task 4", dcfrontright.getCurrentPosition());
                dcfrontright.setTargetPosition(RIGHT_ANGLE_COUNT);
                taskFourDone = true;
            } else {
                dcfrontright.setPower(BASESPEED);
                dcfrontleft.setPower((BASESPEED - SPEEDDELTA) * -1);
                dcbackleft.setPower((BASESPEED - SPEEDDELTA) * -1);
                dcbackright.setPower(BASESPEED - SPEEDDELTA);

            }

        }
    }

}
