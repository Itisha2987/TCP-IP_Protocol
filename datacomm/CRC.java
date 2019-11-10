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
    
    private static String divisor="11011";
    private static String allZeroDivisor="00000";
    private static String code="0000";
    
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
    
    public static String cRCGenerator(String cmsg,String emsg,boolean isError){
     String res="";
        for(int i=0;i<cmsg.length();i+=16){
         String temp = cmsg.substring(i,Math.min(i+16,cmsg.length()));
         temp=temp+code;
         String rem=mod2Div(temp,divisor);
         for(int j=0;j<code.length();j++){
             temp=temp.substring(0,temp.length()-1);
         }
         temp=temp+rem;
         if(isError){
         String t = emsg.substring(i,Math.min(i+16,emsg.length()));   
         res=res+t;
         }
         else{
         res=res+temp;
         }
        }
        return res;
    }
    
    public static boolean isErrorPresent(String str){
    for(int i=0;i<str.length();i+=20){
     String temp = str.substring(i,Math.min(i+20,str.length()));
     String rem=mod2Div(temp,divisor);
     if(!(rem.equals(code)))
        return true;
    }
    return false;
    }
    
  /*  public static void main(String[] args) {
    String data = "100100";
    String new_data=data+code;
    String rem=mod2Div(new_data,divisor);
    System.out.print(rem);
    }*/
}

