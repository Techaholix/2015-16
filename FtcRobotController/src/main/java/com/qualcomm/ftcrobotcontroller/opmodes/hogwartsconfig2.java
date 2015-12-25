package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by techaholix on 12/22/2015.
 */
public class hogwartsconfig2 extends OpMode {
    DcMotor dc_right_front;
    Servo frontrights;
    TouchSensor touchsensor;
    OpticalDistanceSensor opd;
    ElapsedTime timer;
    double lightValue = 0.4;
    double darkValue = 0.1;
    double threshold = (lightValue + darkValue) / 2;

    enum State {Drive, Backup, Turn}

    State state;
    double BACKUP_TIME = 0.8;
    double TURN_TIME = 0.7;
    final static int ENCODER_CPR = 11200;
    final static double GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 24;
    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
    @Override
    public void init() {
        dc_right_front = hardwareMap.dcMotor.get("dc_right_front");
        frontrights = hardwareMap.servo.get("srv_right_front");
        touchsensor = hardwareMap.touchSensor.get("sensor_touch");
        opd = hardwareMap.opticalDistanceSensor.get("sensor_opd");
        // dc_right_front.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        state = State.Drive;
        timer = new ElapsedTime();
        frontrights.setPosition(1.0);

    }

    @Override
    public void loop() {
        // for testing
        // dc_right_front.setPower(1.0);

        double current_target_position = dc_right_front.getTargetPosition();
        double current_reflectance_val = opd.getLightDetected();

        telemetry.addData("Current reflectance value", current_reflectance_val);
        telemetry.addData("Current target position value", current_target_position);
        telemetry.addData("Current State", state.name());
        telemetry.addData("Current power ", dc_right_front.getPower());
        telemetry.addData("Servo front right position", frontrights.getPosition());
        telemetry.addData("DC front right position", dc_right_front.getCurrentPosition());
        telemetry.addData("encoder value we want to set", COUNTS);
        telemetry.addData("reflectance threshhold", threshold);

        if ((current_target_position >= COUNTS) || (current_reflectance_val >= threshold)) {
            telemetry.addData("4", "Inside if...");
            // keep moving with full power
            if (current_target_position >= COUNTS) {
            dc_right_front.setPower(1.0);
            } else if (current_reflectance_val >= threshold) {
                dc_right_front.setPower(1.0);
            }
        } else {
        //stop motors which means one of the conditions is true
            telemetry.addData("4", "Inside else...");
        dc_right_front.setPower(0.0);
            telemetry.addData("we reached with encoders", dc_right_front.getCurrentPosition());
            telemetry.addData("we are close to an object", current_reflectance_val);
            // we reached turn left
            frontrights.setPosition(0.0);

        }

        if (touchsensor.isPressed()) {
            //Stop the motors if the touch sensor is pressed
            dc_right_front.setPower(0.0);
            dc_right_front.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            dc_right_front.setTargetPosition(0);
            frontrights.setPosition(1.0);

            telemetry.addData("Touch sensor is pressed", touchsensor.getValue());
        }
    }
}

