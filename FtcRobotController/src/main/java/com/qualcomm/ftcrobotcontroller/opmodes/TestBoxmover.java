package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by upawar on 1/21/16.
 */
public class TestBoxmover extends OpMode {
    Servo boxmover;
    double boxMoverPosition = 0.8f;

    @Override
    public void init() {
        boxmover = hardwareMap.servo.get("boxmover");
    }

    @Override
    public void loop() {
        if (gamepad2.y) {
            setBoxMoverForward();
        } else if (gamepad2.a) {
            setBoxMoverBackward();
        }
    }

    private void setBoxMoverForward() {

        telemetry.addData("while forward current Position", boxmover.getPosition());
        boxMoverPosition = (double) Math.abs(boxMoverPosition + 0.0055f);
        telemetry.addData("new Forward Position", boxMoverPosition);
        if (boxMoverPosition >= 0.8) {
            boxMoverPosition = 0.8f;
        }
        boxmover.setPosition(boxMoverPosition);
    }

    private void setBoxMoverBackward() {
        telemetry.addData("while backword current Position", boxmover.getPosition());
        boxMoverPosition = (double) Math.abs(boxMoverPosition - 0.0055f);
        telemetry.addData("new Backward Position", boxMoverPosition);
        if (boxMoverPosition <= 0.3) {
            boxMoverPosition = 0.3f;
        }
        boxmover.setPosition(boxMoverPosition);
    }
}


