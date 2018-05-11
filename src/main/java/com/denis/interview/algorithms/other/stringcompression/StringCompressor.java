package com.denis.interview.algorithms.other.stringcompression;

public class StringCompressor {

    public String compressString(String src) {

        StringBuilder result = new StringBuilder();
        char[] charArray = src.toCharArray();

        int count = 1;

        for (int i = 0; i < charArray.length - 1; i++) {

            if (charArray[i] == charArray[i + 1]) {
                count++;
            } else {
                result.append(charArray[i]).append(count);
                count = 1;
            }
        }

        result.append(charArray[charArray.length - 1]).append(count);

        if (result.length() <= src.length()) {
            return result.toString();
        }
        return src;
    }


    public static void main(String[] args) {

        StringCompressor compressor = new StringCompressor();

        System.out.println(compressor.compressString("gaacbbbbbdddr"));
        System.out.println(compressor.compressString("gbcd"));

    }
}
