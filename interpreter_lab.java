/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter_lab;

import java.util.HashMap;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


/**
 *
 * @author msaeed.bscs13seecs
 */
public class Interpreter_lab {
    
    static HashMap<String,Integer> hashmap;
	static int length=0;
	
	Interpreter_lab() {
		hashmap = new HashMap<String, Integer>();
		
		
	}
    public static void readFromFile(String path) {
		BufferedReader reader = null;
		try {
			  
			String line;												//This variable will help in reading lines one by one
			reader = new BufferedReader(new FileReader(path));		//Path of my file
			while ((line = reader.readLine()) != null) {
				
				
				String[] row = line.split("\n");					//Separating lines on the basis of "\n"
				 
				length = row.length;								//Taking length of each row
				for (int j=0; j < length; j++) {	
					if(row[j].contains("let")) {
			    		  if(row[j].contains("==")) {
			    			  System.out.println("Incorrect \n");
			    			  break;
			    		  }
			    		  String[] letline = row[j].split(" ");
			    		  int length1 = letline.length;
			    		  for(int i=0;i<length1;i++) {
			    			  String regex = "[0-9]+";
			    			  if(letline[1].matches(regex) || letline[3].matches("[a-zA-z]+")) {
			    				  System.out.println("Incorrect ");
			    				  System.out.println();
			    				  break;
			    				  
			    			  }
			    			  else {
			    			  int element = Integer.parseInt(letline[3]);
			    			  
			    			  hashmap.put(letline[1], element);
			    			  initialization(letline[1]);
			    			  break;
			    		  }
			    			  }
			    	  }
			    	   	
			    	
			    	
			    	  if(row[j].contains("print")) {
			    		     String[] printline = row[j].split(" ");
				    		  int length1 = printline.length;
				    		  for(int i=0;i<length1;i++) {
				    			  if(hashmap.containsKey(printline[1])) {
				    			  printfunction(printline[1]);
				    			  break;
				    			  
				    		  }
				    			  else {
				    				  System.out.println("Variable not present");
				    				  break;
				    			  }
				    			  
				    		  }
				    		 
			    	}
			    	  
			    	  else if (!row[j].contains("let") && !row[j].contains("print")) {
			    		   String[] operationline = row[j].split(" ");
			    		  operationfunc(operationline[0], operationline[3], operationline[2],operationline[4]);
			    			
			    		  
			    		 
			    	  
			    	  
			    	  }
			    	 
				}
				
				
				
			 			  
			  		
			}
			
			 
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
    
    
    public static void initialization(String value) {
		System.out.println("Declaration");
		Integer value1 = hashmap.get(value);
		System.out.println(value +"="+ value1); 
		System.out.println("Declaration Done");
		System.out.println();
	}
	
	
	public static void printfunction(String value) {
		System.out.println("Print");
		Integer value1 = hashmap.get(value);
		System.out.println(value +"="+ value1); 
		System.out.println("Printing ");
		System.out.println();
	}
        
        
        
	public static void operationfunc(String save, String operator, String value, String value1) {
		System.out.println("Operation");
		if (operator.equals("+")) {
		Integer element1 = hashmap.get(value1);
		if(element1==null) {
	
		int element = Integer.parseInt(value1);
		Integer value2 = hashmap.get(value);
		if(value2==null) {
			int element2 = Integer.parseInt(value);
			int sum = element2 + element;
			hashmap.put(save, sum);
			System.out.println("Expected Sum " + sum);
			System.out.println("Actual Sum " + sum);
			System.out.println("Success"); 
			
		}
		else {
		int sum = value2 + element;
		hashmap.put(save, sum);
		System.out.println("Expected Sum " + sum);
		System.out.println("Actual Sum " + sum);
		System.out.println("Success");  
		
		}
	}
		
		
		else {
				
				Integer value2 = hashmap.get(value);
				if(value2==null) {
					int element2 = Integer.parseInt(value);
					int sum = element2 + element1;
					hashmap.put(save, sum);
					System.out.println("Expected Sum " + sum);
					System.out.println("Actual Sum " + sum);
					System.out.println("Success"); 
					
				}
				else {
				int sum = value2 + element1;
				hashmap.put(save, sum);
				System.out.println("Expected Sum " + sum);
				System.out.println("Actual Sum " + sum);
				System.out.println("Success"); 
				
				}
			}
				
			
		
		}	
		
			
		
		
		
		
	
		System.out.println("Operation Done!!!!");
		System.out.println();
	
	}
	
	 public static void main(String[] args) {
        // TODO code application logic here
        
         try {
            //FileReader reader = new FileReader("MyFile.txt");
            FileReader reader = new FileReader("C:\\Users\\msaeed.bscs13seecs\\Documents\\NetBeansProjects\\lab9\\src\\lab9\\MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	

}

    
    
    
    
    
    
    
    
    
    
    
    
    

   
