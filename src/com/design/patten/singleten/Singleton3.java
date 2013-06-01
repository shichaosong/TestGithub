package com.design.patten.singleten;

/**
 * Snippet 3 
 */
public class Singleton3 {  
    private static Singleton3 instance = null;  
   
    private Singleton3(){
    	
    }  
   
    public static synchronized Singleton3 getInstance() {  
        if(instance == null){
            instance = new Singleton3();  
        }
        return instance;  
    }  
} 