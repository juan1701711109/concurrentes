/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo6;

/**
 *
 * @author Lenovo
 */
public class Main1 {
    public static void main(String[] args) {
        MyTask task = new MyTask(0, null);
        
        task.run();
        
        System.out.println("Time: "+ (task.getTime()/1000));
    }
}
