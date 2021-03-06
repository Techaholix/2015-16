package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 12/23/2015.
 */
public class Camphalfblood extends OpMode {
    DcMotor dcfrontright;
    DcMotor dcfrontleft;
    DcMotor dcbackright;
    DcMotor dcbackleft;
    Servo srvfrontright;
    Servo srvfrontleft;
    Servo srvbackright;
    Servo srvbackleft;
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

    }

    @Override
    public void loop() {

        if(gamepad1.dpad_up) {
            stopReobt();

            srvfrontright.setPosition(0.85); // done
            srvfrontleft.setPosition(0.75);
            srvbackright.setPosition(0.85);  // working
            srvbackleft.setPosition(0.03);
            waitForTrun(2000l);

            dcfrontright.setPower(-1.0);  // done
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(1.0);
        }
        if (gamepad1.dpad_down) {
            stopReobt();

            srvfrontright.setPosition(0.85); //done
            srvfrontleft.setPosition(0.75); //done
            srvbackright.setPosition(0.85); //done
            srvbackleft.setPosition(0.03);

            waitForTrun(2000l);

            dcfrontright.setPower(1.0);   // done
            dcfrontleft.setPower(-1.0);   //done
            dcbackright.setPower(1.0);  //done
            dcbackleft.setPower(-1.0);
        }
        if (gamepad1.dpad_right) {
            stopReobt();
            srvfrontright.setPosition(0.0); // done
            srvfrontleft.setPosition(0.0);
            srvbackright.setPosition(0.0);
            srvbackleft.setPosition(0.75);

            waitForTrun(2000l);

            dcfrontright.setPower(1.0); // done
            dcfrontleft.setPower(1.0);
            dcbackright.setPower(-1.0);
            dcbackleft.setPower(1.0);
        }
        if (gamepad1.dpad_left) {
            stopReobt();
            srvfrontright.setPosition(0.0); // done
            srvfrontleft.setPosition(0.0);
            srvbackright.setPosition(0.0);
            srvbackleft.setPosition(0.75);

            waitForTrun(2000l);
            dcfrontright.setPower(-1.0); // done
            dcfrontleft.setPower(-1.0);
            dcbackright.setPower(1.0);
            dcbackleft.setPower(-1.0);
        }

        if(gamepad1.a)  {
           stopReobt();
        }

    }

    public void stopReobt(){
        dcfrontright.setPower(0);
        dcfrontleft.setPower(0);
        dcbackright.setPower(0);
        dcbackleft.setPower(0);
        waitForTrun(1000l);
    }

    public  void waitForTrun(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

