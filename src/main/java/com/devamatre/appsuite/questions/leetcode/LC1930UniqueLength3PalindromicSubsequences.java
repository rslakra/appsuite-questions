package com.devamatre.appsuite.questions.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description
 * <p>
 * 1930. Unique Length-3 Palindromic Subsequences
 * <p>
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 * <p>
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 * <p>
 * A palindrome is a string that reads the same forwards and backwards.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 *
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 11/13/2023 7:13 PM
 */
public class LC1930UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        System.out.println(s);
        int[] leftIndices = new int[26];
        int[] rightIndices = new int[26];
        int result = 0;
        Arrays.fill(leftIndices, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            System.out.println("i:" + i + ", index:" + index);
            leftIndices[index] = Math.min(leftIndices[index], i);
            rightIndices[index] = i;
        }

        System.out.println(Arrays.toString(leftIndices));
        System.out.println(Arrays.toString(rightIndices));

        for (int i = 0; i < s.length(); i++) {
            if (leftIndices[i] < rightIndices[i]) {
                String str = s.substring(leftIndices[i] + 1, rightIndices[i]);
                System.out.println("str:" + str);
                result += str.chars().distinct().count();
            }
        }

        return result;
    }
}
