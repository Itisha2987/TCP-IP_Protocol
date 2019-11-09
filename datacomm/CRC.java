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
public class CRC {
    
    private static String divisor="1101";
    private static String allZeroDivisor="0000";
    private static String code="000";
    
    private static String xorr(String a,String b){
   String result="";
  
    
    for(int i=0;i<b.length();i++) 
        if(a.charAt(i)==b.charAt(i)) 
            result+="0"; 
        else 
            result+="1"; 
    result=result.substring(1, result.length());
    return result; 
    }
    
    private static String mod2Div(String divident,String divisor){
    int pick = divisor.length();
  
    String tmp = divident.substring(0, pick);
  
    while(pick < divident.length()){
        if(tmp.charAt(0)=='1')
            tmp = xorr(divisor, tmp) + divident.charAt(pick);
  
        else
            tmp = xorr(allZeroDivisor, tmp) + divident.charAt(pick); 
  
        pick += 1;
    }
  
    if(tmp.charAt(0)=='1')
            tmp = xorr(divisor, tmp);
  
        else
            tmp = xorr(allZeroDivisor, tmp);
   
    return tmp; 
    }
    
    public static void main(String[] args) {
    String data = "100100";
    String new_data=data+code;
    String rem=mod2Div(new_data,divisor);
    System.out.print(rem);
    }
}

