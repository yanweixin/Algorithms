package lang;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoTest {
    private final static Logger logger = LoggerFactory.getLogger(DemoTest.class);
    public Integer[] a = new Integer[1024];

    @Test
    public void test() {

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/demo.csv", numLinesToSkip = 1)
    public void csvTest(int rank, String country, long population, float percentage, int gdp) {
        logger.info("{},{},{},{},{}", rank, country, population, percentage, gdp);
    }

}
