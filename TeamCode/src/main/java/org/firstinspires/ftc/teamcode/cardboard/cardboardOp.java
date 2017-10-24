package org.firstinspires.ftc.teamcode.cardboard;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.blackhole16hour.BlackHoleHardware;

/**
 * Created by MichaelL on 9/25/17.
 */

@TeleOp(name="cardboardTeleOp", group="cardboard")
public class cardboardOp extends OpMode{
    private cardboardHardware robot = new cardboardHardware();
    private ElapsedTime runtime = new ElapsedTime();

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

        robot.frontleftMotor.setPower(gamepad1.left_stick_y);
        robot.frontrightMotor.setPower(gamepad1.right_stick_y);

        robot.backleftMotor.setPower(gamepad1.left_stick_y);
        robot.backrightMotor.setPower(gamepad1.right_stick_y);

    }

    @Override
    public void stop() {
            robot.frontleftMotor.setPower(0);
            robot.frontrightMotor.setPower(0);
            robot.backleftMotor.setPower(0);
            robot.backrightMotor.setPower(0);

    }
}
