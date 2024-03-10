/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airportsimulation;

import java.util.List;
import java.util.Random;

/**
 *
 * @author user
 */
public class Airplane extends Thread {
    private Runway runway;
    private String operation; //landing or takeoff
    
    public Airplane(Runway runway, String name){
        super(name);
        this.runway = runway;
        this.operation = new Random().nextBoolean()? "landing" : "takeoff"; //randomly assign operation
    }
    
    @Override
    public void run(){
        try{
            if(operation.equals("landing")){
                runway.land(getName());
            }else if(operation.equals("takeoff")){
                runway.takeOff(getName());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
