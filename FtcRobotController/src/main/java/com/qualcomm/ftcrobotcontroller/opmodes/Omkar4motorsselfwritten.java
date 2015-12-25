/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */

public class Omkar4motorsselfwritten extends OpMode {

    /*
     * Note: the configuration of the servos is such that
     * as the arm servo approaches 0, the arm position moves up (away from the floor).
     * Also, as the claw servo approaches 0, the claw opens up (drops the game element).
     */
    // TETRIX VALUES.
    final static double FLEFT_MIN_RANGE = 0;
    final static double FLEFT_MAX_RANGE = 0.50;
    final static double FRIGHT_MIN_RANGE = 0;
    final static double FRIGHT_MAX_RANGE = 0.50;
    final static double BLEFT_MIN_RANGE = 0;
    final static double BLEFT_MAX_RANGE = 0.50;
    final static double BRIGHT_MIN_RANGE = 0;
    final static double BRIGHT_MAX_RANGE = 0.50;

    // position of the arm servo.
    double srv_left_front_position;

    // amount to change the arm servo position.
    double fleftDelta = 0.1;

    // position of the claw servo
    double srv_right_front_position;

    // amount to change the claw servo position by
    double frightDelta = 0.1;

    double srv_left_back_position;

    // amount to change the arm servo position.
    double bleftDelta = 0.1;

    // position of the claw servo
    double srv_right_back_position;

    // amount to change the claw servo position by
    double brightDelta = 0.1;

    DcMotor motorFrontRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;
    Servo srv_right_front;
    Servo srv_left_front;
    Servo srv_right_back;
    Servo srv_left_back;

    /**
     * Constructor
     */
    public Omkar4motorsselfwritten() {

    }

    /*
     * Code to run when the op mode is first enabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
    @Override
    public void init() {


		/*
		 * Use the hardwareMap to get the dc motors and servos by name. Note
		 * that the names of the devices must match the names used when you
		 * configured your robot and created the configuration file.
		 */

		/*
		 * For the demo Tetrix K9 bot we assume the following,
		 *   There are two motors "motor_1" and "motor_2"
		 *   "motor_1" is on the right side of the bot.
		 *   "motor_2" is on the left side of the bot and reversed.
		 *
		 * We also assume that there are two servos "servo_1" and "servo_6"
		 *    "servo_1" controls the arm joint of the manipulator.
		 *    "servo_6" controls the claw joint of the manipulator.
		 */
        motorFrontRight = hardwareMap.dcMotor.get("dc_right_front");
        motorFrontLeft = hardwareMap.dcMotor.get("dc_left_front");  //SERVOS RIGHT HERE
        motorBackRight = hardwareMap.dcMotor.get("dc_right_back");
        motorBackLeft = hardwareMap.dcMotor.get("dc_left_back");
        //motorLeft.setDirection(DcMotor.Direction.REVERSE);

        srv_left_front = hardwareMap.servo.get("srv_left_front");
        srv_right_front = hardwareMap.servo.get("srv_right_front");
        srv_right_back = hardwareMap.servo.get("srv_right_back");
        srv_left_back = hardwareMap.servo.get("srv_left_back");

        srv_left_front.setPosition(srv_left_front_position);
        srv_right_front.setPosition(srv_right_front_position);
        srv_right_back.setPosition(srv_right_back_position);
        srv_left_back.setPosition(srv_left_back_position);

    }

    @Override
    public void loop() {

    }

    {

        float throttle = -gamepad1.left_stick_y;
        float direction = gamepad1.left_stick_x;
        float right = throttle - direction;
        float left = throttle + direction;

        if (gamepad1.dpad_up)

        {

            // write the values to the motors
            motorFrontRight.setPower(-1.0f);
            motorFrontLeft.setPower(1.0f);
            motorBackRight.setPower(-1.0f);
            motorBackLeft.setPower(1.0f);

        } else if (gamepad1.dpad_down)

        {

            motorFrontRight.setPower(1.0f);
            motorFrontLeft.setPower(-1.0f);
            motorBackRight.setPower(1.0f);
            motorBackLeft.setPower(-1.0f);
        } else if (gamepad1.dpad_left)

        {

            // write the values to the motors
            motorFrontRight.setPower(1.0f);
            motorFrontLeft.setPower(1.0f);
            motorBackRight.setPower(-1.0f);
            motorBackLeft.setPower(-1.0f);
        } else if (gamepad1.dpad_right)

        {


            motorFrontRight.setPower(-1.0f);
            motorFrontLeft.setPower(-1.0f);
            motorBackRight.setPower(1.0f);
            motorBackLeft.setPower(1.0f);


        }
    }
}



