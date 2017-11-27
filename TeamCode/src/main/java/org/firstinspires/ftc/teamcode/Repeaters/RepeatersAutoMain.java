package org.firstinspires.ftc.teamcode.Repeaters;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/**
 * Created by MichaelL on 11/27/17.
 */

class RepeatersAutoMain extends LinearOpMode {
    private RepeatersHardware robot = new RepeatersHardware();
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        setup();
        waitForStart();

        // =====================
        // AUTONOMOUS DRIVE CODE
        // =====================

        telemetry.addData("Path", "Complete");
        telemetry.update();

    }
    /*/setup sequence/*/
    private void setup() {
        robot.JewelServo.setPosition(0.5);//default position/resting position to prep for jewel release, should be same value as that of the one in start() in teleopmode
        //robot.ColorSensor.enableLed(true);//sensor enable, later check "true" if it works
        sleep(500);//modify based on tests
        //initialLightIntensity = robot.ColorSensor.getLightDetected();//how to use MR sensors? check samples maybe

        //startCamera();//vuforia

        telemetry.addData("Status", "Robot Ready, Initial Light: " /*/+ initialLightIntensity/*/);
        telemetry.update();
    }
    /*/vuforia sequence?/*/
    /*/placing key sequence?/*/
    /*/jewel detection/move sequence?/*/
    /*/variants for blue/red?/*/

    /*/cleanup sequence/*/
    private void cleanup() {
        for (DcMotorSimple motor: robot.AllMotors) {
            motor.setPower(0);
        }

    }
}
