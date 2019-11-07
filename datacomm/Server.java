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
	public static void main(String[] args) {
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
                String error_generated_string = Dto.errorGenerator(msg);
		System.out.println("Encoded string received from client " + error_generated_string);
                System.out.println("Before decoding and error removal message is "+ Dto.binaryToString(error_generated_string));
                System.out.println("After decoding and error removal message is "+ Dto.binaryToString(msg));
                //Replying to client
		System.out.println("Enter the reply");
		Scanner myObj = new Scanner(System.in);
                String reply = myObj.nextLine();		
		PrintWriter out= new PrintWriter(soc.getOutputStream(),true);
	        out.println(Dto.stringToBinary(reply));
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
}

