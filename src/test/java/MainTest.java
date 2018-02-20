import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTest {

    @Test
    public void GetWelcomeStringTest() {
        assertEquals("Welcome to final project!", Main.GetWelcomeString());
    }
}
