// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Random;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ColorWheel extends SubsystemBase {
  /** Creates a new ColorWheel. */

  public static final class Config{
    public static final String[] colorWheel = {"Red", "Green", "Yellow", "Blue", "Red", "Green", "Yellow", "Blue"};
    public static final Random random = new Random();
    public static final int currentColorNumber = random.nextInt(colorWheel.length);
    public static final int colorNumberToFind = random.nextInt(colorWheel.length);
    public static int[] colorNumbersToFind;
    public static int finalColorNumber;     

  }
  
  
  public ColorWheel() {
    
    for (int i = 0; i <= Config.colorWheel.length; i = i + 1){
      if (Config.colorWheel[i].equals(Config.colorWheel[Config.colorNumberToFind])){
        int a = 0;
        Config.colorNumbersToFind[a] = i;
        a += 1;
        //finds the strings in colorWheel that are equal to the color you want to find
        }


    } 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void MoveColorWheel () {
    
    System.out.println("The current color on the wheel is " + Config.colorWheel[Config.currentColorNumber]);

    System.out.println("The color we want to get to is " + Config.colorWheel[Config.colorNumberToFind]);
    
    if (Math.abs(Config.currentColorNumber - Config.colorNumbersToFind[0]) <= Math.abs(Config.currentColorNumber - Config.colorNumbersToFind[1])) {
      Config.colorNumbersToFind[0] = Config.finalColorNumber;
    }
    
    else if (Math.abs(Config.currentColorNumber - Config.colorNumbersToFind[0]) >= Math.abs(Config.currentColorNumber - Math.abs(Config.colorNumbersToFind[1]))){
      Config.colorNumbersToFind[1] = Config.finalColorNumber;
   }
     
   else if (Math.abs(Config.currentColorNumber - Config.colorNumbersToFind[0]) == Math.abs(Config.currentColorNumber - Math.abs(Config.colorNumbersToFind[1]))){
     Config.colorNumbersToFind[1] = Config.finalColorNumber;

   }
   //determines which number is closer and if that number is closer than it makes that the final color number 


     if (Config.finalColorNumber > 0) {

      System.out.println("The wheel will need to move " + Config.finalColorNumber + " turns to the right to land on the goal color in the least moves");
     }
     else if (Config.finalColorNumber < 0) {
       System.out.println("The wheel will need to move " + Config.finalColorNumber + " turns to the left to land on the goal color in the least moves");
     }
     else if (Config.finalColorNumber == 0) {
       System.out.println("The wheel is already at the goal color");
     }
     //determines which way the wheel has to turn and also prints the amount it has to turn

}
}
 