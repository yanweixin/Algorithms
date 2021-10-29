package leetcode.string;

//Convert a non-negative integer num to its English words representation.
//
//
//
//Example 1:
//
//Input: num = 123
//Output: "One Hundred Twenty Three"
//Example 2:
//
//Input: num = 12345
//Output: "Twelve Thousand Three Hundred Forty Five"
//Example 3:
//
//Input: num = 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//Example 4:
//
//Input: num = 1234567891
//Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
//
//
//Constraints:
//
//0 <= num <= 2^31 - 1

public class IntegerToEnglish {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        StringBuilder words = new StringBuilder();

        while (num > 0) {
            int remainder = num % 1000;
            if (remainder != 0) {
                words.insert(0, convertInt(remainder) + THOUSANDS[i] + " ");
            }
            num /= 1000;
            i++;
        }
        return words.toString().trim();
    }

    private String convertInt(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + convertInt(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + convertInt(num % 100);
    }
}
