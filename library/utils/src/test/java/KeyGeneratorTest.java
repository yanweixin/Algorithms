import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class KeyGeneratorTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(KeyGeneratorTest.class);
    private final KeyGenerator classUnderTest = new KeyGenerator();

    @Test
    void uniqueKey() {
        for (int i = 0; i < 10; i++) {
            System.out.println(classUnderTest.uniqueKey());
        }
    }
}