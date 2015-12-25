package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
 /* Created by upawar on 11/27/15.*/
public class fronrightmotor extends OpMode {
    DcMotor dc_right_front;
    Servo frontrights;
    TouchSensor touchsensor;
    OpticalDistanceSensor opd;
    ElapsedTime timer;
    double lightValue = 0.4;
     double darkValue = 0.1;
    double threshold = (lightValue+darkValue) / 2;
    enum State {Drive, Backup, Turn}
    State state;
    double BACKUP_TIME = 0.8;
    double TURN_TIME = 0.7;
    final static int ENCODER_CPR = 500;
    final static double GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 24;
    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
   // final static double RESET = COUNTS*0;
    @Override
    public void init() {
        dc_right_front = hardwareMap.dcMotor.get("dc_right_front");
        frontrights = hardwareMap.servo.get("srv_right_front");
        touchsensor = hardwareMap.touchSensor.get("sensor_touch");
        opd = hardwareMap.opticalDistanceSensor.get("sensor_opd");
        dc_right_front.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        state = State.Drive;
        timer = new ElapsedTime();
        frontrights.setPosition(1.0);
    }
    @Override
    public void loop() {
        double reflectance = opd.getLightDetected();
        switch (state) {
            case Drive:
                if (reflectance < threshold) {
                    dc_right_front.setPower(0);
                    state = State.Backup;
                    timer.reset();
                } else {
                    if (dc_right_front.getTargetPosition() <= 0) {
                        dc_right_front.setTargetPosition((int) COUNTS);
                        telemetry.addData("Motor Target", COUNTS);
                        dc_right_front.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
                    }

                }
                break;
            case Backup:
                dc_right_front.setPower(-0.25);

                if(timer.time() >= BACKUP_TIME) {
                    state = State.Turn;
                    timer.reset();
                }
                break;
            case Turn:
                dc_right_front.setPower(0.15);
                if(timer.time() >= TURN_TIME) {
                    state = State.Drive;
                }
                break;
        }
        telemetry.addData("Current State", state.name());
        telemetry.addData("Reflectance Value",reflectance);
        telemetry.addData("targetposition", dc_right_front.getTargetPosition());
        if (touchsensor.isPressed()) {
            //Stop the motors if the touch sensor is pressed
            frontrights.setPosition(0.0);
            dc_right_front.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            dc_right_front.setTargetPosition(0);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frontrights.setPosition(1.0);
            telemetry.addData("Motor Target", COUNTS);
            telemetry.addData("Rigth Position Front", dc_right_front.getCurrentPosition());



            }

        }
    }

