package lang;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DemoTest {
    private final static Logger logger = LoggerFactory.getLogger(DemoTest.class);

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] a = {2, 5, 1, 5, 4, 5};
        System.out.println(getMaxSteps(a, a.length));
    }

    public static int fama(int n, int[] weight, int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <= nums[0]; i++) {
            set.add(weight[0] * i);
        }
        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>(set);
            for (int j = 0; j <= nums[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }

    public int getMaxSteps(int[] arr, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 找到dp数组中的最大值即可
        int max = 0;
        for (int i = 0; i < dp.length; i++)
            if (dp[i] > max) {
                max = dp[i];
            }
        return max;
    }

    public int gcd(int a, int b) {
        // method 1
//        if (b == 0) return a;
//        else return (gcd(b, a % b));

        // method 2
//        while (b > 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;

        // method 3
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcd(b, a - b);
        } else {
            return gcd(a, b - a);
        }
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    double cbrt(double low, double high, double eq) {
        double mid = (low + high) / 2;
        double result = mid * mid * mid;
        if (Math.abs(eq - result) < 1e-3) {
            return mid;
        }
        if (eq > result) {
            return cbrt(mid, high, eq);
        } else {
            return cbrt(low, mid, eq);
        }
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/demo.csv", numLinesToSkip = 1)
    public void csvTest(int rank, String country, long population, float percentage, int gdp) {
        logger.info("{},{},{},{},{}", rank, country, population, percentage, gdp);
    }

}
