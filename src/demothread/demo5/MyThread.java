/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo5;


/**
 *
 * @author Lenovo
 */
public class MyThread implements Runnable{
    private Thread thethread = null;
    private int cont= 0;
    private int id = 0;
    private OnChange theDaelegate = null;
    private int theIniValue = 0;
    private int theEndValue = 0;
    
    public MyThread(int newId, OnChange newDelegate){
        id = newId;
        theDaelegate = newDelegate;
        thethread = new Thread(this);
    }
    
    public Thread start(int newIniValue, int newEndValue){
        theIniValue = newIniValue;
        theEndValue = newEndValue;
        
        thethread.start();
        
        return thethread;
    }
    
    @Override
    public void run(){
        for (int i = theIniValue; i < theEndValue; i++) {
            cont++;
            if(theDaelegate != null){
                theDaelegate.show(id, i);
            }
        }
    }
    
    public interface OnChange{
        public abstract void show(int id, int value);
    }
}
