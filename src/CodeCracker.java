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
        return translate(key, alphabet, message);
    }

    /**
     * Encrypts the given message using this CodeCracker's key
     * @param message the message to encrypt
     * @return the encrypted message
     */
    public String encrypt(String message) {
        // encrypting is just the opposite of decrypting, so switch the alphabet and the key
        return translate(alphabet, key, message);
    }

    /**
     * Translate the given message to the given alphabet using the given key
     * @param key the decryption/encryption key to use
     * @param alphabet the alphabet to be converted to
     * @param message the message to translate
     * @return the translated message
     */
    private String translate(List<String> key, List<String> alphabet, String message) {
        String answer = "";
        for (int i = 0; i < message.length(); i++) {
            int index = key.indexOf(message.substring(i, i + 1));
            if (index != -1) {
                answer += alphabet.get(index);
            } else {
                throw new IllegalArgumentException("Message contains a character not in the key");
            }
        }
        return answer;
    }
}
