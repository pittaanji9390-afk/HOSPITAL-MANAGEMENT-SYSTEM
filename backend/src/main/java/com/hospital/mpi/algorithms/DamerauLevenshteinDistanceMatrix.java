package com.hospital.mpi.algorithms;

import org.springframework.stereotype.Service;

@Service
public class DamerauLevenshteinDistanceMatrix {

    public int computeDistance(String s1, String s2) {
        if (s1 == null || s2 == null) return 999;
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] d = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) d[i][0] = i;
        for (int j = 0; j <= len2; j++) d[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = Character.toLowerCase(s1.charAt(i - 1)) == Character.toLowerCase(s2.charAt(j - 1)) ? 0 : 1;
                d[i][j] = Math.min(d[i - 1][j] + 1, Math.min(d[i][j - 1] + 1, d[i - 1][j - 1] + cost));
                if (i > 1 && j > 1 && Character.toLowerCase(s1.charAt(i - 1)) == Character.toLowerCase(s2.charAt(j - 2)) && Character.toLowerCase(s1.charAt(i - 2)) == Character.toLowerCase(s2.charAt(j - 1))) {
                    d[i][j] = Math.min(d[i][j], d[i - 2][j - 2] + 1); // Transposition
                }
            }
        }
        return d[len1][len2];
    }
}
