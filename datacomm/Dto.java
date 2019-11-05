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
            System.out.print(acode);
        String temp=Integer.toBinaryString(str.charAt(i)); 
        while(temp.length()<8){
        temp= "0"+temp;
        }
        bString+=temp;
        }
    return bString;
    } 
}
