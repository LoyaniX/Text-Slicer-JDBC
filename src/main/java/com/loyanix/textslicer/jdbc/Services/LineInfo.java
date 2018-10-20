package com.loyanix.textslicer.jdbc.Services;

import java.util.Arrays;

public class LineInfo {

    private String longestWord;
    private int lengthOfLongestWord;
    private String shortestWord;
    private int lengthOfShortestWord;
    private int avgLengthWord;
    private int lengthLine;

    public LineInfo(String line){

        String[] wordsInLine = line.split(" ");
        longestWord = findLongestWord(wordsInLine);
        lengthOfLongestWord = longestWord.length();
        shortestWord = findShortestWord(wordsInLine);
        lengthOfShortestWord = shortestWord.length();
        avgLengthWord = (lengthOfLongestWord + lengthOfShortestWord)/2;
        lengthLine = line.length();
    }
    private static String findLongestWord(String[] wordsInLine){
        String[] words = sortOfWordLength(wordsInLine);
        return words[words.length-1];
    }

    private static String findShortestWord(String[] wordsInLine){
        String[] words = sortOfWordLength(wordsInLine);
        return words[0];
    }

    private static String[] sortOfWordLength ( String[] wordsInLine){
        Arrays.asList(wordsInLine).sort((first, second) -> Integer.compare(first.length(), second.length()));
        return wordsInLine;
    }

    public String getLongestWord() { return longestWord; }

    public int getLengthOfLongestWord() { return lengthOfLongestWord; }

    public String getShortestWord() { return shortestWord; }

    public int getLengthOfShortestWord() { return lengthOfShortestWord; }

    public int getAvgLengthWord() { return avgLengthWord; }

    public int getLengthLine() { return lengthLine; }

    @Override
    public String toString() {
        return "LineInfo{" +
                "longestWord='" + longestWord + '\'' +
                ", lengthOfLongestWord=" + lengthOfLongestWord +
                ", shortestWord='" + shortestWord + '\'' +
                ", lengthOfShortestWord=" + lengthOfShortestWord +
                ", avgLengthWord=" + avgLengthWord +
                ", lengthLine=" + lengthLine +
                '}';
    }
}
