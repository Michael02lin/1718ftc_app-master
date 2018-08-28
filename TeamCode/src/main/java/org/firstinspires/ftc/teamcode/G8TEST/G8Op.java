package org.firstinspires.ftc.teamcode.G8TEST;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.sun.tools.javac.code.Symbol;


/**
 * Created by MichaelL on 22/02/2018.
 */

@TeleOp(name="G8Op", group="G8")
@Disabled
public class G8Op extends OpMode {
    private G8Hardware robot = new G8Hardware();
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

    }

    @Override
    public void loop() {

        telemetry.addData("Status", "Running: " + runtime.toString());

        //drive system
        double multiplier = 1; //allows for slower moving
        if (gamepad1.right_bumper) {
            multiplier = 0.5;
        } else if (gamepad1.left_bumper) {
            multiplier = 0.25;
        }
        robot.DriveRightMotor.setPower((gamepad1.right_stick_y)*multiplier);
        robot.DriveLeftMotor.setPower((gamepad1.left_stick_y)*multiplier);

        //grip system
        if (gamepad2.a){
            robot.GripRightServo.setPosition(0.5); //"flipped position??
            robot.GripLeftServo.setPosition(0.5);
        } else {
            robot.GripRightServo.setPosition(0); //"default collection presosition??--0.2 good for 18inch position
            robot.GripLeftServo.setPosition(1); //-0.8--good for 18inch positio
        }

        //elevator system
        if(gamepad1.right_bumper) {
            robot.ElevatorMotor.setPower(1);
        } else if (gamepad1.left_bumper) {
            robot.ElevatorMotor.setPower(-1);
        } else {
            robot.ElevatorMotor.setPower(0);
        }

        //slide system
        /*/if (gamepad2.dpad_up) {
            robot.SlideAMotor.setPower(1);
            robot.SlideBMotor.setPower(1);
        } else if (gamepad2.dpad_down) {
            robot.SlideAMotor.setPower(-1);
            robot.SlideBMotor.setPower(-1);
        } else {
            robot.SlideAMotor.setPower(0);
            robot.SlideBMotor.setPower(0);
        }/*/

        //claw system
        /*/if (gamepad2.b) {
            robot.ClawServo.setPosition(1);
        } else {
            robot.ClawServo.setPosition(0);
        }/*/
    }

    @Override
    public void stop() {
        robot.DriveRightMotor.setPower(0);
        robot.DriveLeftMotor.setPower(0);
        robot.ElevatorMotor.setPower(0);
    }

}
