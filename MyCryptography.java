package mycryptography;

import java.io.IOException;
import java.util.Scanner;

/*
 * @author Gaurav
 */
public class MyCryptography {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       CrypOperations com = new CrypOperations();
       Scanner scan = new Scanner(System.in);
       char[] key = new char[24];
       System.out.println("Cryptography by Gaurav Dangi\n");
       com.create_matrix();
        System.out.print("Do you have a key? (Press 1 for YES and 0 for NO)");
        int k = scan.nextInt();
        if(k==1){
         System.out.print("Enter key! (Should be 24 digits long and separate each digits by space)\n");
         char[] kk = new char[24];
         kk = scan.next().toCharArray();
         
         
         if(com.isValid(kk)==false){
         System.out.println("Wrong format or length");
         System.exit(0);
         }
         com.setKey(kk);
        }
        else{
        key = com.generateKey();
               System.out.print("Your Key: ");
               for(int i=0;i<24;i++){
               System.out.print(key[i]+" ");}
        }
        /*
         System.out.print("\nEnter any 5 random digits\n");
         int[] num = new int[5];
         for(int i=0;i<5;i++){
          num[i] = scan.nextInt();
         }
         com.setSUM(num);
*/
        //System.out.println("Enter your number between (1-100)");
        //com.setKey2(scan.nextInt());
       System.out.print("\nEnter operation\n1]Encryption\n2]Decryption\n-> ");
       int ch = scan.nextInt();
       scan.nextLine();
       switch(ch){
           case 1:
               System.out.println("\nEncryption\nEnter your message (Please avoid enters)");
               String text = scan.nextLine();
               com.Encryption(text);
               com.printMessage2();
               break;
           case 2:
               StringBuffer text2 = new StringBuffer();
               System.out.println("\nDecryption\nEnter message");
               text2.append(scan.nextLine());
               com.Decryption(text2);
               com.printMessage2();
               break;
           default:
               break;
       }
    }
    
}
