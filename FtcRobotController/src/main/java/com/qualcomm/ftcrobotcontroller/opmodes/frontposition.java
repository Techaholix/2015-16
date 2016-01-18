package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by techaholix on 1/4/2016.
 */
public class frontposition extends OpMode {
    Servo srvfrontright;
    Servo srvfrontleft;
    Servo srvbackright;
    Servo srvbackleft;

    @Override
    public void init() {
        srvfrontright = hardwareMap.servo.get("srv_front_right");
        srvfrontleft = hardwareMap.servo.get("srv_front_left");
        srvbackright = hardwareMap.servo.get("srv_back_right");
        srvbackleft = hardwareMap.servo.get("srv_back_left");
        srvfrontright.setPosition(0.85); // done
        srvfrontleft.setPosition(0.75);
        srvbackright.setPosition(0.85);  // working
        srvbackleft.setPosition(0.05);
    }

    @Override
    public void loop() {
        stopRobot();
    }

    private void stopRobot() {
    }

}
