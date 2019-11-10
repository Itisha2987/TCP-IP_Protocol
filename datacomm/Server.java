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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Server
{
	/*public static void main(String[] args) {
	    try{
		System.out.println("Server Started");
		System.out.println("Waiting for Client Request");
		ServerSocket ss = new ServerSocket(9806);
		Socket soc = ss.accept();
		System.out.println("Connection Established");

 		//Echoing string at server side
   		//Receiving from client side
                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
 		String msg=in.readLine();
                String refined_msg=Dto.removeHead(msg);
              //  String error_generated_string = Dto.errorGenerator(refined_msg);
		System.out.println("Encoded string received from client after removing header bits " + refined_msg);
             //   System.out.println("Decoded message before error removal is "+ Dto.binaryToString(refined_msg));
             //   System.out.println("After decoding and error removal message is "+ Dto.binaryToString(refined_msg));
                //Replying to client
		boolean error_flag = CRC.isErrorPresent(refined_msg);
                if(error_flag){
                    String reply = "Error detected!! Send message again";		
		PrintWriter out= new PrintWriter(soc.getOutputStream(),true);
	        out.println(Dto.stringToBinary(reply));
                }
                else{
                    System.out.println("Enter the reply");
		Scanner myObj = new Scanner(System.in);
                String reply = myObj.nextLine();		
		PrintWriter out= new PrintWriter(soc.getOutputStream(),true);
	        out.println(Dto.stringToBinary(reply));
                }
                
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}*/
}

