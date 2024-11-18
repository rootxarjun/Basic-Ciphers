// Importing Scanner Package..
import java.util.Scanner;

// Ceaser Class..
public class ceaser {

    // Entery point to the Main Function..
public static void main(String[] args) {
    Scanner userinput = new Scanner(System.in);
    
    // Menu..
    while(true){
        System.out.println("\n 1. Encryption \n 2. Decryption \n 3. Brute-Force \n 4. Exit ");
        System.out.print("Enter the Task to be Performed: ");
        
        // Selecting User's Choice..
        int choice = userinput.nextInt();
        userinput.nextLine();
        switch (choice) {

            // This case is for Encryption..
            case 1:
                System.out.print("Enter Plain Text: ");
                String plaintext = userinput.nextLine();
                System.out.print("Enter Encryption Key: ");
                int encrypt_key = userinput.nextInt(); 
                String encrypted = encrypt(plaintext, encrypt_key);
                System.out.print("Encrypted Text is: "+encrypted + "\n");
                break;

            // This case is for Decryption..
            case 2:
                System.out.print("Enter Cipher Text: ");
                String cipher_text = userinput.nextLine();
                System.out.print("Enter Cipher Key: ");
                int cipher_key = userinput.nextInt();
                String decrypted = decrypt(cipher_text, cipher_key);
                System.out.print("Decrypted Text: "+decrypted + "\n");
                break;
            
            // This case if for Brute-Forcing..
            case 3:
                System.out.print("Enter Plain Text:");
                String plain_text = userinput.nextLine();
                System.out.print("Enter Cipher Text: ");
                String cipher_Text = userinput.nextLine();
                int expected_key = 0;
                for (int i = 0 ; i < 26 ; i++){
                    expected_key = brute_force(plain_text, cipher_Text, i);
                    if (expected_key != -1) {
                        System.out.println("Key : " + expected_key);
                    }
                }
                if(expected_key == -1){
                    System.out.print("Key Not Found.");
                }
                break;

                // This case is for Exiting Our prompt..
                case 4:
                System.out.print("ThankYou For using Ceaser Cipher. \nExiting....");
                System.exit(0);
            break;
            
            // Default to this prompt if user tries to enter Numeric options other than provided.. 
            default:
            System.out.print("Invalide option. Try agian.. ");
                break;
        }
        userinput.close();
    }
}


// This function is for encryption..
public static String encrypt(String plaintext, int key){
    StringBuilder ciphertext = new StringBuilder();
    for (int i=0; i<plaintext.length(); i++){
        char ch = plaintext.charAt(i);


        // Check for the case of the character.. 
        if(Character.isUpperCase(ch)){
            char c1 = (char) ((ch+key-'A')%26+'A');
            ciphertext.append(c1);
        }
        else if (Character.isLowerCase(ch)){
            char c1 = (char) ((ch+key - 'a')%26+'a');
            ciphertext.append(c1);
        }
        else{
            ciphertext.append(ch);
        }

    }
    return ciphertext.toString();
}


// This Function is for Decryption.. 
public static String decrypt(String cipher_text, int cipher_key) {
    StringBuilder decryptedText = new StringBuilder();
    for (int i = 0; i < cipher_text.length(); i++) {
      char ch = cipher_text.charAt(i);


      // Check for the case of the character..   
      if (Character.isUpperCase(ch)) {
        char c1 = (char) ((ch - cipher_key - 'A' + 26) % 26 + 'A');
        decryptedText.append(c1);
      } else if (Character.isLowerCase(ch)) {
        char c1 = (char) ((ch - cipher_key - 'a' + 26) % 26 + 'a');
        decryptedText.append(c1);
      } else {
        decryptedText.append(ch);
      }
    }
    return decryptedText.toString();
}


// This function is for Brute-Forcing..
public static int brute_force(String plain_text, String cipher_Text, int key) {
    String keyCipherText = encrypt(plain_text, key);


    // Checking whether Give Cipher and generated Cipher are equal or not..
    if (keyCipherText.equals(cipher_Text)) {
        return key;
    }
    return -1;
}
}