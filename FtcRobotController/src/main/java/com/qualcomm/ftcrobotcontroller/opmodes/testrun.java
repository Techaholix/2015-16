package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Created by upawar on 12/2/15.
 */
public class testrun extends OpMode {
    DcMotor frontright;
    Servo frontrights;
    TouchSensor touchsensor;
    OpticalDistanceSensor opticaldistancesensor;
    ElapsedTime timer;
    double lightValue = 0.11;
    double darkValue = 0.1;
    double threshold = (lightValue+darkValue) / 2;
    enum State {Drive, Backup, Turn}
    State state;
    double BACKUP_TIME = 0.8;
    double TURN_TIME = 0.7;
    final static int ENCODER_CPR = 50000;
    final static double GEAR_RATIO = 1;
    final static int WHEEL_DIAMETER = 4;
    final static int DISTANCE = 24;
    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
    @Override
    public void init() {
    frontright = hardwareMap.dcMotor.get("dc_right_front");
    frontrights = hardwareMap.servo.get("srv_right_front");
    touchsensor = hardwareMap.touchSensor.get("sensor_touch");
    opticaldistancesensor = hardwareMap.opticalDistanceSensor.get("sensor_opd");
    frontright.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    frontrights.setPosition(0.0);
    state = State.Drive;
    timer = new ElapsedTime();
}
    @Override
    public void loop() {
        // Go forward until the value of the optical distance sensor detects a value < 0.5
        double reflectance = opticaldistancesensor.getLightDetected();
        {
            if(reflectance > threshold) {
                frontrights.setPosition(1.0);
                frontright.setPower(1);
                state = state.Drive;
            } else {
                frontright.setPower(1);
            }
        }
        if (touchsensor.isPressed()) {
            //Stop the motors if the touch sensor is pressed
           // frontright.setPower(1);
            telemetry.addData("Motor Target", COUNTS);
            telemetry.addData("Rigth Position Front", frontright.getCurrentPosition());
        } else {
            frontrights.setPosition(0.0);
        }
    }
}



// Go forward until either the touch sensor is pressed or the motors reach the encoder count set (5000)
