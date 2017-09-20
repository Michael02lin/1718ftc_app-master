package org.firstinspires.ftc.teamcode.minichallenge;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by MichaelL on 9/20/17.
 */

public class botpuffHardware {
    DcMotor leftMotor;
    DcMotor rightMotor;

    DcMotor [] motors;
    public void init(HardwareMap ahwMap) {
        // define and initialize driveMotors
        leftMotor = ahwMap.dcMotor.get("leftMotor");
        rightMotor = ahwMap.dcMotor.get("rightMotor");
         // Set to REVERSE if using AndyMark motors


        //set motor power to 0
        leftMotor.setPower(0);
        rightMotor.setPower(0);

        //run with encoders if needed

    }
}
