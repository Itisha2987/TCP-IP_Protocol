/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacomm;
import java.lang.Math;
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
    //System.out.println(temp+" "+acode);
    char c=(char)acode;
    msg+=Character.toString(c);
    }
    return msg;
    }
}
