import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the code cracker class
 */
public class CodeCrackerTest {

    @Test
    public void testEmptyMessage() {
        Assert.assertEquals("", new CodeCracker("").decrypt(""));
    }

    @Test
    public void testDecryptionKeySame() {
        Assert.assertEquals("a", new CodeCracker("a").decrypt("a"));
    }

    @Test
    public void testDecryptionKeyOneOverSingleLetter() {
        Assert.assertEquals("a", new CodeCracker("b").decrypt("b"));
    }

    @Test
    public void testDecryptionKeyOneOverTwoLetters() {
        Assert.assertEquals("ab", new CodeCracker("b c").decrypt("bc"));
    }

    @Test
    public void testDecryptionKeyWholeAlphabet() {
        Assert.assertEquals("caitlin", new CodeCracker("b c d e f g h i j k l m n o p q r s t u " +
                "v w x y z a").decrypt("dbjumjo"));
    }

    @Test
    public void testDecryptionKeyWithSpecialCharacters() {
        Assert.assertEquals("helloworld", new CodeCracker("! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o")
                .decrypt("&£aadldga("));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecryptInvalidCharacter() {
        new CodeCracker("! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o")
                .decrypt("&£aadpdga(");
    }

    @Test
    public void testEncryptEmptyMessage() {
        Assert.assertEquals("", new CodeCracker("").encrypt(""));
    }

    @Test
    public void testEncryptionKeySame() {
        Assert.assertEquals("a", new CodeCracker("a").encrypt("a"));
    }
}
