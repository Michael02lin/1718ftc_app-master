package org.firstinspires.ftc.teamcode.minichallenge;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.carnival1718.carnivalHardware;

/**
 * Created by MichaelL on 9/20/17.
 */

@TeleOp (name="botpuffTeleop", group="botpuff")
@Disabled
public class botpuffOp extends OpMode{

    private botpuffHardware robot = new botpuffHardware();
    private ElapsedTime runtime = new ElapsedTime();
    private boolean flipped = false;

    @Override
    public void init() {
        runtime.reset();
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        runtime.reset();
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.update();

        double multiplier = 1;
        if (gamepad1.right_bumper) {
            multiplier = 0.5;
        } else if (gamepad1.left_bumper) {
            multiplier = 0.25;
        }
        //gamepad1
        //robot.move((flipped ? gamepad1.right_stick_y : -gamepad1.left_stick_y) * multiplier,
        //(flipped ? gamepad1.left_stick_y : -gamepad1.right_stick_y) * multiplier);
        if (gamepad1.dpad_up){
            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(1);
        } else if (gamepad1.dpad_down){
            robot.leftMotor.setPower(-1);
            robot.rightMotor.setPower(-1);
        } else {
            robot.move((flipped ? gamepad1.right_stick_y : -gamepad1.left_stick_y) * multiplier, (flipped ? gamepad1.left_stick_y : -gamepad1.right_stick_y) *multiplier);
        }


    }

    @Override
    public void stop() {
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);

}}

