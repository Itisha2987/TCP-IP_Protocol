/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacomm;

/**
 *
 * @author itisha
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TCPClient {
  public static void main(String[] args) throws Exception {
  try{
    Socket socket=new Socket("127.0.0.1",8888);
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";
    do{
      System.out.println("Enter your message (Enter 'bye' to exit the connection from server) :");
      clientMessage=br.readLine();
      if(clientMessage.equals("bye"))break;
      
      Scanner myObj = new Scanner(System.in);
       String binaryString = Dto.stringToBinary(clientMessage);
            System.out.println("Encoded message generated is: " + binaryString);
          
            //Genarting error in the encoded message
             System.out.println("Generate error enter y if yes and n otherwise");
             String e = myObj.nextLine();
             String error_generated_string="";
             String crc_generated_string;
             if(e.equals("y")){
             error_generated_string = Dto.errorGenerator(binaryString);
              crc_generated_string= CRC.cRCGenerator(binaryString, error_generated_string, true);
             }
             else{
              crc_generated_string = CRC.cRCGenerator(binaryString, error_generated_string, false);
             }
            //Adding 4-bit header of the data-link layer
            String finalString = Dto.headGenerator(crc_generated_string);
            System.out.println("Encoded message sent to the server is: " + finalString);
      
      
      outStream.writeUTF(finalString);
      outStream.flush();
      serverMessage=inStream.readUTF();
      System.out.println(serverMessage);
    }while(!clientMessage.equals("bye"));
    outStream.close();
    outStream.close();
    socket.close();
  }catch(Exception e){
   // System.out.println(e);
  }
  }
}