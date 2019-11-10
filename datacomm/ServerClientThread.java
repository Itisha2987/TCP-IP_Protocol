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

class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;
 // int squre;
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
  public void run(){
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String clientMessage="", serverMessage="";
      while(true){
        clientMessage=inStream.readUTF();
        System.out.println("Message from Client-" +clientNo+ "is : "+clientMessage);
      //  squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
       
      
       String refined_msg=Dto.removeHead(clientMessage);
              //  String error_generated_string = Dto.errorGenerator(refined_msg);
 System.out.println("Encoded string received from client after removing header bits " + refined_msg);
             //   System.out.println("Decoded message before error removal is "+ Dto.binaryToString(refined_msg));
             //   System.out.println("After decoding and error removal message is "+ Dto.binaryToString(refined_msg));
                //Replying to client
		boolean error_flag = CRC.isErrorPresent(refined_msg);
                if(error_flag){
                    serverMessage = "Error detected!! Send message again";		
		 outStream.writeUTF(serverMessage);
                 outStream.flush();
                }
                else{
                    String actual_msg = CRC.removeCRCCode(refined_msg);
                    System.out.println("After decoding and error detection message is "+ Dto.binaryToString(actual_msg));
                    if(clientMessage.equals("bye")){
                    break;
                    }
                    else{
                    System.out.println("Enter the reply");
		Scanner myObj = new Scanner(System.in);
                serverMessage = br.readLine();		
		outStream.writeUTF(serverMessage);
                outStream.flush();
                }
                }
      
     /* System.out.println("Enter Reply");
       serverMessage=br.readLine();
    //  serverMessage="From Server to Client-" + clientNo + " Square of " + clientMessage + " is " +squre;
        outStream.writeUTF(serverMessage);
        outStream.flush();*/
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception ex){
     // System.out.println(ex);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}
