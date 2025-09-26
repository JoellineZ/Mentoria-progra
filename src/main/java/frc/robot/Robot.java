// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  //Lo que esta afuera es universal siempre existe
  //Variable tipo sparkmax
  public SparkMax motorDerecho1;
  public SparkMax motorDerecho2;
  public SparkMax motorIzquierdo1;
  public SparkMax motorIzquierdo2;
  public Robot() {//Esto se ejecuta al iniciar el robot
    //Iniciasion del  motor con función  ( motor = new SparkMax(numeroPuerto, MotorType.kBrushed);)
    //Donde puerto es el CAD ID y tipo de motor brushed(neo) o brushless(Sim))
    motorDerecho1 = new SparkMax(1, MotorType.kBrushed);
    motorDerecho2 = new SparkMax(2, MotorType.kBrushed);
    motorIzquierdo1 = new SparkMax(3, MotorType.kBrushed);
    motorIzquierdo2 = new SparkMax(4, MotorType.kBrushed);
  }
//Wpoilib Methods
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
