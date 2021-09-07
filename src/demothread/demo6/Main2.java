/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Main2 {
    public static void main(String[] args) {
        final int MAX_Tasks = 3;
        long ini = 0;
        long fin = 0;
        long dif = 0;

        MyTask[] tasks = new MyTask[MAX_Tasks];
        
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new MyTask(i+1, null);
        }
        
        ini = System.currentTimeMillis();
        
        for (MyTask task : tasks){
            task.start();
        }
        
        for (MyTask task : tasks) {
            try {
                task.getThread().join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        fin = System.currentTimeMillis();
        
        dif = (fin - ini);
        
        System.out.println("#Threads: "+ tasks.length + "Total Time: "+ (dif/1000));
    }
}
