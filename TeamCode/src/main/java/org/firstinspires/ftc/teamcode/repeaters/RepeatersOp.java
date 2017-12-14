package org.firstinspires.ftc.teamcode.Repeaters;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by MichaelL on 9/25/17.
 */

@TeleOp(name="RepeatersTeleOp", group="Repeaters")
public class RepeatersOp extends OpMode{
    private RepeatersHardware robot = new RepeatersHardware();
    private ElapsedTime runtime = new ElapsedTime();
    private boolean flipped = false;

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
        robot.JewelServo.setPosition(0.5); //this value should be the default resting position (fits inside 18inches), double check to return to default position after auto ends, where it should automatically retract
        robot.ElevatorRightServo.setPosition(0.5);
        robot.ElevatorLeftServo.setPosition(0.5);
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

        //gamepad1
            //glyph platform system
        if (gamepad1.a){
            robot.ElevatorRightServo.setPosition(0.5); //"flipped position??
            robot.ElevatorLeftServo.setPosition(0.5);
        } else {
            robot.ElevatorRightServo.setPosition(0.5); //"default collection presosition??
            robot.ElevatorLeftServo.setPosition(0.5);
        }
            //drive system
        robot.DriveRightMotor.setPower(gamepad1.right_stick_y);
        robot.DriveLeftMotor.setPower(gamepad1.left_stick_y);


        //gamepad2
            //collection system
        robot.CollectionRightMotor.setPower(gamepad2.right_stick_y);
        robot.CollectionLeftMotor.setPower(-gamepad2.left_stick_y);
            //rotate system
        if (gamepad2.dpad_up) {
            robot.RotateMotor.setPower(1);
        } else if (gamepad2.dpad_down) {
            robot.RotateMotor.setPower(-1);
        } else {
            robot.RotateMotor.setPower(0);
        }
            //elevator system
        robot.ElevatorMotor.setPower(1);
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
        for (DcMotorSimple motor: robot.AllMotors) {
            motor.setPower(0);
        }

    }
}
