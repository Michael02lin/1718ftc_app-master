package org.firstinspires.ftc.teamcode.Repeaters;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by MichaelL on 9/25/17.
 */

@TeleOp(name="RepeatersOp", group="Repeaters")
public class RepeatersOp extends OpMode{
    private RepeatersHardware robot = new RepeatersHardware();
    private ElapsedTime runtime = new ElapsedTime();
    //private boolean flipped = false;

    @Override
    public void init() {
        runtime.reset();
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }
    @Override
    public void start() {
        runtime.reset();
        telemetry.addData("Status", "Start");
        robot.JewelServo.setPosition(0.32); //this value should be the default resting position (fits inside 18inches), double check to return to default position after auto ends, where it should automatically retract
        robot.ElevatorRightServo.setPosition(1);
        robot.ElevatorLeftServo.setPosition(0);
        //robot.CollectionServo.setPosition(1);
    }

    @Override
    public void loop() {

        telemetry.addData("Status", "Running: " + runtime.toString());

//robot.leftMotor.setPower(gamepad1.left_stick_y);
        //      robot.rightMotor.setPower(gamepad1.right_stick_y);
        //if (gamepad1.left_stick_y) {
        //robot.JewelServo.setPosition(0.1); //rest position unknown currently


        //gamepad1

            //glyph platform system
        if (gamepad1.a){
            robot.ElevatorRightServo.setPosition(0); //"flipped position??
            robot.ElevatorLeftServo.setPosition(0.93);
        } else {
            robot.ElevatorRightServo.setPosition(0.55); //"default collection presosition??--0.2 good for 18inch position
            robot.ElevatorLeftServo.setPosition(0.35); //-0.8--good for 18inch positio
        }
            //drive system
        double multiplier = 1; //allows for slower moving
        if (gamepad1.right_bumper) {
            multiplier = 0.5;
        } else if (gamepad1.left_bumper) {
            multiplier = 0.25;
        }
        robot.DriveRightMotor.setPower((-gamepad1.right_stick_y)*multiplier);
        robot.DriveLeftMotor.setPower((-gamepad1.left_stick_y)*multiplier);


        //gamepad2
            //collection system
        robot.CollectionRightMotor.setPower(-gamepad2.right_stick_y);
        robot.CollectionLeftMotor.setPower(gamepad2.left_stick_y);
        /*/if (gamepad2.x) {
            robot.CollectionServo.setPosition(0);
        } else {
            robot.CollectionServo.setPosition(0.55);
        }/*/
            //rotate system
        if (gamepad2.dpad_up) {
            robot.RotateMotor.setPower(1);
        } else if (gamepad2.dpad_down) {
            robot.RotateMotor.setPower(-1);
        } else {
            robot.RotateMotor.setPower(0);
        }
            //elevator system
        if(gamepad2.right_bumper) {
            robot.ElevatorMotor.setPower(1);
        } else if (gamepad2.left_bumper) {
            robot.ElevatorMotor.setPower(-1);
        } else {
            robot.ElevatorMotor.setPower(0);
        }

                //test if this speed is suitable
                //can we use encoders here to limit where it goes?, or use a touch sensor-limit sensor






        //mecanum drive code
        /*/if (gamepad1.dpad_left) {               //strafe left
            robot.FrontLeftMotor.setPower(-1);
            robot.BackLeftMotor.setPower(1);
            robot.FrontRightMotor.setPower(1);
            robot.BackRightMotor.setPower(-1);
        } else if (gamepad1.dpad_right) {       //strafe right
            robot.FrontLeftMotor.setPower(1);
            robot.BackLeftMotor.setPower(-1);
            robot.FrontRightMotor.setPower(-1);
            robot.BackRightMotor.setPower(1);
        } else if (gamepad1.dpad_up) {          //full forwards
            robot.FrontLeftMotor.setPower(1);
            robot.BackLeftMotor.setPower(1);
            robot.FrontRightMotor.setPower(1);
            robot.BackRightMotor.setPower(1);
        } else if (gamepad1.dpad_down) {        //full backwards
            robot.FrontLeftMotor.setPower(-1);
            robot.BackLeftMotor.setPower(-1);
            robot.FrontRightMotor.setPower(-1);
            robot.BackRightMotor.setPower(-1);
        } else if (gamepad1.left_bumper) {      //left diagonal
            robot.FrontLeftMotor.setPower(0);
            robot.BackLeftMotor.setPower(1);
            robot.FrontRightMotor.setPower(1);
            robot.BackRightMotor.setPower(0);
        } else if (gamepad1.right_bumper) {     //right diagonal
            robot.FrontLeftMotor.setPower(1);
            robot.BackLeftMotor.setPower(0);
            robot.FrontRightMotor.setPower(0);
            robot.BackRightMotor.setPower(1);
        }/*/
        //else {
            /*/robot.frontleftMotor.setPower(0);
            robot.backleftMotor.setPower(0);
            robot.frontrightMotor.setPower(0);
            robot.backrightMotor.setPower(0);/*/
        //    robot.move((flipped ? -gamepad1.right_stick_y : gamepad1.left_stick_y), //should be tank drive
        //            (flipped ? gamepad1.left_stick_y : -gamepad1.right_stick_y));
        //}

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
        robot.CollectionRightMotor.setPower(0);
        robot.CollectionLeftMotor.setPower(0);
        robot.DriveRightMotor.setPower(0);
        robot.DriveLeftMotor.setPower(0);
        robot.RotateMotor.setPower(0);
        robot.ElevatorMotor.setPower(0);
        }

    }
