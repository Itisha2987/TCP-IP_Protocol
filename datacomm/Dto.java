/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacomm;
import java.lang.Math;
import java.util.Random;
/**
 *
 * @author itisha
 */

public class Dto {
    
    public static String stringToBinary(String str){
        String bString="";
        int i;
        for(i=0;i<str.length();i++){
            int acode=str.charAt(i);
          //  System.out.print(acode);
        String temp=Integer.toBinaryString(str.charAt(i)); 
        while(temp.length()<8){
        temp= "0"+temp;
        }
        bString+=temp;
        }
    return bString;
    }
    
    private static int binaryToInt(String str){
    char[] numbers = str.toCharArray();
    int result = 0;
    for(int i=numbers.length - 1; i>=0; i--)
        if(numbers[i]=='1')
            result += Math.pow(2, (numbers.length-i - 1));
    return result;
    }
    
    public static String binaryToString(String str){
    String msg="";
    for(int i=0;i<str.length();i=i+8){
    String temp=str.substring(i, i+8);
    int acode = binaryToInt(temp);
    char c=(char)acode;
    msg+=Character.toString(c);
    }
    return msg;
    }
    //generates error of one bit
    public static String errorGenerator(String str){
        String modified_string="";
        Random rand = new Random();
        int rand_int = rand.nextInt(str.length());
        //System.out.println(rand_int);
        for(int i=0;i<str.length();i++)
        {
            if(i==rand_int)
            {
                if(str.charAt(i)=='0')
                    modified_string += "1";
                else
                    modified_string += "0";
            }
            else
            {
                modified_string += str.charAt(i);
            }
        }
        return modified_string;
    }
    
    public static String headGenerator(String str){
        Random r = new Random();
            int n = r.nextInt(16);
            String s = Integer.toBinaryString(n);
            while(s.length()<4)
                s = "0"+s;
            String ans="";
            for(int i=0;i<str.length();i+=20)
            {
                ans += s + str.substring(i,Math.min(i+20, str.length()));
            }
            return ans;
    }
    
    public static String removeHead(String str){
        String refined_msg="";
        int n=1;
        System.out.println("The data received from the clients with data-link layer head in packets is: ");
                for(int i=0;i<str.length();i+=24)
                {
                    String temp = str.substring(i,Math.min(i+24,str.length()));
                    System.out.println("Packet "+n+" is "+temp + " ");
                    refined_msg += str.substring(i+4,Math.min(i+24,str.length()));
                    n++;
                    //msg = msg.substring(4);
                }
                return refined_msg;
    }
    
    public static String Manchester(String str){
        String final_msg="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0')
                final_msg += "-11";
            else
                final_msg += "1-1";
        }
        return final_msg;
    }
   
    public static String ManchesterDecoder(String str){
        String final_str="";
        for(int i=0;i<str.length();i+=3)
        {
            String sub = str.substring(i,i+3);
            if(sub.equals("-11"))
                final_str+="0";
            else
                final_str+="1";
        }
        return final_str;
    }
    
    
}
