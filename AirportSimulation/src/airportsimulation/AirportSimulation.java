/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airportsimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.Random;

/**
 *
 * @author user
 */
public class AirportSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Runway runway = new Runway();
        
        Random random = new Random();
        
        //simulate 30 airplanes with random operations and names
        for(int i = 1; i<=30; i++){
            //String planeName = "Plane " + i + " (" + (random.nextBoolean()?"landing" : "takeoff") + ") ";
            String planeName = "Plane " +(char)(random.nextInt(26)+'A') + (random.nextInt(900)+100);
            Airplane plane = new Airplane(runway, planeName);
            plane.start();
            
            try{
                //wait before launching next plane
                Thread.sleep(random.nextInt(500)); //control the next flight gap duration
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        
        //create and start airplane threads
        //Airplane plane1 = new Airplane(runway, "Plane 1", "landing");
        //Airplane plane2 = new Airplane(runway, "Plane 2", "takeoff");
        //Airplane plane3 = new Airplane(runway, "Plane 3", "landing");
        
        //plane1.start();
        //plane2.start();
        //plane3.start();
    }
    
}
