/**
 * Created by MichaelL on 8/28/17.
 */

package org.firstinspires.ftc.teamcode.carnival1718;
import com.qualcomm.hardware.motors.NeveRest20Gearmotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class carnivalHardware {
    DcMotor railMotor;
    DcMotor flickerMotor;

    DcMotor [] motors;
    public void init(HardwareMap ahwMap) {

        // define and initialize driveMotors
        flickerMotor = ahwMap.dcMotor.get("flickerMotor");
        railMotor = ahwMap.dcMotor.get("railMotor");
        railMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors


        //set motor power to 0
        railMotor.setPower(0);
        flickerMotor.setPower(0);

        //run with encoders
        railMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }




