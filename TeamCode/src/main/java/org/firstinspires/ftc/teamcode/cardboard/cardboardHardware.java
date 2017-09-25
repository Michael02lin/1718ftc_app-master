package org.firstinspires.ftc.teamcode.cardboard;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by MichaelL on 9/25/17.
 */

public class cardboardHardware {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor [] motors;
    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        leftMotor = ahwMap.dcMotor.get("leftMotor");
        rightMotor = ahwMap.dcMotor.get("rightMotor");



        //set motor power to 0
        leftMotor.setPower(0);
        rightMotor.setPower(0);



        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);


    }

    void move(double left, double right) {
        leftMotor.setPower(-left);
        rightMotor.setPower(right);
    }
}

