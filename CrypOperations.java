
package mycryptography;

import java.util.ArrayList;
import java.util.Random;

/*
 * @author Gaurav
 */
class CrypOperations {
    int[] key = new int[24];
    int[][] matrix = new int[32][32];
    int key2;
    ArrayList<String> message = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    
    // -------------- Creating table ---------------
    
    // In genral, matrix will be filled with random uniques number from 0 to 1000. But in this case it is simply filled with linear values.
    public void create_table(){
    int flag=0;
    for(int i=0;i<32;i++){
     for(int j=0;j<32;j++){
      matrix[i][j] = flag;
      flag++;
     }
     
    }
    }
    
    // -------------- convert integer to binary ------------------
    public String binary(int num){
       // String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
       //num+=key2;
        return(String.format("%10s", Integer.toBinaryString(num)).replace(' ', '0'));
    }
    public String binary2(int num){
       // String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
       
        return(String.format("%5s", Integer.toBinaryString(num)).replace(' ', '0'));
    }
    
    // --------- set key2 -----------
    public void setKey2(int a){
    key2 = a;
    }
   
    // ----------- check validity of key ----------
    public boolean isValid(char[] v){
     if(v.length == 24)
         return true;
     else
         return false;
    }
    
    // ---------- 1's complement -------------------
    public StringBuffer comp1(StringBuffer a){
     //char[] a = sb.toString().toCharArray();
     int l = a.length();
     for(int i=0;i<l;i++){
      if(a.charAt(i)=='1')
          a.setCharAt(i, '0');
      else
          a.setCharAt(i, '1');
     }
     return a;
    }
    
    // ---------------- convert binary to integer number ---------------
    public int binaryValue(String value){
    //return Integer.parseInt(value,2);
    //System.out.print(value+" -> "+value.length());
    
    char[] arr = value.toCharArray();
    int sum=0;
    int l=arr.length;
    int k=0;
    for(int i=l-1;i>=0;i--){
     if(arr[i] == '1'){
     sum+=Math.pow(2, k);
    }
     k++;
    }
     //System.out.println("| sum ->"+sum);
     //sum=sum-key2;
    return  sum;
    }
    
    // ------------------ set key -------------------------------
    public void setKey(char[] arr){
        int j=0;
     for(int i=0;i<24;i++){
       key[j] = (int)arr[i];
       j++;
     }
    }
    
    // ------------------ generateKey -------------------------------
    public char[] generateKey(){
        Random r = new Random();
        char[] ans = new char[24];
        int[] arr = new int[24];
        int j=0;
     for(int i=0;i<24;i++){
      arr[i] = r.nextInt(127-33)+33;
    //  if(i>3 &&i<8){
       key[j] = arr[i];
       j++;
    //  }
      ans[i]=Character.toString((char)arr[i]).charAt(0);
     }
     //System.out.println(ans);
     return ans;
    }
    
   //-----------------------------------------------------------------------------------------
   //-----------------------------------------------------------------------------------------
    
    // ------------ Lookup for value in table ---------------
     public String lookUp(String bits){
    
    int mid = Math.round((float) bits.length() / 2);
    String part1 = bits.substring(0, mid);
    String part2 = bits.substring(mid, bits.length());
    int row=binaryValue(part1);
    int col=binaryValue(part2);;
    
    int a = matrix[row][col];
    return binary(a);
    }
    
    public String getValue(int v){
    int x=0,y=0;
    for(int i=0;i<32;i++){
     for(int j=0;j<32;j++){
      if(matrix[i][j]==v){
        x=i;
        y=j;
      }
     }
    }
    String a = binary2(x);
    String b = binary2(y);
    return a+b;
    }
    
    
   //-----------------------------------------------------------------------------------------
   //-----------------------------------------------------------------------------------------
  
     // ------------------ Encryption -------------------------------
    public void Encryption(String text){
     char[] msg = text.toCharArray();
     int flag = 0;
     int l = msg.length;
     for(int i=0;i<l;i++){
      int a = (int)msg[i];
     // System.out.print(msg[i]+" "+a+"-> ");
      
     if(flag>24)
         flag=0;
     int b=a+key[flag];
     flag++;
     //System.out.print(b+" | ");
     String z = binary(b);
     sb.append(lookUp(z));
     //Character.toString((char)b);
     }
     sb = comp1(sb);
    }
    
    // ------------------ Decryption -------------------------------
    public void Decryption(StringBuffer text){
        comp1(text);
     char[] arr = text.toString().toCharArray();
           
     //System.out.println("Length->"+text.length());
     String bit="";
     int start=0,end=0,length=10;
     int l=arr.length;
     int flag=0;
     while(end<=l){
         if(end<(start+length)){
             if(end>=l)
                 break;
             bit+=arr[end];
             end++;
             continue;
         }
         start=end;
         
         int a = binaryValue(bit);
         String z2 = getValue(a);
         int b=binaryValue(z2);
         if(flag>24)
             flag=0;
         b-=key[flag];
         flag++;
         
        sb.append(Character.toString((char)b));
         //flag+=8;
         bit="";
     
     }
    }
    
    public void printMessage2(){
     
     System.out.println("\n"+sb);
    }
}
