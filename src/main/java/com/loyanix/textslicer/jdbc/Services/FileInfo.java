package com.loyanix.textslicer.jdbc.Services;

import java.util.ArrayList;
import java.util.List;

public class FileInfo {


    private String longestWord;
    private int lengthOfLongestWord;
    private String shortestWord;
    private int lengthOfShortestWord;
    private int avgLengthWord;
    private int avgLengthLine;
    private List<LineInfo> lineInfos = new ArrayList<>();

    public FileInfo(List<String> linesList) {

        for(String line : linesList) lineInfos.add(new LineInfo(line));
        longestWord = findLongestWord(lineInfos);
        lengthOfLongestWord = longestWord.length();
        shortestWord = findShortestWord(lineInfos);
        lengthOfShortestWord = shortestWord.length();
        avgLengthWord = findAvgLengthWord(lineInfos);
        avgLengthLine = findAvgLengthLine(lineInfos);

    }

    private static String findLongestWord(List<LineInfo> lineInfos){

        return null;
    }

    private static String findShortestWord(List<LineInfo> lineInfos){

        return null;
    }

    private static int findAvgLengthWord(List<LineInfo> lineInfos){

        return 0;
    }

    private static int findAvgLengthLine(List<LineInfo> lineInfos){

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

    public List<LineInfo> getLineInfos() {
        return lineInfos;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
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
