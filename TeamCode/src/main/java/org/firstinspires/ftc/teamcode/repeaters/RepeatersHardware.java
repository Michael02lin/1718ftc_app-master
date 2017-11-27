package org.firstinspires.ftc.teamcode.Repeaters;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by MichaelL on 9/25/17.
 */

public class RepeatersHardware {
    DcMotor FrontLeftMotor;
    DcMotor FrontRightMotor;
    DcMotor BackLeftMotor;
    DcMotor BackRightMotor;

    DcMotor [] AllMotors;

    Servo JewelServo;
    ModernRoboticsI2cColorSensor ColorSensor;

    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        FrontLeftMotor = ahwMap.dcMotor.get("FrontLeftMotor");
        FrontRightMotor = ahwMap.dcMotor.get("FrontRightMotor");
        BackLeftMotor = ahwMap.dcMotor.get("BackLeftMotor");
        BackRightMotor = ahwMap.dcMotor.get("BackRightMotor");

        JewelServo = ahwMap.servo.get("JewelServo");

        //set motor power to 0
        FrontLeftMotor.setPower(0);
        FrontRightMotor.setPower(0);
        BackLeftMotor.setPower(0);
        BackRightMotor.setPower(0);

        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);


    }

    void move(double left, double right) {
        FrontLeftMotor.setPower(-left);
        FrontRightMotor.setPower(right);
        BackLeftMotor.setPower(-left);
        BackRightMotor.setPower(right);
    }
}

