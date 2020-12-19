package leetcode.string;

//Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
//
//        (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
//
//        Example 1:
//        Input: N = 10
//        Output: 9
//        Example 2:
//        Input: N = 1234
//        Output: 1234
//        Example 3:
//        Input: N = 332
//        Output: 299
//        Note: N is an integer in the range [0, 10^9].

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        final char[] digits = String.valueOf(N).toCharArray();
        final int length = digits.length;
        int idx = 0;
        for (int i = 0; i < length - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                idx = i + 1;
                continue;
            }
            if (digits[i] > digits[i + 1]) {
                digits[idx]--;
                for (int j = idx + 1; j < length; j++) {
                    digits[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(String.valueOf(digits));
    }
}
