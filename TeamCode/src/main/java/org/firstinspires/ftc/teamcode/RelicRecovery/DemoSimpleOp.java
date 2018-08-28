package org.firstinspires.ftc.teamcode.RelicRecovery;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by MichaelL on 9/25/17.
 */

@TeleOp(name="DempleSimpleOp", group="DemoSimple")
public class DemoSimpleOp extends OpMode{
    private DemoSimpleHardware robot = new DemoSimpleHardware();
    private ElapsedTime runtime = new ElapsedTime();
    private boolean flipped = false;

    @Override
    public void init() {
        runtime.reset();
        robot.CRServo1.setPower(0);
        robot.init(hardwareMap);
        //robot.JewelServo.setPosition(0.5);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        runtime.reset();
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.update();
//robot.leftMotor.setPower(gamepad1.left_stick_y);
  //      robot.rightMotor.setPower(gamepad1.right_stick_y);
        //if (gamepad1.left_stick_y) {
        //robot.JewelServo.setPosition(0.1); //rest position unknown currently
        robot.Motor1.setPower(gamepad1.left_stick_y);
        robot.Motor2.setPower(gamepad1.right_stick_y);

        if (gamepad1.a) {
            robot.Servo1.setPosition(0.8);
        }   else if (gamepad1.b) {
            robot.Servo1.setPosition(0.5);
        }   else {
            robot.Servo1.setPosition(0);
        }

        if (gamepad1.dpad_left) {
            robot.CRServo1.setPower(1);
        } else if (gamepad1.dpad_right) {
            robot.CRServo1.setPower(-1);
        } else {
            robot.CRServo1.setPower(0);
        }



        /*/
        if (gamepad1.a) {
            robot.JewelServo.setPosition();
        } else (gamepad1.b) {
                robot.
        }
        /*/


    }

    @Override
    public void stop() {
        robot.Motor1.setPower(0);
        robot.Motor2.setPower(0);
        robot.Servo1.setPosition(0);
        robot.CRServo1.setPower(0);


    }
}
