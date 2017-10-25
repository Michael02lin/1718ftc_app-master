package org.firstinspires.ftc.teamcode.repeaters;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.blackhole16hour.BlackHoleHardware;

/**
 * Created by MichaelL on 9/25/17.
 */

@TeleOp(name="mecanumTeleOp", group="mecanum")
public class mecanumOp extends OpMode{
    private mecanumHardware robot = new mecanumHardware();
    private ElapsedTime runtime = new ElapsedTime();
    private boolean flipped = false;

    @Override
    public void init() {
        runtime.reset();
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
         if (gamepad1.dpad_left) {               //strafe left
            robot.frontleftMotor.setPower(-1);
            robot.backleftMotor.setPower(1);
            robot.frontrightMotor.setPower(1);
            robot.backrightMotor.setPower(-1);
        } else if (gamepad1.dpad_right) {       //strafe right
            robot.frontleftMotor.setPower(1);
            robot.backleftMotor.setPower(-1);
            robot.frontrightMotor.setPower(-1);
            robot.backrightMotor.setPower(1);
        } else if (gamepad1.dpad_up) {          //full forwards
            robot.frontleftMotor.setPower(1);
            robot.backleftMotor.setPower(1);
            robot.frontrightMotor.setPower(1);
            robot.backrightMotor.setPower(1);
        } else if (gamepad1.dpad_down) {        //full backwards
            robot.frontleftMotor.setPower(-1);
            robot.backleftMotor.setPower(-1);
            robot.frontrightMotor.setPower(-1);
            robot.backrightMotor.setPower(-1);
        } else if (gamepad1.left_bumper) {      //left diagonal
            robot.frontleftMotor.setPower(0);
            robot.backrightMotor.setPower(0);
            robot.backleftMotor.setPower(1);
            robot.frontrightMotor.setPower(1);
        } else if (gamepad1.right_bumper) {     //right diagonal
            robot.frontleftMotor.setPower(1);
            robot.backrightMotor.setPower(1);
            robot.backleftMotor.setPower(0);
            robot.frontrightMotor.setPower(0);
        }
        else {
            /*/robot.frontleftMotor.setPower(0);
            robot.backleftMotor.setPower(0);
            robot.frontrightMotor.setPower(0);
            robot.backrightMotor.setPower(0);/*/
             robot.move((flipped ? gamepad1.right_stick_y : -gamepad1.left_stick_y), //should be tank drive
                     (flipped ? gamepad1.left_stick_y : -gamepad1.right_stick_y));
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
        robot.frontleftMotor.setPower(0);
        robot.frontrightMotor.setPower(0);
        robot.backleftMotor.setPower(0);
        robot.backrightMotor.setPower(0);

    }
}
