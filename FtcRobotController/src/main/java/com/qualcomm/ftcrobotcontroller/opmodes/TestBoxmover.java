package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by upawar on 1/21/16.
 */
public class TestBoxmover extends OpMode {
    Servo boxarm;

    @Override
    public void init() {
          boxarm = hardwareMap.servo.get("boxarm");
//        telemetry.addData("servoposition", boxarm.getPosition());
//        boxarm.setPosition(0.55);
//        telemetry.addData("servoposition", boxarm.getPosition());

    }

    @Override
    public void loop() {
        if (gamepad2.y) {
           telemetry.addData("y position",gamepad2.y);
            boxarm.setPosition(0.8);
        } else if (gamepad2.a) {
            telemetry.addData("a position", gamepad2.a);
            boxarm.setPosition(0.3);
        }
    }

//    private void setBoxArmForward() {
//        telemetry.addData("while forward current Position", boxarm.getPosition());
//        boxarmPosition = (double) Math.abs(boxarmPosition + 0.0055f);
//        telemetry.addData("new Forward Position", boxarmPosition);
//        if (boxarmPosition >= 0.8) {
//            boxarmPosition = 0.8f;
//        }
//        boxarm.setPosition(boxarmPosition);
//    }
//
//    private void setBoxArmBackward() {
//        telemetry.addData("while backword current Position", boxarm.getPosition());
//        boxarmPosition = (double) Math.abs(boxarmPosition - 0.0055f);
//        telemetry.addData("new Backward Position", boxarmPosition);
//        if (boxarmPosition <= 0.3) {
//            boxarmPosition = 0.3f;
//        }
//        boxarm.setPosition(boxarmPosition);
//    }
}


