# Jasoos (Cryptography Algorithm)

I am working on encrypting and decrypt web application. I have built an algorithm that uses a 24 bits long key to encrypt/decrypt the message. So I am challenging you to decrypt the message given at the end (Using same simple matrix given in code). Review this algorithm and please suggest anything important and fault in this algorithm that can make it perform better. Your contribution can help us to improve our algorithm. 

Algorithm:

1] 24 digit entered/generated key will be converted into ASCII code of 24 digit code.

    public void setKey(char[] arr){
     for(int i=0;i<24;i++){
       key[i] = (int)arr[i];
     } 
    }

2] Entered String will be changed into a character array.

Every character will be then incremented first with the key’s value and changed into 8-bit binary code.

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

3] looUp():- It will take 10 bit string as input and a matrix, and divide that string into two 5 bit binary code.

We will then calculate decimal value of each 5-bit binary code.

**Example**: 0011101101 -> 00111 = 7 and 01101 = 13

We have a matrix of 32 X 32 dimensions which unique random values from 1 to 1000 and will not be shared publicly. 

For 0011101101 we will look for 7th row and 13th column value.
That value will be changed into 10 bits binary code.

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

We will perform this steps ten times with ten different private matrices.

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

Similarly, we will do this for each character in the text/string and encrypt it.
--------------------------------------------------------------------------
**Examples are provided below:-

 **Key**: c|H@yLzd3PkRte0H,u16zt8N

**Message**: abcd ef$

**After Encryption**: 11001111000001101010000010000101101000001110100000101010111001110000011000001000

-------------------------------------------------------------------------------
**Problem

**Decode this** (Message below is encoded using different key): 111000000101110010111001010011100010001100001011111010101110001000000111101010011000100011110100110100011101001110101111111110000011101011001110101101101011000011101000000010001010
