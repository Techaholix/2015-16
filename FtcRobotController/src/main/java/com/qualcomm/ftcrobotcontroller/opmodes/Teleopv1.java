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
    Servo srvfrontright;
    Servo srvfrontleft;
    Servo srvbackright;
    Servo srvbackleft;
    DcMotor sweeperarm;
    DcMotor arm1;
    DcMotor arm2;
    Servo boxmover;
    Servo boxturner;
    Boolean sideways;
    double boxMoverPosition = 0.8f;


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
        sweeperarm = hardwareMap.dcMotor.get("dc_sweep");
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        boxmover = hardwareMap.servo.get("boxmover");
        boxturner = hardwareMap.servo.get("boxturner");
        sideways = false;
    }

    @Override
    public void loop() {
        telemetry.addData("positionBoxMover", boxmover.getPosition());

        if (gamepad1.dpad_up) {
            setStraightWheel();
        }
        if (gamepad1.dpad_right) {
            setSidewayswheel();
        }


        dcfrontright.setPower(gamepad1.right_stick_y);
        if (sideways) {
            dcfrontleft.setPower(gamepad1.right_stick_y * -1);
        } else {
            dcfrontleft.setPower(gamepad1.right_stick_y * -1);
        }
        if (sideways) {
            dcbackright.setPower(gamepad1.right_stick_y);
        } else {
            dcbackright.setPower(gamepad1.right_stick_y);
        }
        dcbackleft.setPower(gamepad1.right_stick_y * -1);

//        if (gamepad1.x){
//            boxmover.setPosition(0.2);
//        }
//        if (gamepad1.y){
//            boxmover.setPosition(0.6);
//        }
//        if (gamepad1.b){
//            boxmover.setPosition(0.8);
//        }
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
            setBoxMoverForward();
        } else if (gamepad2.a) {
            setBoxMoverBackward();
        }


        boxturner.setPosition(Math.abs(gamepad2.left_stick_y));

        printTelemetry();

    }

    private void printTelemetry() {
//        telemetry.addData("right_stick_y", gamepad1.right_stick_y);
//        telemetry.addData("right_stick_x", gamepad1.right_stick_x);
//        telemetry.addData("left_stick_y", gamepad1.left_stick_y);
//        telemetry.addData("left_stick_x", gamepad1.left_stick_x);
        telemetry.addData("right_stick_y_gp2", gamepad2.right_stick_y);
        telemetry.addData("connection info %s", boxmover.getConnectionInfo());
        telemetry.addData("connection info %s", boxmover.getController().getConnectionInfo());
        telemetry.addData("device name %s", boxmover.getDeviceName());
        telemetry.addData("direction %s", boxmover.getDirection());
        telemetry.addData("port number %d", boxmover.getPortNumber());
        telemetry.addData("position %f", boxmover.getPosition());

    }

    private void setStraightWheel() {
        sideways = false;
        srvfrontright.setPosition(0.85);
        srvfrontleft.setPosition(0.75);
        srvbackright.setPosition(0.75);
        srvbackleft.setPosition(0.85);
        return;
    }

    private void setSidewayswheel() {
        sideways = true;
        srvfrontright.setPosition(0.0);
        srvfrontleft.setPosition(0.0);
        srvbackright.setPosition(0.0);
        srvbackleft.setPosition(0.0);
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

    // unused function / test functions
    private void setDirectionNotUsed () {
        if(gamepad1.y) {
            srvfrontright.setPosition(1 - gamepad1.right_stick_y);
            srvfrontleft.setPosition(1 - gamepad1.right_stick_y);
            srvbackright.setPosition(1 - gamepad1.right_stick_y);
            srvbackleft.setPosition(1 - gamepad1.right_stick_y);
        }

    }
}
