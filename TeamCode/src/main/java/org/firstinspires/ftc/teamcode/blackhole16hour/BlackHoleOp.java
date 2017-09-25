package org.firstinspires.ftc.teamcode.blackhole16hour;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.minichallenge.botpuffHardware;

/**
 * Created by MichaelL on 9/23/17.
 */

@TeleOp(name="BlackHoleTeleop", group="blackhole16hour")
public class BlackHoleOp extends OpMode {
    private BlackHoleHardware robot = new BlackHoleHardware();
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
        //leave blank for now
    }

    @Override
    public void loop() {
        runtime.reset();
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.update();

        //tank drive
        robot.leftMotor.setPower(gamepad1.left_stick_y);
        robot.rightMotor.setPower(gamepad1.right_stick_y);

        //forward/backward drive

        /*/if (gamepad2.dpad_up) {
            robot.leftElevatorMotor.setPower(-1);
            robot.rightElevatorMotor.setPower(-1);
        }
            else if (gamepad2.dpad_down){
                robot.leftElevatorMotor.setPower(1);
                robot.rightElevatorMotor.setPower(1);
            } else {
                robot.leftElevatorMotor.setPower(0);
                robot.rightElevatorMotor.setPower(0);
        } /*/

        if (gamepad2.a){
            robot.collectorMotor.setPower(1);}
        else if (gamepad2.b) {
            robot.collectorMotor.setPower(-1);
        } else {
            robot.collectorMotor.setPower(0);
        }
        }


    @Override
    public void stop() {
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
        robot.collectorMotor.setPower(0);
    }
}
