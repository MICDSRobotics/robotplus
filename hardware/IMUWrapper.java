package org.firstinspires.ftc.teamcode.robotplus.hardware;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

/**
 * Wrapper class for the REV's onboard IMU
 * @author Alex Migala, Nick Clifford, Blake Abel
 * @since 9/28/17
 */

public class IMUWrapper {

    private BNO055IMU imu;

    public IMUWrapper(HardwareMap map) {
        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        params.angleUnit            = BNO055IMU.AngleUnit.DEGREES;
        params.accelUnit            = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        params.calibrationDataFile  = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        params.loggingEnabled       = true;
        params.loggingTag           = "IMU";
        params.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        this.imu = map.get(BNO055IMU.class, "sensor_imu");
        this.imu.initialize(params);
    }

    public BNO055IMU getIMU() { return this.imu; }

    public Orientation getOrientation() { return this.imu.getAngularOrientation(); }

    public Position getPosition() { return this.imu.getPosition(); }

}
