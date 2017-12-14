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
    DcMotor CollectionRightMotor;
    DcMotor CollectionLeftMotor;
    DcMotor DriveRightMotor;
    DcMotor DriveLeftMotor;
    DcMotor RotateMotor;
    DcMotor ElevatorMotor;

    Servo JewelServo;
    Servo ElevatorRightServo;
    Servo ElevatorLeftServo;
    ModernRoboticsI2cColorSensor ColorSensor;

    DcMotorSimple[] AllMotors;

    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        CollectionRightMotor = ahwMap.dcMotor.get("CollectionRightMotor");
        CollectionLeftMotor = ahwMap.dcMotor.get("CollectionLeftMotor");
        DriveRightMotor = ahwMap.dcMotor.get("DriveRightMotor");
        DriveLeftMotor = ahwMap.dcMotor.get("DriveLeftMotor");
        RotateMotor = ahwMap.dcMotor.get("RotateMotor");
        ElevatorMotor = ahwMap.dcMotor.get("ElevatorMotor");

        JewelServo = ahwMap.servo.get("JewelServo");
        ElevatorRightServo = ahwMap.servo.get("ElevatorRightServo");
        ElevatorLeftServo = ahwMap.servo.get("ElevatorLeftServo");

        //set motor power to 0
        for (DcMotorSimple motor: AllMotors) {
            motor.setPower(0);
        }

        CollectionRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        CollectionLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DriveRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DriveLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RotateMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ElevatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        DriveRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        /*/FrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        /*/

    }

    void move (double left, double right) {
        DriveRightMotor.setPower(right);
        DriveLeftMotor.setPower(left);
    }
    /*/void move(double left, double right) {
        FrontLeftMotor.setPower(-left);
        FrontRightMotor.setPower(right);
        BackLeftMotor.setPower(-left);
        BackRightMotor.setPower(right);
    }/*/
}

