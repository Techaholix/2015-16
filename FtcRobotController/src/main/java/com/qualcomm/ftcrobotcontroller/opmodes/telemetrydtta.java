package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 1/15/2016.
 */
public class telemetrydtta extends OpMode {
    DcMotor DCMOTOR;
    Servo SERVO;
    @Override
    public void init() {
DCMOTOR = hardwareMap.dcMotor.get("dcmotor");
SERVO = hardwareMap.servo.get("servo");

    }

    @Override
    public void loop() {
        DCMOTOR.setPower(gamepad1.left_stick_y);
        SERVO.setPosition(Math.abs(gamepad1.right_stick_y));

       /* if(gamepad1.b) {
            SERVO.setPosition(gamepad1.right_stick_y * 0);
        }
        if(gamepad1.a) {
            SERVO.setPosition(gamepad1.right_stick_y + .1);
        }
        if(gamepad1.x) {
            SERVO.setPosition(gamepad1.right_stick_y - .1);
        } */


        telemetry.addData("right_stick_y", gamepad1.right_stick_y);
        telemetry.addData("right_stick_x", gamepad1.right_stick_x);
        telemetry.addData("left_stick_y", gamepad1.left_stick_y);
        telemetry.addData("left_stick_x", gamepad1.left_stick_x);
        telemetry.addData("right_trigger", gamepad1.right_trigger);
        telemetry.addData("left_trigger", gamepad1.left_trigger);
    }
}
