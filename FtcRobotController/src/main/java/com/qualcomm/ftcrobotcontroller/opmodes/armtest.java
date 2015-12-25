package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by upawar on 11/29/15.
 */
public class armtest extends OpMode {
    DcMotor arm1;
    DcMotor arm2;

    @Override
    public void init() {
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
    }

    @Override
    public void loop() {

if (gamepad1.y) {
    arm1.setPower(0.3);
}
if (gamepad1.a) {
    arm1.setPower(-0.3);
}
if (gamepad1.x) {
    arm2.setPower(0.3);
}
if (gamepad1.b) {
    arm2.setPower(-0.3);
}
if (gamepad1.start){
    arm1.setPower(0.0);
    arm2.setPower(0.0);
}
    }
}
