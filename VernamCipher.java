// VernamCipher Encryption made by journey6 on github
// these code shows each step like if done manually by hand
import java.util.Random;   //random number methods

class VernamCipher{

  public static void main(String[] args)
    
  {

	String s1;
	s1 = "Enjoy the life"; 

    Random rand = new Random(7);
    System.out.println(encrypt(s1, rand));
   
  }
  public static String encrypt(String message, Random r)
  {
	// print each character in the plainText
    System.out.println("Plain-text:\t"+arrToStr(message.toCharArray()));
    int length = message.length(); // text length
    int []pi = new int[length]; // alphabet letter index
	int []ri = new int[length]; // random key to encrypt each letter
	int []sum = new int[length]; // sum used in step for encrypting each letter
	int []cr = new int[length]; // each character index after encryption
	
	char[]cipherT = new char[length]; // array to save each encrypted character
    char c; // character in the text
    StringBuffer cipher =  new StringBuffer(message.length());
    
    for (int i = 0; i < message.length(); i++){
      c = message.charAt(i);  
      if (Character.isLetter(c)) {
    	  ri[i] =  (int) (Math.random() * 26 + 1); // generate random key for encryption
    	  cipher.append( (char) ((Character.toUpperCase(c) - 'A' + ri[i]) % 26 + 'A'));
    	  pi[i] = (char)(Character.toUpperCase(c) - 'A');
    	  sum[i] = ri[i]+pi[i];
    	  cr[i] = sum[i]%26; // Encryption step
    	  cipherT[i] = (char) ((Character.toUpperCase(c) - 'A' + ri[i]) % 26 + 'A');
      }else { // if not letter just append
        cipher.append(c);
        // use -1 to distinguish from letters
        pi[i] = ri[i] = sum[i] = cr[i] = -1; 
        cipherT[i] = c;
      }
      
  }
    System.out.println("\t\t"+arrToStr(pi)); //print
    System.out.println("Random #(ri):\t"+arrToStr(ri));
    System.out.println("Sum = pi+ri:\t"+arrToStr(sum));
    System.out.println("Sum mod 26:\t"+arrToStr(cr));
    System.out.println("Cipher-text:\t"+arrToStr(cipherT));
    return "\t\t"+cipher.toString().toLowerCase();
  }
  
  // convert array of int to String
  public static String arrToStr(int[]a) {
		String str = "";
		for(int i=0; i < a.length; i++) {
			if(a[i] == -1)
				str += " ";
			else
				str += a[i]+" ";
		}
		return str;
	}
  // convert array of char to String
  public static String arrToStr(char[]a) {
		String str = "";
		for(int i=0; i < a.length; i++) {
			if(a[i] == -1)
				str += " ";
			else
				str += a[i]+" ";
		}
		return str.toLowerCase();
	}
  

  
}


