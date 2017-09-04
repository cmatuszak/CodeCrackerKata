import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to crack any message using the given decryption key
 */
public class CodeCracker {
    private List<String> key;
    private List<String> alphabet;

    /**
     * Constructs a new CodeCracker with the given decryption/encryption key
     * @param key the decryption/encryption key
     *            each character in the key (separated by a space) corresponds
     *            to a letter in the alphabet starting with a and continuing in order
     */
    public CodeCracker(String key) {
        this.key = Arrays.asList(key.split(" "));
        this.alphabet = Arrays.asList(new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z"});
    }

    /**
     * Decrypts the given message using this CodeCracker's key
     * @param message the message to decrypt
     * @return the decrypted message
     */
    public String decrypt(String message) {
        String answer = "";
        for (int i = 0; i < message.length(); i++) {
            if (key.indexOf(message.substring(i, i + 1)) != -1) {
                answer += alphabet.get(key.indexOf(message.substring(i, i + 1)));
            } else {
                throw new IllegalArgumentException("Message contains a character not in the key");
            }
        }
        return answer;
    }

    /**
     * Encrypts the given message using this CodeCracker's key
     * @param message the message to encrypt
     * @return the encrypted message
     */
    public String encrypt(String message) {
        if (message.length() > 0) {
            return key.get(alphabet.indexOf(message.substring(0, 1)));
        } else {
            return "";
        }
    }
}
