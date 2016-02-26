/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author msaeed.bscs13seecs
 */

import java.io.*;
public class user implements java.io.Serializable {
    
}

try{
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/user.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
}catch(IOException i){
          i.printStackTrace();
      }
   }
}
