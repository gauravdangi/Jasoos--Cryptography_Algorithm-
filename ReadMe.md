# Jasoos (Cryptography Algorithm)

I am working on encrypting and decrypt web application. I have built an algorithm that uses a 24 bits long key to encrypt/decrypt the message. So I am challenging you to decrypt the message given at the end (Using same simple matrix given in code). Review this algorithm and please suggest anything important and fault in this algorithm that can make it perform better. Your contribution can help us to improve our algorithm. 

Algorithm:

1] 24 digit entered/generated key will be converted into ASCII code of 24 digit code.

    public void setKey(char[] arr){
        int j=0;
     for(int i=0;i<24;i++){
       key[j] = (int)arr[i];
       j++;
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
       if(flag>24)
         flag=0;
     int b=a+key[flag];  // Incrementing value
     flag++;
     String z = binary(b);  // changed into 10-bit binary code
     sb.append(lookUp(z));
          }
    }

3] looUp():- It will take 10 bit string as input and divide that string into two 5 bit binary code.

We will then calculate decimal value of each 5-bit binary code.

**Example**: 0011101101 -> 00111 = 7 and 01101 = 13

We have a matrix of 32 X 32 dimensions which unique random values from 1 to 1000 and will not be shared publicly. 

For 0011101101 we will look for 7th row and 13th column value.
That value will be changed into 10 bits binary code.

    public String lookUp(String bits){
      int mid = Math.round((float) bits.length() / 2);
      String part1 = bits.substring(0, mid);
      String part2 = bits.substring(mid, bits.length());
      int row=binaryValue(part1);
      int col=binaryValue(part2);
      int a = matrix[row][col];
      return binary(a);
  }

Similarly, we will do this for each character in the text/string and encrypt it.
--------------------------------------------------------------------------
**Examples are provided below**:-

     **Key**: c|H@yLzd3PkRte0H,u16zt8N

**Message**: abcd ef$

**After Encryption**: 110001011111010011111100111001110100000111101100101100010110110010101011011011111100110101110011110011011000001110101101110110111011011110001110010100110111001111011100101110010100

-------------------------------------------------------------------------------
**Problem**

**Decode this**: 110101101111001000001100100101110011110111011110011100010110110001110011011001011101001000110110100111100000111110010110111100110111110011011111001111111100111111100101011101001101
