/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo2;

import demothread.demo1.*;

/**
 *
 * @author Lenovo
 */
public class MyThread extends Thread{
    
    private int cont= 0;
    private int id = 0;
    private OnChange theDaelegate = null;
    
    public MyThread(int newId, OnChange newDelegate){
        id = newId;
        theDaelegate = newDelegate;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            cont++;
            if(theDaelegate != null){
                theDaelegate.show(id, cont);
            }
        }
    }
    
    public interface OnChange{
        public abstract void show(int id, int value);
    }
}
