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
}
