/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    
    private String hostname;
    private int port;
    Socket client;
    
    public Client(String hostname,int port){
    
    this.hostname=hostname;
    this.port=port;
    
    }
    
    public void connect() throws UnknownHostException,IOException{
    System.out.println("Client is trying to connect to "+hostname+":" +port);
    client=new Socket(hostname,port);
    System.out.println("Connection is formed");
    
    }
    
    public void readResponse() throws IOException{
        String userInput;
        BufferedReader stdIn= new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        System.out.println("Response from server:");
        while((userInput= stdIn.readLine()) !=null){
            System.out.println(userInput);
        }
         
    }
   
    public static void main(String[] args) throws IOException {
        
        
        String strUserName="";
        
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter User Name: ");
	strUserName = input.readLine();
        
        
        
        Client sclient=new Client("localhost",9990);
        try{
        
        sclient.connect();
        sclient.readResponse();
        
        
        
        }catch (UnknownHostException e){
          System.err.println("Host is unknown .cannot connect");
        }catch (IOException e){
            System.err.println("cannot establish connection"+e.getMessage());
        
        
        }
    
    }
}
