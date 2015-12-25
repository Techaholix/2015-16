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

/*package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
/*public class omkar4motors extends OpMode {

    /*
     * Note: the configuration of the servos is such that
     * as the arm servo approaches 0, the arm position moves up (away from the floor).
     * Also, as the claw servo approaches 0, the claw opens up (drops the game element).
     */
    // TETRIX VALUES.
   /* final static double FLEFT_MIN_RANGE  = 0;
    final static double FLEFT_MAX_RANGE  = 0.50;
    final static double FRIGHT_MIN_RANGE  = 0;
    final static double FRIGHT_MAX_RANGE  = 0.50;
    final static double BLEFT_MIN_RANGE  = 0;
    final static double BLEFT_MAX_RANGE  = 0.50;
    final static double BRIGHT_MIN_RANGE  = 0;
    final static double BRIGHT_MAX_RANGE  = 0.50;

    // position of the arm servo.
    double fleftPosition;

    // amount to change the arm servo position.
    double fleftDelta = 0.1;

    // position of the claw servo
    double frightPosition;

    // amount to change the claw servo position by
    double frightDelta = 0.1;

    double bleftPosition;

    // amount to change the arm servo position.
    double bleftDelta = 0.1;

    // position of the claw servo
    double brightPosition;

    // amount to change the claw servo position by
    double brightDelta = 0.1;

    DcMotor motorFrontRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;
   // DcMotor arm1;
   // DcMotor arm2;
    Servo fright;
    Servo fleft;
    Servo bright;
    Servo bleft;

    /**
     * Constructor
     */
   /* public omkar4motors() {

    }

    /*
     * Code to run when the op mode is first enabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     *//*
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
      /*  motorFrontRight = hardwareMap.dcMotor.get("dc_right_front");
        motorFrontLeft = hardwareMap.dcMotor.get("dc_left_front");  //SERVOS RIGHT HERE
        motorBackRight = hardwareMap.dcMotor.get("dc_right_back");
        motorBackLeft = hardwareMap.dcMotor.get("dc_left_back");
       // arm1 = hardwareMap.dcMotor.get("arm1");

        //motorLeft.setDirection(DcMotor.Direction.REVERSE);

        fleft = hardwareMap.servo.get("srv_left_front");
        fright = hardwareMap.servo.get("srv_right_front");
        bright = hardwareMap.servo.get("srv_right_back");
        bleft = hardwareMap.servo.get("srv_left_back");

        // assign the starting position of the wrist and claw
        fleftPosition = 0.0;
        frightPosition = 0.0;
        bleftPosition = 0.0;
        brightPosition = 0.0;

        fleft.setPosition(fleftPosition);
        fright.setPosition(frightPosition);
        bleft.setPosition(bleftPosition);
        bright.setPosition(brightPosition);

    }

    /*
     * This method will be called repeatedly in a loop
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#run()
     */ /*
    @Override
    public void loop() {

		/*
		 * Gamepad 1
		 *
		 * Gamepad 1 controls the motors via the left stick, and it controls the
		 * wrist/claw via the a,b, x, y buttons
		 */

        // throttle: left_stick_y ranges from -1 to 1, where -1 is full up, and
        // 1 is full down
        // direction: left_stick_x ranges from -1 to 1, where -1 is full left
        // and 1 is full right
     /*   float throttle = -gamepad1.left_stick_y;
        float direction = gamepad1.left_stick_x;
        float right = throttle - direction;
        float left = throttle + direction;

        // clip the right/left values so that the values never exceed +/- 1
        //right = Range.clip(right, -1, 1);
        //left = Range.clip(left, -1, 1);

        // scale the joystick value to make it easier to control
        // the robot more precisely at slower speeds.
        //right = (float) scaleInput(right);
        //left = (float) scaleInput(left);
       /* if(gamepad1.right_bumper) {
            arm1.setPower(1.0f);
        } else if (gamepad1.left_bumper) {
          //  arm1.setPower(-1.0f);
        }  if (gamepad2.right_bumper) {
          //  arm2.setPower(-1.0f);
        } else if (gamepad2.left_bumper) {
            arm2.setPower(1.0f); */
        /*}

      /*  if (gamepad1.dpad_up) {

            fleft.setPosition(1.0); // go forward
            fright.setPosition(0.0);
            bleft.setPosition(0.0);
            bright.setPosition(1.0);
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // write the values to the motors
            motorFrontRight.setPower(-1.0f);
            motorFrontLeft.setPower(1.0f);
            motorBackRight.setPower(-1.0f);
            motorBackLeft.setPower(1.0f);

        } else if (gamepad1.dpad_down) {

            fleft.setPosition(1.0); // go forward
            fright.setPosition(0.0);
            bleft.setPosition(0.0);
            bright.setPosition(1.0);
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            motorFrontRight.setPower(1.0f);
            motorFrontLeft.setPower(-1.0f);
            motorBackRight.setPower(1.0f);
            motorBackLeft.setPower(-1.0f);
        } else if (gamepad1.dpad_left) {
            fleft.setPosition(0.0);  //go side
            fright.setPosition(1.0);
            bleft.setPosition(1.0);
            bright.setPosition(0.0);

            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // write the values to the motors
            motorFrontRight.setPower(1.0f);
            motorFrontLeft.setPower(1.0f);
            motorBackRight.setPower(-1.0f);
            motorBackLeft.setPower(-1.0f);
        } else if (gamepad1.dpad_right) {

            fleft.setPosition(0.0);  //go side
            fright.setPosition(1.0);
            bleft.setPosition(1.0);
            bright.setPosition(0.0);

            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // write the values to the motors
            motorFrontRight.setPower(-1.0f);
            motorFrontLeft.setPower(-1.0f);
            motorBackRight.setPower(1.0f);
            motorBackLeft.setPower(1.0f);


        } else  {
            // write the values to the motors
            motorFrontRight.setPower(0.0f);
            motorFrontLeft.setPower(0.0f);
            motorBackRight.setPower(0.0f);
            motorBackLeft.setPower(0.0f);
        }




            // update the position of the arm.
        if (gamepad1.a) {
            // if the A button is pushed on gamepad1, increment the position of
            // the arm servo.
            //fleftPosition += fleftDelta;
            fleft.setPosition(1.0); // go forward
            fright.setPosition(0.0);
            bleft.setPosition(0.0);
            bright.setPosition(1.0);

        }

        if (gamepad1.b) {
            //frightPosition -= frightDelta;
            fleft.setPosition(0.0);  //go side
            fright.setPosition(1.0);
            bleft.setPosition(1.0);
            bright.setPosition(0.0);
        }




/*        if (gamepad1.y) {
            // if the Y button is pushed on gamepad1, decrease the position of
            // the arm servo.
            fleftPosition -= fleftDelta;
        }

        // update the position of the claw
        if (gamepad1.x) {
            frightPosition += frightDelta;
        }

            if (gamepad2.a) {
                // if the A button is pushed on gamepad1, increment the position of
                // the arm servo.
                bleftPosition += bleftDelta;
            }

            if (gamepad2.y) {
                // if the Y button is pushed on gamepad1, decrease the position of
                // the arm servo.
                bleftPosition -= bleftDelta;
            }

            // update the position of the claw
            if (gamepad2.x) {
                brightPosition += brightDelta;
            }

            if (gamepad2.b) {
                brightPosition -= brightDelta;

            }*/

            // clip the position values so that they never exceed their allowed range.
            /*fleftPosition = Range.clip(fleftPosition, FLEFT_MIN_RANGE, FLEFT_MAX_RANGE);
            frightPosition = Range.clip(frightPosition, FRIGHT_MIN_RANGE, FRIGHT_MAX_RANGE);
            bleftPosition = Range.clip(bleftPosition, BLEFT_MIN_RANGE, BLEFT_MAX_RANGE);
            brightPosition = Range.clip(brightPosition, BRIGHT_MIN_RANGE, BRIGHT_MAX_RANGE);*/

            // write position values to the wrist and claw servo
            //fleft.setPosition(0.0);
            //fright.setPosition(0.0);
           // bleft.setPosition(0.0);
            //bright.setPosition(0.0);

		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 *//*
            telemetry.addData("Text", "*** Robot Data***");
            telemetry.addData("fleft", "fleft:  " + String.format("%.2f", fleftPosition));
            telemetry.addData("fright", "fright:  " + String.format("%.2f", frightPosition));
            telemetry.addData("bleft", "bleft: " + String.format("%,2f", bleftPosition));
            telemetry.addData("bright", "bright: " + String.format("%,2f", brightPosition));
            telemetry.addData("left tgt pwr", "left  pwr: " + String.format("%.2f", left));
            telemetry.addData("right tgt pwr", "right pwr: " + String.format("%.2f", right));
            telemetry.addData("left tgt pwr", "left  pwr: " + String.format("%.2f", left));
            telemetry.addData("right tgt pwr", "right pwr: " + String.format("%.2f", right));

        }
        ;

	/*
	 * Code to run when the op mode is first disabled goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
	 */



	/*
	 * This method scales the joystick input so for low joystick values, the
	 * scaled value is less than linear.  This is to make it easier to drive
	 * the robot more precisely at slower speeds.
	 */
    /*double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }


    */
