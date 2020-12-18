package lang;

import java.util.Date;
import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalDemo {

    public void test() {
        int i = 9;
        if (IntStream.range('0', '9').noneMatch((num) -> num == i)){
            System.out.println(12);
        }
    }
}
