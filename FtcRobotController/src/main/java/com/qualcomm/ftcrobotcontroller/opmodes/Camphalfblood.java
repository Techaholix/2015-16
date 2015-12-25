package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 12/23/2015.
 */
public class Camphalfblood extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    Servo srvfrontright;
    Servo srvfrontleft;
    Servo srvbackright;
    Servo srvbackleft;
    @Override
    public void init() {
dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
dcbackright = hardwareMap.dcMotor.get("dc_back_right");
dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
srvfrontright = hardwareMap.servo.get("srv_front_right");
srvfrontleft = hardwareMap.servo.get("srv_front_left");
srvbackright = hardwareMap.servo.get("srv_back_right");
srvbackleft = hardwareMap.servo.get("srv_back_left");

    }

    @Override
    public void loop() {

        if(gamepad1.dpad_up) {
            srvfrontright.setPosition(0.0);
            srvfrontleft.setPosition(1.0);
            srvbackright.setPosition(0.0);
            srvbackleft.setPosition(1.0);
            dcfrontright.setPower(1.0);
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(1.0);
            dcbackleft.setPower(1.0);
        }
        if (gamepad1.dpad_down) {
            srvfrontright.setPosition(0.0);
            srvfrontleft.setPosition(1.0);
            srvbackright.setPosition(0.0);
            srvbackleft.setPosition(1.0);
            dcfrontright.setPower(-1.0);
            dcfrontleft.setPower(-1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(-1.0);
        }
        if (gamepad1.dpad_right) {
            srvfrontright.setPosition(1.0);
            srvfrontleft.setPosition(0.0);
            srvbackright.setPosition(1.0);
            srvbackleft.setPosition(0.0);
            dcfrontright.setPower(1.0);
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(1.0);
            dcbackleft.setPower(1.0);
        }
        if (gamepad1.dpad_left){
            srvfrontright.setPosition(1.0);
            srvfrontleft.setPosition(0.0);
            srvbackright.setPosition(1.0);
            srvbackleft.setPosition(0.0);
            dcfrontright.setPower(-1.0);
            dcfrontleft.setPower(-1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(-1.0);
        }


    }
}
