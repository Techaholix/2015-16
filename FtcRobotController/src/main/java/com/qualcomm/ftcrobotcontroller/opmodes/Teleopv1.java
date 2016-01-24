package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 1/16/2016.
 */
public class Teleopv1 extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    DcMotor sweeperarm;
    DcMotor arm1;
    DcMotor arm2;
    Servo boxarm;
    Servo boxturner;
   double boxArmPosition = 0.8f;
    @Override
    public void init() {
        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        sweeperarm = hardwareMap.dcMotor.get("dc_sweep");
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        boxarm = hardwareMap.servo.get("boxarm");
        boxturner = hardwareMap.servo.get("boxturner");
        boxturner.setPosition(1.0);
    }
    @Override
    public void loop() {
        telemetry.addData("positionBoxMover", boxarm.getPosition());
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
        if (gamepad2.left_bumper) {
            arm2.setPower(-1.0);
            telemetry.addData("leftbumppress", gamepad2.left_bumper);
        } else {
            arm2.setPower(gamepad2.left_trigger);
        }
        if (gamepad2.right_bumper) {
            arm1.setPower(-1.0);
        } else {
            arm1.setPower(gamepad2.right_trigger);
        }
        sweeperarm.setPower(gamepad2.right_stick_y);
        if (gamepad2.y) {
            setBoxArmForward();
        } else if (gamepad2.a) {
            setBoxArmBackward();
        }
        if(gamepad2.left_stick_y != 0) {
            boxturner.setPosition(Math.abs(gamepad2.left_stick_y));
            printTelemetry();
        }
    }
    private void printTelemetry() {
//        telemetry.addData("right_stick_y", gamepad1.right_stick_y);
//        telemetry.addData("right_stick_x", gamepad1.right_stick_x);
//        telemetry.addData("left_stick_y", gamepad1.left_stick_y);
//        telemetry.addData("left_stick_x", gamepad1.left_stick_x);
//        telemetry.addData("right_stick_y_gp2", gamepad2.right_stick_y);
//        telemetry.addData("connection info %s", boxarm.getConnectionInfo());
//        telemetry.addData("connection info %s", boxarm.getController().getConnectionInfo());
//        telemetry.addData("device name %s", boxarm.getDeviceName());
//        telemetry.addData("direction %s", boxarm.getDirection());
//        telemetry.addData("port number %d", boxarm.getPortNumber());
//        telemetry.addData("position %f", boxarm.getPosition());
    }
    private void setBoxArmForward() {

        telemetry.addData("while forward current Position", boxarm.getPosition());
       double newboxArmPosition = (double) Math.abs(boxArmPosition + 0.0055f);
        telemetry.addData("new Forward Position", newboxArmPosition);
        if (newboxArmPosition >= 0.8) {
            newboxArmPosition = 0.8f;
        }
        boxarm.setPosition(newboxArmPosition);
    }
    private void setBoxArmBackward() {
        telemetry.addData("while backword current Position", boxarm.getPosition());
       double newboxArmPosition = (double) Math.abs(boxArmPosition - 0.0055f);
        telemetry.addData("new Backward Position", newboxArmPosition);
        if (newboxArmPosition <= 0.3) {
            newboxArmPosition = 0.3f;
        }
        boxarm.setPosition(newboxArmPosition);
    }
}
