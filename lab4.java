/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spider;


import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author me
 */
public class Spider {

	public static Map<String, String> fstring=new HashMap<String, String>();
	public static List<String> fnames = new ArrayList<>();
	public static List<String> fpath = new ArrayList<>();
	
	public static void GetFileDetails(final File folder) {	
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	GetFileDetails(fileEntry);
	        } else {
	            fnames.add(fileEntry.getName());
	            fpath.add(fileEntry.getAbsolutePath());
	            
	        }
	    }
	}
	
	public static String GetFileContent(String filepath) {
		String n_string;
        File file = new File(filepath);
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        n_string=builder.toString();
        return n_string;
		 
	}
	

	public static void main(String [ ] args){
		final File folder = new File("D:/lab4");
		GetFileDetails(folder);
		String n_string;

		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a string or text to search in your local file system");
	        n_string = in.nextLine();
                
                         
        public static  void GetFileContent(final File Content {
    for (final File fileEntry : fstring.listFiles()) {
        if (fileEntry.isDirectory()) {
           GetFileContent(fileEntry);
        } else {
            System.out.println(fileEntry.getName());
        }
    }
}
          
                
                
                
  private static void addfiles (File input,ArrayList<File> files)
{
    if(input.isDirectory())
    {
        ArrayList <File> path = new ArrayList<File>(Arrays.asList(input.listFiles()));
        for(int i=0 ; i<path.size();++i)
        {
            if(path.get(i).isDirectory())
            {
                addfiles(path.get(i),files);
            }
            if(path.get(i).isFile())
            {
                files.add(path.get(i));
            }
        }
    }
    if(input.isFile())
    {
        files.add(input);
    }
}       
                
                
                
                
                
		
		
		
		 File file1;
		 String name1;
		
		for (String x : fpath) {
			 file1 = new File(x);
			 name1=file1.getName();
			
			
			fstring.put(name1,GetFileContent(x));
			
			
		}
		
		
		
		
		for (Map.Entry<String, String> entry : fstring.entrySet())
		{
			
			   if(entry.getValue().toLowerCase().contains(n_string.toLowerCase())){
				   
				  
				
				   System.out.println("Entered string exists in your this file: "+entry.getKey());}
			
			
		}
		
		
	}
	
}





    
