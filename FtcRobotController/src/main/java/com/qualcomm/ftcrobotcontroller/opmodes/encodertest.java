package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Team8716 on 10/24/2015.
 */
public class encodertest extends OpMode {

    DcMotor rightMotorFront;
    /*DcMotor rightMotorBack;
    DcMotor leftMotorFront;
    DcMotor leftMotorBack;*/

    final static int ENCODER_CPR = 1120;
    final static double GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 24;

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

    @Override
    public void init() {
        /*leftMotorFront = hardwareMap.dcMotor.get("dc_left_front");
        leftMotorBack = hardwareMap.dcMotor.get("dc_left_back");*/
        rightMotorFront = hardwareMap.dcMotor.get("dc_right_front");
        /*rightMotorBack = hardwareMap.dcMotor.get("dc_right_back");*/

        rightMotorFront.setDirection(DcMotor.Direction.REVERSE);
        //rightMotorBack.setDirection(DcMotor.Direction.REVERSE);

      //  leftMotorFront.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotorFront.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
       // leftMotorBack.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        //rightMotorBack.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    @Override
    public void start() {
       // leftMotorFront.setTargetPosition((int) COUNTS);
        rightMotorFront.setTargetPosition((int) COUNTS);
        //leftMotorBack.setTargetPosition((int) COUNTS);
        //rightMotorBack.setTargetPosition((int) COUNTS);

       // leftMotorFront.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightMotorFront.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        //leftMotorBack.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        //rightMotorBack.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        //leftMotorFront.setPower(0.5);
        rightMotorFront.setPower(0.5);
        //leftMotorBack.setPower(0.5);
        //rightMotorBack.setPower(0.5);
    }

    @Override
    public void loop() {
        telemetry.addData("Motor Target", COUNTS);

        telemetry.addData("Rigth Position Front", rightMotorFront.getCurrentPosition());

    }
}