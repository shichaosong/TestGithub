package com.design.patten.singleten;

/**
 * Snippet 4 
 *
 */
public class Singleton4 {  
    private static Singleton4 instance = null;  
   
    private Singleton4(){
    	
    }  
   
    public static Singleton4 getInstance() {  
        if(instance == null){ 
        	synchronized(Singleton4.class){  
                if(instance == null)  
                    instance = new Singleton4();  
            }  
        }
   
        return instance;  
    }  
} 


// 采用Snippet 1 或者Snippet 3 比较安全。Snippet 2和Snippet 4最好在多线程的环境下不要使用，否则可能会出错。