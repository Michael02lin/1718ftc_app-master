package org.firstinspires.ftc.teamcode.repeaters;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by MichaelL on 9/25/17.
 */

public class mecanumHardware {
    DcMotor frontleftMotor;
    DcMotor frontrightMotor;
    DcMotor backleftMotor;
    DcMotor backrightMotor;

    DcMotor [] motors;
    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        frontleftMotor = ahwMap.dcMotor.get("frontleftMotor");
        frontrightMotor = ahwMap.dcMotor.get("frontrightMotor");
        backleftMotor = ahwMap.dcMotor.get("backleftMotor");
        backrightMotor = ahwMap.dcMotor.get("backrightMotor");


        //set motor power to 0
        frontleftMotor.setPower(0);
        frontrightMotor.setPower(0);
        backleftMotor.setPower(0);
        backleftMotor.setPower(0);

        frontleftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontrightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backleftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backrightMotor.setDirection(DcMotorSimple.Direction.FORWARD);


    }

    void move(double left, double right) {
        frontleftMotor.setPower(-left);
        frontrightMotor.setPower(right);
        backleftMotor.setPower(-left);
        backrightMotor.setPower(right);
    }
}

