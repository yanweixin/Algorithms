package leetcode.string;

//Given a string s, remove duplicate letters so that every letter appears once and only once.
//You must make sure your result is the smallest in lexicographical order among all possible results.
//
//        Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//
//        Example 1:
//
//        Input: s = "bcabc"
//        Output: "abc"
//        Example 2:
//
//        Input: s = "cbacdcbc"
//        Output: "acdb"
//
//
//        Constraints:
//
//        1 <= s.length <= 104
//        s consists of lowercase English letters.

import java.util.Stack;

public class RemoveDuplicateLetters {
    /**
     * @param s inputs should only contains lowercase English letters.
     * @return
     */
    public String useStack(String s) {
        int[] res = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] chars = s.toCharArray();
        for (char c : chars) {  //count number of occurences of character
            res[c - 'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;
        for (char c : chars) {
            index = c - 'a';
            res[index]--;   //decrement number of characters remaining in the string to be analysed
            if (visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!st.isEmpty() && c < st.peek() && res[st.peek() - 'a'] != 0) {
                visited[st.pop() - 'a'] = false;
            }
            st.push(c); //add current character and mark it as visited
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    public String useStringBuilder(String s) {
        final int[] res = new int[26];
        final boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && res[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                visited[c - 'a'] = true;
                sb.append(c);
            }
            res[c - 'a']--;
        }
        return sb.toString();
    }
}
