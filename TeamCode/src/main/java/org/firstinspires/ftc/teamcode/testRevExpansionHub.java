package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by johnduval on 8/25/17.
 */

@TeleOp(name = "test_one_motor")

public class testRevExpansionHub extends OpMode {
    DcMotor neveRest40_1;

    double rightStickDriveValue;
    double leftStickDriveValue;
    double rightSquaredDriveValue;
    double leftSquaredDriveValue;

    @Override
    public void init() {
        neveRest40_1 = hardwareMap.dcMotor.get("neveRest40-1");

    }

    @Override
    public void loop() {
        rightStickDriveValue = -gamepad1.right_stick_y;
        leftStickDriveValue = -gamepad1.left_stick_y;
        rightSquaredDriveValue = rightStickDriveValue * rightStickDriveValue;
        leftSquaredDriveValue = leftStickDriveValue * leftStickDriveValue;

        leftSquaredDriveValue = Range.clip(leftSquaredDriveValue, -1, 1);
        rightSquaredDriveValue = Range.clip(rightSquaredDriveValue, -1, 1);

        if (rightStickDriveValue < 0) {
            neveRest40_1.setPower(-rightSquaredDriveValue);
        } else {
            neveRest40_1.setPower(rightSquaredDriveValue);
        }
    }
}
