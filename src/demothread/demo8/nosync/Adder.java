/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo8.nosync;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Adder implements Runnable{

    private Thread theThread = null;
    private boolean isRunning = false;
    private int theDelay = 0;
    private List<Integer> theList = null;

    public Adder(List<Integer> newList, int newDelay) {
        this.theList = newList;
        this.theDelay = newDelay;
    }
    
    public Thread start(){
        if(theThread == null){
            theThread =  new Thread(this);
            theThread.start();
        }
        return theThread;
    }
    
    public void stop(){
        isRunning = false;
    }
    
    
    @Override
    public void run() {
        Random rand = new Random();
        
        isRunning = true;
        while(isRunning){
            if (theList.size() < 10) {
                theList.add(1 + rand.nextInt(10));
            }
            
            try {
                Thread.sleep(theDelay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Adder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
