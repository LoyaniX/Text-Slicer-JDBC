package com.loyanix.textslicer.jdbc.Services;

import java.util.ArrayList;
import java.util.List;

public class fileInfo {


    private String longestWord;
    private int lengthOfLongestWord;
    private String shortestWord;
    private int lengthOfShortestWord;
    private int avgLengthWord;
    private int avgLengthLine;
    private List<lineInfo> lineInfos = new ArrayList<>();

    public fileInfo(List<String> linesList) {

        for(String line : linesList) lineInfos.add(new lineInfo(line));
        longestWord = findLongestWord(lineInfos);
        lengthOfLongestWord = longestWord.length();
        shortestWord = findShortestWord(lineInfos);
        lengthOfShortestWord = shortestWord.length();
        avgLengthWord = findAvgLengthWord(lineInfos);
        avgLengthLine = findAvgLengthLine(lineInfos);

    }

    private static String findLongestWord(List<lineInfo> lineInfos){

        return null;
    }

    private static String findShortestWord(List<lineInfo> lineInfos){

        return null;
    }

    private static int findAvgLengthWord(List<lineInfo> lineInfos){

        return 0;
    }

    private static int findAvgLengthLine(List<lineInfo> lineInfos){

        return 0;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public int getLengthOfLongestWord() {
        return lengthOfLongestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public int getLengthOfShortestWord() {
        return lengthOfShortestWord;
    }

    public int getAvgLengthWord() {
        return avgLengthWord;
    }

    public int getAvgLengthLine() {
        return avgLengthLine;
    }

    public List<lineInfo> getLineInfos() {
        return lineInfos;
    }

    @Override
    public String toString() {
        return "fileInfo{" +
                "longestWord='" + longestWord + '\'' +
                ", lengthOfLongestWord=" + lengthOfLongestWord +
                ", shortestWord='" + shortestWord + '\'' +
                ", lengthOfShortestWord=" + lengthOfShortestWord +
                ", avgLengthWord=" + avgLengthWord +
                ", avgLengthLine=" + avgLengthLine +
                ", lineInfos=" + lineInfos +
                '}';
    }
}
