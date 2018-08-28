package org.firstinspires.ftc.teamcode.G8TEST;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by MichaelL on 22/02/2018.
 */

class G8Hardware {

    DcMotor DriveRightMotor;
    DcMotor DriveLeftMotor;
    DcMotor ElevatorMotor;
    //DcMotor SlideAMotor;
    //DcMotor SlideBMotor;

    Servo GripRightServo;
    Servo GripLeftServo;
    //Servo ClawServo;
    //Servo ClawServo;

    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        DriveRightMotor = ahwMap.dcMotor.get("DriveRightMotor");
        DriveLeftMotor = ahwMap.dcMotor.get("DriveLeftMotor");
        ElevatorMotor = ahwMap.dcMotor.get("ElevatorMotor");

        //SlideAMotor = ahwMap.dcMotor.get("SlideAMotor");
        //SlideBMotor = ahwMap.dcMotor.get("SlideBMotor");

        GripRightServo = ahwMap.servo.get("GripRightServo");
        GripLeftServo = ahwMap.servo.get("GripLeftServo");
        //ClawServo = ahwMap.servo.get("ClawServo");
        //ClawServo = ahwMap.servo.get("ClawServo");


        //CollectionServo = ahwMap.servo.get("CollectionServo");

        //set motor power to 0

        DriveRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DriveLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        DriveRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        /*/FrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        /*/

        DriveRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ElevatorMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    void move (double left, double right) {
        DriveRightMotor.setPower(right);
        DriveLeftMotor.setPower(left);
    }


}
