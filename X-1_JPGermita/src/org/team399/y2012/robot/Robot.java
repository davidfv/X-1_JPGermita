/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team399.y2012.robot;

import org.team399.y2012.Utilities.PrintStream;
import org.team399.y2012.robot.Controls.Automation.AutoAimController;
import org.team399.y2012.robot.Controls.Automation.AutoShootController;
import org.team399.y2012.robot.Controls.Automation.AutoShooterSpeedController;
import org.team399.y2012.robot.Systems.*;
import org.team399.y2012.robot.Systems.Imaging.*;

/**
 * Class to encapsulate all mechanisms into one class
 * @author Jeremy
 */
public class Robot {

    public DriveTrain drive;     //Drivetrain Instance
    public Shooter shooter;         //Shooter instance
    public Intake intake;            //Intake instance
    public Turret turret;            //Turret instance
    public EagleEye eye;           //Eagle Eye Instance
    private PrintStream ps_bot = new PrintStream("[ROBOT] ");   //Printstream for deubgging
    public AutoShootController shootController;
    public AutoShooterSpeedController shooterSpeedController;
    public AutoAimController aic;

    /**
     * Constructor. Insert any other initialization commands here
     */
    public Robot() {
        ps_bot.println("Initialization started...");

        drive = new DriveTrain();     //Drivetrain Instantiation
        shooter = new Shooter();      //Shooter instantiation
        intake = new Intake();        //Intake instantiation
        turret = new Turret();        //Turret instantiation
        eye = new EagleEye();         //Eagle Eye Instantiation
        ps_bot.println("Systems Initialized");
        shooterSpeedController = new AutoShooterSpeedController();
        shootController = new AutoShootController(shooter, intake, shooterSpeedController);

        ps_bot.println("Initialization complete");
    }

    /**
     * Basic run method. Insert universal functionality here. That is, functionality that 
     * will be common between autonomous and teleoperated modes. 
     */
    public void run() {
        shooter.update();
    }
}
