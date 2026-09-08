package com.hospital.mpi.algorithms;

import org.springframework.stereotype.Service;

@Service
public class MetaphoneSoundexPhoneticEncoder {

    public String encodeSoundex(String name) {
        if (name == null || name.isEmpty()) return "0000";
        String s = name.toUpperCase();
        StringBuilder out = new StringBuilder();
        out.append(s.charAt(0));

        char prev = getSoundexCode(s.charAt(0));
        for (int i = 1; i < s.length() && out.length() < 4; i++) {
            char code = getSoundexCode(s.charAt(i));
            if (code != '0' && code != prev) {
                out.append(code);
                prev = code;
            }
        }
        while (out.length() < 4) out.append('0');
        return out.toString();
    }

    private char getSoundexCode(char c) {
        switch (c) {
            case 'B': case 'F': case 'P': case 'V': return '1';
            case 'C': case 'G': case 'J': case 'K': case 'Q': case 'S': case 'X': case 'Z': return '2';
            case 'D': case 'T': return '3';
            case 'L': return '4';
            case 'M': case 'N': return '5';
            case 'R': return '6';
            default: return '0';
        }
    }
}
