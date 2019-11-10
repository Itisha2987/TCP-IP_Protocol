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
            out.println(finalString);
	    
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
