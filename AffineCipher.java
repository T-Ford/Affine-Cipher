/**
 * Created by Tyler J Ford
 * for Cryptography course as Rhode Island College
 * The program takes a encrypted string and decrypts it using the Affine Cipher algorithm
 * with the brute force tactic
 */

import java.util.Scanner;
import java.math.*;

public class AffineCipher
{
    public static String ptext = "";
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        String ctxt, ctxt2;
        int inverseA;
        int A = 1;
        int B;
        String cont = "";

        //falszztysyjzyjkywjrztyjztyynaryjkyswarztyegyyj

        System.out.println("Welcome to the Affine Cipher App \n");

        ctxt = "falszztysyjzyjkywjrztyjztyynaryjkyswarztyegyyj";
        ctxt2 = "vwduwljudeehghyhubwklqjlfrxogilqgsohdvhuhwxuqdqbeoxhsulqwviruydxowdqgdodupghvljqedvhgrqzklfkedqnbrxghflghrqldpvhwwlqjxsvdihkrxvhfr";
        do{
            //String ptext;

            for(B = 0; B < 26; B++){
                System.out.println();
                System.out.println("\nDecrypting the cipher text: \n" + ctxt);    
                System.out.println();

                System.out.println("Encryption key: a = " + A + " b = " + B);
                System.out.println("Decryption equation: x = " + modInverse(A) + " *(y - " + B + ") % 26");
                decrypt(ctxt, modInverse(A), B);
                //ptext = ptext + decrypt2(ctxt, modInverse(A), B);
                //System.out.println(ptext);

                System.out.println();
                System.out.println("\nPress the ENTER key to continue search or enter the 's' key to stop: ");
                cont = kbd.nextLine();
                if(cont.equals("s")){
                    break;
                }
            }     

            System.out.println("The final plain text message above was encrypted with a = " + modInverse(A) + " and b = " + B);
            //System.out.println(ptext);
            A=A+2;
            if(A==13){
                A=A+2;
            }
        }while(!cont.equals("s"));        
    }

    //public static int x;

    public static void decrypt(String ctext, int invA, int b)
    {
        int charValue;
        int x;

        String [] pkey = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z"};

        System.out.println();
        System.out.println("Plaintext: "); 
        for(int i = 0; i < ctext.length(); i++){
            charValue = (Character.getNumericValue(ctext.charAt(i))) - 10;
            x = (invA * ((charValue) - b)) % 26;
            if(x < 0){
                x = x + 26;
            }
            System.out.print(pkey[x]);
        }
    }

    public static int modInverse(int a)
    {
        if(a==1){ 
            return 1;} 
        else if(a==3){
            return 9;}
        else if(a==5){
            return 21;} 
        else if(a==7){
            return 15;}
        else if(a==9){
            return 3;}
        else if(a==11){
            return 19;}
        else if(a==15){ 
            return 7;}
        else if(a==17){
            return 23;}
        else if(a==19){
            return 11;} 
        else if(a==21){
            return 5;}
        else if(a==23){
            return 17;} 
        else if(a==25){
            return 25;}  
        return 1;  
    }
}

