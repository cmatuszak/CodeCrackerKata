import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the code cracker class
 */
public class CodeCrackerTest {

    @Test
    public void testEmptyMessage() {
        Assert.assertEquals("", new CodeCracker().decrypt(""));
    }
}
