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
	    System.out.println("Enter a string");
            Scanner myObj = new Scanner(System.in);
            String msg = myObj.nextLine();
	    PrintWriter out= new PrintWriter(soc.getOutputStream(),true);
	    out.println(msg);
            System.out.println(Dto.stringToBinary(msg));
	    BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
 	    String reply = in.readLine();
	    System.out.println(reply);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
