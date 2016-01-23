package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by upawar on 1/21/16.
 */
public class TestEncoder extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    final static double COUNTS =20000;
    final static double SPEEDDELTA = 0.2;

    @Override
    public void init() {
        dcfrontright = hardwareMap.dcMotor.get("dc_front_right");
        dcfrontleft = hardwareMap.dcMotor.get("dc_front_left");
        dcbackright = hardwareMap.dcMotor.get("dc_back_right");
        dcbackleft = hardwareMap.dcMotor.get("dc_back_left");
        dcbackleft.setTargetPosition((int) COUNTS);
        dcfrontright.setTargetPosition((int) COUNTS);
        dcbackright.setTargetPosition((int) COUNTS);
        dcfrontleft.setTargetPosition((int) COUNTS);

        telemetry.addData("dcfrontright position", dcfrontright.getCurrentPosition());
        telemetry.addData("dcfrontleft position", dcfrontleft.getCurrentPosition());
        telemetry.addData("dcbackright position", dcbackright.getCurrentPosition());
        telemetry.addData("dcbackleft position",dcbackleft.getCurrentPosition());
    }

    @Override
    public void loop() {
        double rfcp = Math.abs(dcfrontright.getCurrentPosition());
        double lfcp = Math.abs(dcfrontleft.getCurrentPosition());
        double lbcp = Math.abs( dcbackleft.getCurrentPosition());
        double rbcp = Math.abs(dcbackright.getCurrentPosition());



        telemetry.addData("dcfrontright final position",rfcp);
        telemetry.addData("dcfrontleft final position",lfcp );
        telemetry.addData("dcbackleft final position",lbcp);
        telemetry.addData("dcbackright final position",rbcp );

        if(rfcp >= COUNTS) {
            dcfrontright.setPower(0.0);
        } else {
            dcfrontright.setPower(0.5);
        }
        if(lfcp >= COUNTS) {
            dcfrontleft.setPower(0.0);
        } else {
            dcfrontleft.setPower((0.5-SPEEDDELTA) * -1);
        }
        if(lbcp >= COUNTS) {
            dcbackleft.setPower(0.0);

        } else {
            dcbackleft.setPower((0.5-SPEEDDELTA) *-1);
        }
        if(rbcp >= COUNTS) {
            dcbackright.setPower(0.0);

        } else {
            dcbackright.setPower(0.5-SPEEDDELTA);
        }
    }
}
