/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread.demo3;

import demothread.demo1.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyThread t1 = null;
        MyThread t2 = null;
        MyThread t3 = null;
        MyThread.OnChange delegate = null;
        
//        delegate = (id,value) -> {
//            System.out.println("Task: "+ id +" Cont: " + value);
//            //JOptionPane.showMessageDialog(null,"Task: "+ id +"Cont: " + value);
//        };
        
//        t1 = new NoThread(1, delegate);
//        t2 = new NoThread(2, delegate);
//        t3 = new NoThread(3, delegate);

        t1 = new MyThread(1, (id, value) -> {
            System.out.println("Task: "+ id +" Cont: " + value);
        });
        
        t2 = new MyThread(2, (id, value) -> {
            System.out.println("Task: "+ id +" Cont: " + value);
        });
        
        t3 = new MyThread(3, (id, value) -> {
            System.out.println("Task: "+ id +" Cont: " + value);
        });
        
        System.out.println("Start 1");
        t1.start();
        System.out.println("Start 2");
        t2.start();
        System.out.println("Start 3");
        t3.start();
        System.out.println("End");
                
    }
    
}
