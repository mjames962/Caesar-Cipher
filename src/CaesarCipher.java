public class CaesarCipher {
    /**
     * caesar cipher on a character, shifts the character across the alphabet by the key.
     *
     * @param plaintext the plaintext character to be encrypted
     * @param key the value the character will be shifted by e.g key = 3 then A becomes D
     * @throws IllegalArgumentException when input isn't A-Z
     * @return Ciphertext
     **/
    public static char caesarCipher(char plaintext, int key) throws IllegalArgumentException{
        //checks to see if character input is valid e.g capital letter A-Z
        if (!(65 <= plaintext && plaintext <= 90)) {
            throw new IllegalArgumentException("Input is not capital letter");
        }

        //check to see if result is in range
        if (plaintext + key <= 90) {
            return (char) (plaintext + key);
        } else { //wrap the character back around
            return (char) (plaintext + key - 26);
        }

    }

    /**
     * caesar cipher on strings, shifts each character across the alphabet by the key.
     * Characters that aren't A-Z are converted into space characters
     *
     * @param plaintext input plaintext
     * @param key the value the character will be shifted by e.g key = 3 then A becomes D
     * @return Ciphertext
     **/
    public static String caesarCipher(String plaintext, int key) {
        String cipherText = "";

        //stepping through each character in string
        for (int i = 0; i < plaintext.length(); i++) {
            try {
                cipherText = cipherText + caesarCipher(plaintext.charAt(i), key);
            } catch (IllegalArgumentException e) { //anything not a capital letter
                cipherText = cipherText + " ";
            }
        }

        return cipherText;
    }
}
