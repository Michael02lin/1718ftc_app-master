package org.firstinspires.ftc.teamcode.carnival1718;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by MichaelL on 9/9/17.
 */

@TeleOp (name="CarnivalTeleop", group="Carnival")
//@Disabled
public class carnivalOp extends OpMode {
    /* Declare OpMode members. */
    private carnivalHardware robot = new carnivalHardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        runtime.reset();
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }

    /*
         * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
         */
    @Override
    public void start() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void loop() {
        runtime.reset();
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.update();
        //Gamepad 1
        if (gamepad1.dpad_left) {
            robot.railMotor.setPower(1);
        } else if (gamepad1.dpad_right) {
            robot.railMotor.setPower(-1);
        } else {
            robot.railMotor.setPower(0);
        }

        if (gamepad1.x) {
            robot.flickerMotor.setPower(1);
        } else if (gamepad2.x) {
            robot.flickerMotor.setPower(-1);
        } else {
            robot.flickerMotor.setPower(0);
        }
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void stop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.update();

        robot.railMotor.setPower(0);
        robot.flickerMotor.setPower(0);

    }
}