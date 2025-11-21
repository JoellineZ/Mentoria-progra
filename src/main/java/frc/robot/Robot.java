// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//subsistemas
//Drivetrain (Chasis)
//Arm(Brazo robotico)
//Elevator (Elevador)
//Flywheel(Cosa que gira) 
//
//
//
//
//
//
public class Robot extends TimedRobot {
  public SparkMax motorDerecho1;
  public SparkMax motorDerecho2;
  public SparkMaxConfig RightConfig1;
  public SparkMaxConfig RightConfig2;
  public SparkMax motorIzquierdo1;
  public SparkMax motorIzquierdo2;
  public SparkMaxConfig LeftConfig1;
  public SparkMaxConfig LeftConfig2;
  public XboxController control = new XboxController(Constants.kDriverControllerPort);
  //Lo que esta afuera es universal siempre existe
  //Variable tipo sparkmax
  public  SparkMaxConfig rightConfig1;
  public  SparkMaxConfig rightConfig2;
  public Robot() {//Esto se ejecuta al iniciar el robot
    //Iniciasion del  motor con función  ( motor = new SparkMax(numeroPuerto, MotorType.kBrushed);)
    //Donde puerto es el CAD ID y tipo de motor brushed(neo) o brushless(Sim))
    //Configuración de motores
    motorDerecho1 = new SparkMax(Constants.kRight1, MotorType.kBrushed);
    motorDerecho2 = new SparkMax(Constants.kRight2, MotorType.kBrushed);
    RightConfig1 = new SparkMaxConfig();
    RightConfig2 = new SparkMaxConfig();
    RightConfig1.inverted(true);
    RightConfig2.follow(motorDerecho1);
    motorDerecho1.configure(RightConfig1, null, null);
    motorDerecho2.configure(RightConfig2, null, null);
    motorIzquierdo1 = new SparkMax(Constants.kLeft1, MotorType.kBrushed);
    motorIzquierdo2 = new SparkMax(Constants.kLeft2, MotorType.kBrushed);
    LeftConfig1 = new SparkMaxConfig();
    LeftConfig2 = new SparkMaxConfig();
    LeftConfig1.inverted(false);
    LeftConfig2.follow(motorIzquierdo1);
    motorIzquierdo1.configure(LeftConfig1, null, null);
    motorIzquierdo2.configure(LeftConfig2, null, null);
  }
//Wpoilib Methods git hub commands git add "document"
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    //drive();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {
    //Primera forma de moverse Equipo 2791 https://github.com/Team2791/Shaker_Drive_Base/tree/master
    //shakyDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		//shakyDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    //shakyDrive = new RobotDrive(new SpeedControllerSet(leftSparkA,leftSparkB), new SpeedControllerSet(rightSparkA,rightSparkB));
    //

		//SmartDashboard.putNumber("Left Drive Encoders Rate", leftDriveEncoder.getRate());
		//SmartDashboard.putNumber("Right Drive Encoders Rate", rightDriveEncoder.getRate());
		//SmartDashboard.putNumber("Encoder Angle", getAngleEncoder());
//
		//SmartDashboard.putNumber("LEncoderDistance", leftDriveEncoder.getDistance());
		//SmartDashboard.putNumber("REncoderDistance", rightDriveEncoder.getDistance());
		//SmartDashboard.putNumber("AvgEncoderDistance", getAverageDist());
//
		//SmartDashboard.putNumber("Gyro angle", gyro.getAngle());
		//SmartDashboard.putNumber("Gyro rate", gyro.getRate());
//
		//SmartDashboard.putNumber("Avg Acceleration", getAverageAcceleration());
		//
		//SmartDashboard.putNumber("Drivetrain total current", getCurrentUsage());
//
//
		//SmartDashboard.putString("LDist vs RDist vs AvgDist", getLeftDistance()+":"+getRightDistance()+":"+getAverageDist());
		//SmartDashboard.putString("LVel vs RVel vs AvgVel", getLeftVelocity()+":"+getRightVelocity()+":"+getAverageVelocity());
		//SmartDashboard.putString("LAcc vs RAcc vs AvgAcc", getLeftAcceleration()+":"+getRightAcceleration()+":"+getAverageAcceleration());

    //Segunda forma de moverse
    //Forma de moverse mas simple
    //double speed = -joy1.getRawAxis(1) * 0.6;
    //double turn = joy1.getRawAxis(1) * 0.3;
    //double left = speed + turn;
    //double right = speed - turn;
    //motorDerecho1.set(-right);
    //motorDerecho2.set(-right);
    //motorIzquierdo1.set(left);
    //motorIzquierdo2.set(left);
    //Driver 
    drive(new ChassisSpeeds(
      -control.getLeftY()*Constants.kMeterSecondProportion, //SpeedX(Y) = -Y*kMeterProportion
      0.0,
      control.getRightX() * Constants.kRadProportion));
    //drive();
  }
  // Escribir un metodo Drive que tome como parametros la velocidad V y velocidad angular W
  //Forma Pro de Chasis
  public void drive(ChassisSpeeds speeds){
    double V = speeds.vxMetersPerSecond;
    double W = speeds.omegaRadiansPerSecond/(2*Math.PI);
    double speedR = V+W;
    double speedL = V-W; 
    motorDerecho1.set(speedR);
    motorDerecho2.set(speedR);
    motorIzquierdo1.set(speedL); 
    motorIzquierdo1.set(speedL);
  }
  public void drive2(double speed, double rot){
    //dDrive
  }
}
