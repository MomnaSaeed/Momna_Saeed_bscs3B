/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrawler;


import java.util.*;
import java.io.*;



/**
 *
 * @author me
 */
public class FCrawler {
    
    private WorkQueue workQ;
  static int i = 0;
 
 private class Worker implements Runnable {
 
  private WorkQueue queue;
 
  public Worker(WorkQueue q) {
   queue = q;
  }
 public void run() {
   String name;
   while ((name = queue.remove()) != null) {
    File file = new File(name);
    String entries[] = file.list();
    if (entries == null)
     continue;
    for (String entry : entries) {
     if (entry.compareTo(".") == 0)
      continue;
     if (entry.compareTo("..") == 0)
      continue;
     String fn = name + "\\" + entry;
     System.out.println(fn);
    }
   }
  }
 }
 
  public FCrawler() {
  workQ = new WorkQueue();
 }
 
 public Worker createWorker() {
  return new Worker(workQ);
 }
    
    
    public void processDirectory(String dir) {
   try{
   File file = new File(dir);
   if (file.isDirectory()) {
    String entries[] = file.list();
    if (entries != null)
     workQ.add(dir);
 
    for (String entry : entries) {
     String subdir;
     if (entry.compareTo(".") == 0)
      continue;
     if (entry.compareTo("..") == 0)
      continue;
     if (dir.endsWith("\\"))
      subdir = dir+entry;
     else
      subdir = dir+"\\"+entry;
     processDirectory(subdir);
    }
   }}catch(Exception e){}
 }
 
    public static void main(String[] args) {
        // TODO code application logic here
        
          FCrawler fc = new FCrawler();
          
          
          
          //  now start all of the worker threads
 
  int N = 5;
  ArrayList<Thread> thread = new ArrayList<Thread>(N);
  for (int i = 0; i < N; i++) {
   Thread t = new Thread(fc.createWorker());
   thread.add(t);
   t.start();
  }
 
//  now place each directory into the workQ
 
 // fc.processDirectory(Args[0]);
  
 fc.processDirectory("D://");
//  indicate that there are no more directories to add
 
  fc.workQ.finish();
 
  for (int i = 0; i < N; i++){
   try {
    thread.get(i).join();
   } catch (Exception e) {};
  }
 }
}
        
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
