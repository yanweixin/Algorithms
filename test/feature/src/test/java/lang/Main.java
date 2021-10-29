package lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int diff = 'a' - 'A';
        int[] chars = new int[128];
        for (int i = 0; i < input.length(); i++) {
            chars[input.charAt(i)]++;
        }

        List<StringBuilder> list = new ArrayList<>();
        while (check(chars, diff)) {
            StringBuilder stringBuilder = new StringBuilder();
            list.add(stringBuilder);
            char prev = 0;
            for (char i = 'A'; i <= 'Z'; i++) {
                if ((prev == 0 || (prev + 1) == i) && chars[i] > 0 && chars[i + diff] > 0) {
                    stringBuilder.append(i);
                    stringBuilder.append((char) (i + diff));
                    chars[i]--;
                    chars[i + diff]--;
                    prev = i;
                }
            }
        }

        boolean found = false;
        for (StringBuilder stringBuilder : list) {
            if (stringBuilder.toString().length() > 0) {
                System.out.println(stringBuilder);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

    public static boolean check(int[] chars, int diff) {
        for (char i = 'A'; i <= 'Z'; i++) {
            if (chars[i] > 0 && chars[i + diff] > 0) {
                return true;
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        List<int[]> list = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        int max = m * m;
//        for (int i = n; i < m - 1; i++) {
//            for (int j = i + 1; j < m; j++) {
//                if (gcd(i, j) != 1) {
//                    continue;
//                }
//                int sum = i * i + j * j;
//                if (sum > max) {
//                    break;
//                }
//                int k = (int) Math.sqrt(sum);
//                if (k * k == sum && gcd(i, k) == 1) {
//                    list.add(new int[]{i, j, k});
//                }
//            }
//        }
//
//        if (list.size() == 0) {
//            System.out.println("NA");
//        } else {
//            for (int[] arr : list) {
//                System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
//            }
//        }
//    }
//
//    private static int gcd(int a, int b) {
//        if (b == 0) {
//            return a;
//        }
//        if (a > b) {
//            return gcd(b, a - b);
//        } else {
//            return gcd(a, b - a);
//        }
//    }


}
