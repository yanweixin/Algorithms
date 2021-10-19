package leetcode.string;

import java.util.Map;

/**
 * Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 * <p>
 * <p>
 * Integer to Roman
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: num = 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: num = 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 3999
 */
public class RomanAndInteger {
    public int romanToInt(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) {
            throw new IllegalArgumentException("input cannot be null");
        }
        Map<Character, Integer> romanIntMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                'C', 100, 'D', 500, 'M', 1000);
        int res = romanIntMap.get(s.charAt(n - 1));
        for (int i = 0; i < n - 1; i++) {
            char pre = s.charAt(i);
            char suf = s.charAt(i + 1);
            if (romanIntMap.get(pre) < romanIntMap.get(suf)) {
                res -= romanIntMap.get(pre);
            } else {
                res += romanIntMap.get(pre);
            }
        }
        return res;
    }

    public String intToRoman(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("integer out of range");
        }
        StringBuilder result = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }

}
