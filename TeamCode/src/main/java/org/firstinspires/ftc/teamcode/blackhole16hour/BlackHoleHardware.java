package org.firstinspires.ftc.teamcode.blackhole16hour;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by MichaelL on 9/23/17.
 */

public class BlackHoleHardware {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor collectorMotor;


    DcMotor [] motors;
    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        leftMotor = ahwMap.dcMotor.get("leftMotor");
        rightMotor = ahwMap.dcMotor.get("rightMotor");
        collectorMotor = ahwMap.dcMotor.get("collectorMotor");


        //set motor power to 0
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        collectorMotor.setPower(0);


        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);


    }



        //run with encoders
    void move(double left, double right) {
        leftMotor.setPower(-left);
        rightMotor.setPower(right);
    }
}
