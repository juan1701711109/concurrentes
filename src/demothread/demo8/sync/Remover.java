/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo8.sync;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Remover implements Runnable{

    private Thread theThread = null;
    private boolean isRunning = false;
    private int theDelay = 0;
    private List<Integer> theList = null;

    public Remover(List<Integer> newList, int newDelay) {
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
    
    //Sincronizacion por metodo, sirve cuando diferentes hilos utilizan un mismo método, en este caso no sirve
//    public synchronized void test(){
//        isRunning = true;
//        while(isRunning){
//            if (!theList.isEmpty()) {
//                theList.remove(theList.size() - 1);
//            }
//            
//            try {
//                Thread.sleep(theDelay);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Adder.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
    @Override
    public void run() {
        isRunning = true;
        while(isRunning){
            
            synchronized(theList){
                if (!theList.isEmpty()) {
                    int last = theList.size() - 1;
                    theList.remove(theList.size() - 1);
                    synchronized(System.out){
                        System.out.println(last);
                    }
                }
            }
            
            try {
                Thread.sleep(theDelay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Adder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
