package com.interview.patternsearch;
// JAVA program for implementation of KMP pattern
// searching algorithm

class TestKMP {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = new int[M];
        int j = 0; // index for pat[]
        computeLPSArray(pat, M, lps);
    }

    void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        //String pat = "ABABCABAB";

        String pat = "AABCDAAAB";
        new TestKMP().KMPSearch(pat, txt);
    }
}
