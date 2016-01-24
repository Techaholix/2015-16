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

        if (gamepad1.right_stick_y != 0) {
            dcfrontright.setPower(gamepad1.right_stick_y);
            dcfrontleft.setPower(gamepad1.right_stick_y * -1);
            dcbackright.setPower(gamepad1.right_stick_y);
            dcbackleft.setPower(gamepad1.right_stick_y * -1);
        }else if (gamepad1.left_stick_x > 0) {
                dcfrontright.setPower(0.2);
                dcfrontleft.setPower(gamepad1.left_stick_x);
                dcbackright.setPower(0.2);
                dcbackleft.setPower(gamepad1.left_stick_x);
        } else if (gamepad1.left_stick_x < 0) {
            dcfrontright.setPower(gamepad1.left_stick_x);
            dcfrontleft.setPower(-0.2);
            dcbackright.setPower(gamepad1.left_stick_x);
            dcbackleft.setPower(-0.2);
         } else if (gamepad1.left_stick_x == 0) {
            dcfrontright.setPower(0.0);
            dcfrontleft.setPower(0.0);
            dcbackright.setPower(0.0);
            dcbackleft.setPower(0.0);
        }
        }
    }

