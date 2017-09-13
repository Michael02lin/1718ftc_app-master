package org.firstinspires.ftc.teamcode.carnival1718;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by MichaelL on 9/9/17.
 */

@TeleOp (name="CarnivalTeleop", group="Carnival")
@Disabled
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
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

        runtime.reset();

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.update();


    }
}