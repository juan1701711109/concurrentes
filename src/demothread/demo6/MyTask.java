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
public class MyTask implements Runnable {
    
    private Thread thethread = null;
    private int id = 0;
    private OnChange theDaelegate = null;
    
    private long theTime = -1;
    
    public MyTask(int newId, OnChange newDelegate){
        id = newId;
        theDaelegate = newDelegate;
        
    }
    
    public Thread start(){
        if((getThread() == null)){
            thethread = new Thread(this);
            getThread().start();
        }
            return getThread();
        
    }
    
    public boolean isPrimo(int num){
        final int UPPER_LIMIT = (num - 1);
        boolean isPrimo = false;
        int divCounter = 2;
        
        if(num > 1){
            for (int i = 2; i <= UPPER_LIMIT; i++) {
                if(num % i == 0){
                    divCounter++;
                }
            }
            
            isPrimo = (divCounter == 2);
        }
        return isPrimo;
    }
    
    @Override
    public void run(){
        long ini = 0;
        long fin = 0;
        long dif = 0;
        
        ini = System.currentTimeMillis();
        
        isPrimo(2_147_483_629);
        
        fin = System.currentTimeMillis();

        theTime = (fin-ini);
        if(theDaelegate != null){
            
        }
    }
    
    public interface OnChange{
        public abstract void show(int id, int value);
    }

    /**
     * @return the thethread
     */
    public Thread getThread() {
        return thethread;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the theTime
     */
    public long getTime() {
        return theTime;
    }
    
}
