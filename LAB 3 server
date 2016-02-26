/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author msaeed.bscs13seecs
 */
public class Server {

    
    private ServerSocket serverSocket;
    private int port;
    
    
    public Server(int port){
       this.port=port;
    
    }
   public void start() throws IOException {
       System.out.println("The server starts at port :"+ port);
       serverSocket=new ServerSocket(port);
       
       
       System.out.println("Looking for clients");
       Socket client=serverSocket.accept();
       
       sendWelcomeMessage(client);
       
   }
   
   private void sendWelcomeMessage(Socket client) throws IOException {
   
        BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        writer.write("Hello this is  server");
        writer.flush();
        writer.close();
   
   }
   
 
    public static void main(String[] args) {
        // TODO code application logic here
        int portNumber=9990;
        
        try{
           
            Server server=new Server(portNumber);
            server.start();
            
        }catch (IOException e){
            e.printStackTrace();
        }    
    }
    
}
