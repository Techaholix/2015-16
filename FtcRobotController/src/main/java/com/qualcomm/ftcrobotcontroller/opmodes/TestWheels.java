package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by upawar on 1/21/16.
 */
public class TestWheels extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    double rightfrontpower = 0;
    double leftfrontpower = 0;
    double rightbackpower = 0;
    double leftbackpower = 0;

    @Override
    public void init() {
        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
    }

    @Override
    public void loop() {

        rightfrontpower = gamepad1.right_stick_y + gamepad1.left_stick_x;
        if (rightfrontpower < -1){
            rightfrontpower = -1.0;
        } else if (rightfrontpower > 1.0){
            rightfrontpower = 1.0;
        }

        leftfrontpower = (gamepad1.right_stick_y + gamepad1.left_stick_x) * -1;
        if (leftfrontpower < -1){
            leftfrontpower = -1.0;
        } else if (leftfrontpower > 1.0){
            leftfrontpower = 1.0;
        }

        rightbackpower = gamepad1.right_stick_y + gamepad1.left_stick_x;
        if (rightbackpower < -1){
            rightbackpower = -1.0;
        } else if (rightbackpower > 1.0){
            rightbackpower = 1.0;
        }

        leftbackpower = (gamepad1.right_stick_y + gamepad1.left_stick_x) * -1;
        if (leftbackpower < -1){
            leftbackpower = -1.0;
        } else if (leftfrontpower > 1.0){
            leftbackpower = 1.0;
        }

        dcfrontright.setPower(rightfrontpower);
        dcfrontleft.setPower(leftfrontpower);
        dcbackright.setPower(rightbackpower);
        dcbackleft.setPower(leftbackpower);


//        if (gamepad1.right_stick_y != 0) {
//            dcfrontright.setPower(gamepad1.right_stick_y);
//            dcfrontleft.setPower(gamepad1.right_stick_y * -1);
//            dcbackright.setPower(gamepad1.right_stick_y);
//            dcbackleft.setPower(gamepad1.right_stick_y * -1);
//        }
//             if (gamepad1.left_stick_x != 0) {
//                dcfrontright.setPower(gamepad1.left_stick_x);
//                dcfrontleft.setPower(gamepad1.left_stick_x - 0.3);
//                dcbackright.setPower(gamepad1.left_stick_x);
//                dcbackleft.setPower(gamepad1.left_stick_x - 0.3);
//            }
        }
    }

