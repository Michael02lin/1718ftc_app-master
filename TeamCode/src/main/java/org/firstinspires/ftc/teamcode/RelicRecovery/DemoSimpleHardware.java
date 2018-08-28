package org.firstinspires.ftc.teamcode.RelicRecovery;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by MichaelL on 9/25/17.
 */

public class DemoSimpleHardware {
    DcMotor Motor1;
    DcMotor Motor2;
    Servo Servo1;
    CRServo CRServo1;

    DcMotor CRServo;

    DcMotor [] motors;

    //Servo JewelServo;
    //ModernRoboticsI2cColorSensor JewelSensor;

    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        Motor1 = ahwMap.dcMotor.get("Motor1");
        Motor2 = ahwMap.dcMotor.get("Motor2");

        //JewelServo = ahwMap.servo.get("JewelServo");
        Servo1 = ahwMap.servo.get("Servo1");
        CRServo1 = ahwMap.crservo.get("CRServo1");

        //set motor power to 0
        Motor1.setPower(0);
        Motor2.setPower(0);

        Motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor2.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    /*/void move(double left, double right) {
        frontleftMotor.setPower(-left);
        frontrightMotor.setPower(right);
        backleftMotor.setPower(-left);
        backrightMotor.setPower(right);
    }/*/
}

