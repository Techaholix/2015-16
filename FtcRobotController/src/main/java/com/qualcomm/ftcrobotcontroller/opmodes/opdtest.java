package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by techaholix on 12/12/2015.
 */
public class opdtest extends OpMode {
    OpticalDistanceSensor opd;
    DcMotor dc_right_front;
    ElapsedTime timer;

    double lightValue = 0.3;
    double darkValue = 1.0;
    double threshold = (lightValue + darkValue) / 2;

    enum State {Drive, Backup, Turn}

  State state;

    double BACKUP_TIME = 0.8;
    double TURN_TIME = 0.7;

    @Override
    public void init() {
        opd = hardwareMap.opticalDistanceSensor.get("opd");
        state = State.Drive;
        timer = new ElapsedTime();
    }

    @Override
    public void loop() {
        double reflectance = opd.getLightDetected();
        double reflectanceRaw = opd.getLightDetectedRaw();
      //  telemetry.addData("Current State", state.name());
        telemetry.addData("Reflectance Value",reflectance);
        telemetry.addData("RefletanceRaw", reflectanceRaw);

//        switch (state) {
//            case Drive:
//                if (reflectance < threshold) {
//                    dc_right_front.setPower(0);
//                    state = State.Backup;
//                    timer.reset();
//                } else {
//                    dc_right_front.setPower(0.15);
//                }
//                break;
//            case Backup:
//                dc_right_front.setPower(-0.25);
//
//                if(timer.time() >= BACKUP_TIME) {
//                    state = State.Turn;
//                    timer.reset();
//                }
//                break;
//            case Turn:
//                dc_right_front.setPower(0.15);
//                if(timer.time() >= TURN_TIME) {
//                    state = State.Drive;
//                }
//                break;
//        }
    }
}