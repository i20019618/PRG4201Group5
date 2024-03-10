/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airportsimulation;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class Runway extends Thread {
    //semaphore control runway access (1 mean only 1 plane can use runway
    private Semaphore semaphore = new Semaphore(1);
    
    //method for planes to land
    public void land(String planeName) throws InterruptedException{
        semaphore.acquire(); //acquire access to runway
        System.out.println(planeName + " is landing.");
        Thread.sleep(1000); //simulate time taken for landing
        System.out.println(planeName + " has landed.");
        semaphore.release(); //release runway
    }
    
    public void takeOff(String planeName) throws InterruptedException{
        semaphore.acquire(); //acquire access to runway
        System.out.println(planeName + " is taking off.");
        Thread.sleep(1000); //simulate time taken for takeoff
        System.out.println(planeName + " has taken off.");
        semaphore.release(); //release runway
    }
}
