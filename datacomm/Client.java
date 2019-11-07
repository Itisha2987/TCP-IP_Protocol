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
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Client
{
	public static void main(String[] args) {
	    try{
		System.out.println("Client Started");
		System.out.println("Sending Client Request");
	    Socket soc = new Socket("localhost",9806);
          
            //Echoing string
            //Sending message to server
	    System.out.println("Enter the message....");
            Scanner myObj = new Scanner(System.in);
            String msg = myObj.nextLine();
	    PrintWriter out= new PrintWriter(soc.getOutputStream(),true);
            String binaryString = Dto.stringToBinary(msg);
            System.out.println("Encoded message being sent to server is: "+binaryString);
           // System.out.println(Dto.binaryToString(binaryString));
            out.println(binaryString);
	    
            //Receiving reply from server
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
 	    String reply = in.readLine();
	    System.out.println("reply sent from server " + reply);
            System.out.println("Decoded reply: "+Dto.binaryToString(reply));
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
