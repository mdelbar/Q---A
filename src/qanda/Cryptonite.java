
package qanda;

/**
 * @author Matthias Delbar
 */
public class Cryptonite {

    private static int rotatingClearTextCrypt = 2;
    private static int cryptDifferenceKey = 2;
    private static int cryptLocationSimpleKey = 2;

    /**
     * Encrypts a given String of text using a simple rotating cleartext algorithm
     * with a predefined key.
     * @param text The text to encrypt
     * @return The encrypted text
     */
    public static String encryptRotatingClearText(String text) {
        char[] encryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            encryptedText[i] = (char) (c + 2*rotatingClearTextCrypt);
        }
        return new String(encryptedText);
    }

    /**
     * Decrypts a given String of text using a simple rotating cleartext algorithm
     * with a predefined key.
     * @param text The text to decrypt
     * @return The decrypted text
     */
    public static String decryptRotatingClearText(String text) {
        char[] decryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            decryptedText[i] = (char) (c - 2*rotatingClearTextCrypt);
        }
        return new String(decryptedText);
    }

    /**
     * Encrypts a given String of text using an algorithm that increases the value
     * of a character by a predefined amount, but only if the value is an even value.
     * @param text The text to encrypt
     * @return The encrypted text
     */
    public static String encryptDifference(String text) {
        char[] encryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            encryptedText[i] = c;
            if(c % 2 == 0)
                encryptedText[i] += 2*cryptDifferenceKey;
        }
        return new String(encryptedText);
    }

    /**
     * Decrypts a given String of text using an algorithm that decreases the value
     * of a character by a predefined amount, but only if the value is an even value.
     * @param text The text to decrypt
     * @return The decrypted text
     */
    public static String decryptDifference(String text) {
        char[] decryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            decryptedText[i] = c;
            if(c % 2 == 0)
                decryptedText[i] -= 2*cryptDifferenceKey;
        }
        return new String(decryptedText);
    }

    /**
     * Encrypts a given String of text using a simple algorithm that increases the
     * value of a character by a predefined amount depending on its location in the
     * string. If it's at an even place in the string, the value is increased.
     * @param text The text to encrypt
     * @return The encrypted text
     */
    public static String encryptLocationSimple(String text) {
        char[] encryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            encryptedText[i] = text.charAt(i);
            if(i % 2 == 0)
                encryptedText[i] += 2*cryptLocationSimpleKey;
        }
        return new String(encryptedText);
    }

    /**
     * Decrypts a given String of text using a simple algorithm that decreases the
     * value of a character by a predefined amount depending on its location in the
     * string. If it's at an even place in the string, the value is decreased.
     * @param text The text to decrypt
     * @return The decrypted text
     */
    public static String decryptLocationSimple(String text) {
        char[] decryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            decryptedText[i] = text.charAt(i);
            if(i % 2 == 0)
                decryptedText[i] -= 2*cryptLocationSimpleKey;
        }
        return new String(decryptedText);
    }

    /**
     * Encrypts a given String of text using a relatively simple algorithm.
     * The value of a character is always increased by its location in the string.
     * @param text The text to encrypt
     * @return The encrypted text
     */
    public static String encryptLocationHard(String text) {
        char[] encryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            encryptedText[i] = text.charAt(i);
            encryptedText[i] += 2*i;
        }
        return new String(encryptedText);
    }

    /**
     * Decrypts a given String of text using a relatively simple algorithm.
     * The value of a character is always decreased by its location in the string.
     * @param text The text to decrypt
     * @return The decrypted text
     */
    public static String decryptLocationHard(String text) {
        char[] decryptedText = new char[text.length()];
        for(int i = 0; i < text.length(); i++) {
            decryptedText[i] = text.charAt(i);
            decryptedText[i] -= 2*i;
        }
        return new String(decryptedText);
    }


    /**
     * Encrypts a given String of text using all encryption algorithms.
     * The algorithms are executed in succession on the rapidly mutating string
     * This makes the encryption increasingly harder to break as more algorithms are found.
     * @param text The text to encrypt
     * @return The encrypted text
     */
    public static String encryptUsingAll(String text) {
        return
                encryptLocationHard(
                    encryptLocationSimple(
                        encryptDifference(
                            encryptRotatingClearText(text)
                        )
                    )
                );
    }

    /**
     * Decrypts a given String of text using all encryption algorithms.
     * The algorithms are executed in succession on the rapidly mutating string
     * This makes the encryption increasingly harder to break as more algorithms are found.
     * @param text The text to decrypt
     * @return The decrypted text
     */
    public static String decryptUsingAll(String text) {
        return
                decryptLocationHard(
                    decryptLocationSimple(
                        decryptDifference(
                            decryptRotatingClearText(text)
                        )
                    )
                );
    }
}
