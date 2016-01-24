package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by techaholix on 1/21/2016.
 */
public class TestOPD extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    OpticalDistanceSensor opd;
    ElapsedTime timer;
    double lightValue = 0.5;
    double darkValue = 0.1;
    double thresholdmax = (lightValue + darkValue);
    double lightval2 = 0.3;
    double darkval2 = 0.1;
    double thresholdmin = (lightval2 + darkval2);
    boolean reachthreshold = false;

    enum State {Drive, Backup, Turn}

    State state;
    double BACKUP_TIME = 0.8;
    double TURN_TIME = 0.7;

    @Override
    public void init() {
        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        opd = hardwareMap.opticalDistanceSensor.get("sensor_opd");
        state = State.Drive;
        timer = new ElapsedTime();

    }

    @Override
    public void loop() {
        double current_reflectance_val = opd.getLightDetected();
        telemetry.addData("reflectance", current_reflectance_val);
        if (reachthreshold == false)
        {
            if ((current_reflectance_val > thresholdmin && current_reflectance_val < thresholdmax))
            {
                //stop motors which means one of the conditions is true
                telemetry.addData("4", "Inside if...");
                dcfrontright.setPower(0.0);
                dcfrontleft.setPower(0.0);
                dcbackright.setPower(0.0);
                dcbackleft.setPower(0.0);
                reachthreshold = true;

            }
            else
            {
                telemetry.addData("4", "Inside else...");
                dcfrontright.setPower(-1.0);
                dcfrontleft.setPower(1.0);
                dcbackright.setPower(-1.0);
                dcbackleft.setPower(1.0);

            }

        }
    }
}
