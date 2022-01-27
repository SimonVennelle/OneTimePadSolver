package com.test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Simon Vennelle on 15/08/2021
 */

public class OneTimePad
{
    public static void main(String[] args)
    {
        String plainText = "010001010100111001000011010100100101100101010000010101000100010101000100";
        String key =       "001111001001011000111100100101100011110010010110001111001001011000111100";
        String encrypted = "";

        for(int i=0; i<key.length(); i++)
        {
            if(plainText.charAt(i) == key.charAt(i))
            {
                encrypted = encrypted + "0";
            }
            else
            {
                encrypted = encrypted + "1";
            }
        }


        System.out.println(encrypted);

        //Decode
        String decoded = "";
        for(int i=0; i<key.length(); i++)
        {
            if(encrypted.charAt(i) == key.charAt(i))
            {
                decoded = decoded + "0";
            }
            else
            {
                decoded = decoded + "1";
            }
        }

        System.out.println(decoded);
        System.out.println();

        //Turn Binary to String
        //Splits Decoded binary into chunks of eight for each letter of binary
        String[] brokenDecoded = decoded.split("(?<=\\G........)");

        String message = "";
        for(int i =0; i< brokenDecoded.length; i++)
        {
            //System.out.println(brokenDecoded[i]);
            //Converts the binary string to an integer
            int charCode = Integer.parseInt(brokenDecoded[i], 2);

            //Uses char to convert the integer into an individual letter
            String letters = new Character((char)charCode).toString();
            //System.out.println(letters);

            message+= letters;
        }

        System.out.println(message);
    }
}
