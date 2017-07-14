
package mycryptography;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * @author Gaurav
 */
class CrypOperations {
    int[] key = new int[24];
    int[][] matrix1 = new int[32][32];
    int[][] matrix2 = new int[32][32];
    int[][] matrix3 = new int[32][32];
    int[][] matrix4 = new int[32][32];
    int[][] matrix5 = new int[32][32];
    int[][] matrix6 = new int[32][32];
    int[][] matrix7 = new int[32][32];int[][] matrix8 = new int[32][32];int[][] matrix9 = new int[32][32];
    int[][] matrix10 = new int[32][32];
    int key2;
    ArrayList<String> message = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    Permutations per = new Permutations();
    Matrices mat = new Matrices();
    int SUM=0;
    String sumBinary;
    
    
    // -------------- Creating table ---------------
    
    // In genral, matrix will be filled with random uniques number from 0 to 1000. But in this case it is simply filled with linear values.
      
    public void create_matrix() throws IOException, ClassNotFoundException{
        //mat.createMatrix();
    matrix1 = mat.read_matrices();
    matrix2 = mat.read_matrices1();
    matrix3 = mat.read_matrices2();
    matrix4 = mat.read_matrices3();
    matrix5 = mat.read_matrices4();
    matrix6 = mat.read_matrices5();
    matrix7 = mat.read_matrices6();
    matrix8 = mat.read_matrices7();
    matrix9 = mat.read_matrices8();
    matrix10 = mat.read_matrices9();
    }
    
    // -------------- sum of permutaions of user's number -------------
    public void setSUM(int[] l){
     SUM = per.sumofallnum(l, 5);
     //System.out.println(SUM);
     sumBinary = binary(SUM);
     //System.out.println(sumBinary);
    }
    // -------------- sum binary ----------------------
   
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
       public String lookUpTool(String s){
   
       String s1 = lookUp(s,matrix1);
       String s2 = lookUp(s1,matrix2);
       String s3 = lookUp(s2,matrix3);
       String s4 = lookUp(s3,matrix4);
       String s5 = lookUp(s4,matrix5);
       String s6 = lookUp(s5,matrix6);
       String s7 = lookUp(s6,matrix7);
       String s8 = lookUp(s7,matrix8);
       String s9 = lookUp(s8,matrix9);
       String s10 = lookUp(s9,matrix10);
       
       return s10;
   }
   public String lookUp(String bits, int[][] mat){
    
    int mid = Math.round((float) bits.length() / 2);
    String part1 = bits.substring(0, mid);
    String part2 = bits.substring(mid, bits.length());
    int row=binaryValue(part1);
    int col=binaryValue(part2);;
    
   
    //System.out.print("row: "+row);
   // System.out.println("|| col: "+col);
    int a = mat[row][col];
    return binary(a);
    
    }
    
   
   // ---------------------- get value tool ----------------------------------
   public String getValueTool(int v){
   int a = binaryValue(getValue(v,matrix10));
   int a2 = binaryValue(getValue(a,matrix9));
   int a3 = binaryValue(getValue(a2,matrix8));
   int a4 = binaryValue(getValue(a3,matrix7));
   int a5 = binaryValue(getValue(a4,matrix6));
   int a6 = binaryValue(getValue(a5,matrix5));
   int a7 = binaryValue(getValue(a6,matrix4));
   int a8 = binaryValue(getValue(a7,matrix3));
   int a9 = binaryValue(getValue(a8,matrix2));
   return getValue(a9,matrix1);
   }
    
    public String getValue(int v,int[][] m){
    int x=0,y=0,flag=0;
    
    for(int i=0;i<32;i++){
     for(int j=0;j<32;j++){
      if(m[i][j]==v){
        x=i;
        y=j;
        flag=1;
        break;
      }
     }
     if(flag==1)
         break;
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
      
     if(flag>23)
         flag=0;
     int b=a+key[flag];
     flag++;
     //System.out.print(b+" | ");
     String z = binary(b);
     sb.append(lookUpTool(z));
     //Character.toString((char)b);
     }
     //sb.append(sumBinary);
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
         String z2 = getValueTool(a);
         int b=binaryValue(z2);
         if(flag>23)  // java.lang.ArrayIndexOutOfBoundsException: 24
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
