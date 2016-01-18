package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 12/23/2015.
 */
class Camphalfbloodsweepp extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    DcMotor sweeperarm;
    DcMotor arm1;
    DcMotor arm2;
    Servo srvfrontright;
    Servo srvfrontleft;
    Servo srvbackright;
    Servo srvbackleft;
    //Servo boxmover;
    //Servo boxturner;
    @Override
    public void init() {
dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
dcbackright = hardwareMap.dcMotor.get("dc_back_right");
dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
sweeperarm = hardwareMap.dcMotor.get("dc_sweep");
arm1 = hardwareMap.dcMotor.get("arm1");
arm2 = hardwareMap.dcMotor.get("arm2");
srvfrontright = hardwareMap.servo.get("srv_front_right");
srvfrontleft = hardwareMap.servo.get("srv_front_left");
srvbackright = hardwareMap.servo.get("srv_back_right");
srvbackleft = hardwareMap.servo.get("srv_back_left");
//boxmover = hardwareMap.servo.get("boxmover");
//boxturner = hardwareMap.servo.get("boxturner");

    }

    @Override
    public void loop() {
// backright reverse values so it runs straight
        if (gamepad1.dpad_up) {
            srvfrontright.setPosition(0.85); // done
            srvfrontleft.setPosition(0.75);
            srvbackright.setPosition(0.85);  // working
            srvbackleft.setPosition(0.05);
            dcfrontright.setPower(-1.0);  // done
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(1.0);
        } else {
            dcfrontright.setPower(0.0); // done
            dcfrontleft.setPower(0.0);
            dcbackright.setPower(0.0);
            dcbackleft.setPower(0.0);
        }
        if (gamepad1.dpad_down) {
            srvfrontright.setPosition(0.85); //done
            srvfrontleft.setPosition(0.75); //done
            srvbackright.setPosition(0.85); //done
            srvbackleft.setPosition(0.05);
            dcfrontright.setPower(1.0);   // done
            dcfrontleft.setPower(-1.0);   //done
            dcbackright.setPower(1.0);  //done
            dcbackleft.setPower(-1.0);
        } else {
            dcfrontright.setPower(0.0); // done
            dcfrontleft.setPower(0.0);
            dcbackright.setPower(0.0);
            dcbackleft.setPower(0.0);
        }
        if (gamepad1.dpad_right) {
            srvfrontright.setPosition(0.0); // done
            srvfrontleft.setPosition(0.0);
            srvbackright.setPosition(0.0);
            srvbackleft.setPosition(0.85);
            dcfrontright.setPower(1.0); // done
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(1.0);
        } else {
            dcfrontright.setPower(0.0); // done
            dcfrontleft.setPower(0.0);
            dcbackright.setPower(0.0);
            dcbackleft.setPower(0.0);
        }
        if (gamepad1.dpad_left) {
            srvfrontright.setPosition(0.0); // done
            srvfrontleft.setPosition(0.0);
            srvbackright.setPosition(0.0);
            srvbackleft.setPosition(0.85);
            dcfrontright.setPower(-1.0); // done
            dcfrontleft.setPower(-1.0);
            dcbackright.setPower(1.0);
            dcbackleft.setPower(-1.0);
        } else {
            dcfrontright.setPower(0.0); // done
            dcfrontleft.setPower(0.0);
            dcbackright.setPower(0.0);
            dcbackleft.setPower(0.0);
        }
        if (gamepad2.left_bumper) {
            arm2.setPower(-1.0);
        } else {
            arm2.setPower(0.0);
        }
        if (gamepad2.right_bumper) {
            arm1.setPower(-1.0);
        } else {
            arm1.setPower(0.0);
        }
        if (gamepad2.y){
            sweeperarm.setPower(-1.0);
        }else{
            sweeperarm.setPower(0.0);
        }
        if (gamepad2.a) {
            sweeperarm.setPower(1.0);
        }else{
            sweeperarm.setPower(0.0);
        }
        telemetry.addData("right_stick_y", gamepad1.right_stick_y);
        telemetry.addData("right_stick_x", gamepad1.right_stick_x);
        telemetry.addData("left_stick_y", gamepad1.left_stick_y);
        telemetry.addData("left_stick_x", gamepad1.left_stick_x);
        telemetry.addData("right_trigger", gamepad1.right_trigger);
        telemetry.addData("left_trigger", gamepad1.left_trigger);


  /*     if (gamepad2.left_trigger){
           arm2.setPower(1.0);
        } else{
            arm2.setPower(0.0);
        }
        if (gamepad2.right_trigger){
            arm1.setPower(1.0);
        } else{
            arm1.setPower(0.0);
      */  }

    }



