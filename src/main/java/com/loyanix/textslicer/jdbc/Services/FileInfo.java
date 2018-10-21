package com.loyanix.textslicer.jdbc.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileInfo {


    private String fileName;
    private String longestWord;
    private int lengthOfLongestWord;
    private String shortestWord;
    private int lengthOfShortestWord;
    private int avgLengthWord;
    private int avgLengthLine;
    private List<LineInfo> lineInfos;

    public FileInfo(List<String> linesList, String fileName) {
        this.fileName = fileName;
        lineInfos = new ArrayList<>();
        for(String line : linesList) lineInfos.add(new LineInfo(line));
        longestWord = findLongestWord(lineInfos);
        lengthOfLongestWord = longestWord.length();
        shortestWord = findShortestWord(lineInfos);
        lengthOfShortestWord = shortestWord.length();
        avgLengthWord = findAvgLengthWord(lineInfos);
        avgLengthLine = findAvgLengthLine(lineInfos);

    }
    public FileInfo(List<LineInfo> linesList, String fileName, String solve) {
        this.fileName = fileName;
        this.lineInfos = new ArrayList<>(linesList);
        longestWord = findLongestWord(lineInfos);
        lengthOfLongestWord = longestWord.length();
        shortestWord = findShortestWord(lineInfos);
        lengthOfShortestWord = shortestWord.length();
        avgLengthWord = findAvgLengthWord(lineInfos);
        avgLengthLine = findAvgLengthLine(lineInfos);

    }

    private static String findLongestWord(List<LineInfo> lineInfos){
        String[] longestWordInEachLine = new String[lineInfos.size()];
        for(int count = 0; count < lineInfos.size(); count++)    longestWordInEachLine[count] = lineInfos.get(count).getLongestWord();
        Arrays.asList(longestWordInEachLine).sort((first, second) -> Integer.compare(first.length(), second.length()));
        return longestWordInEachLine[longestWordInEachLine.length-1];
    }

    private static String findShortestWord(List<LineInfo> lineInfos){
        String[] sortestWordInEachLine = new String[lineInfos.size()];
        for(int count = 0; count < lineInfos.size(); count++)    sortestWordInEachLine[count] = lineInfos.get(count).getLongestWord();
        Arrays.asList(sortestWordInEachLine).sort((first, second) -> Integer.compare(first.length(), second.length()));
        return sortestWordInEachLine[0];
    }

    private static int findAvgLengthWord(List<LineInfo> lineInfos){
        int[] lengthWords = new int[lineInfos.size()];
        for(int count = 0; count < lineInfos.size(); count++)   lengthWords[count] = lineInfos.get(count).getAvgLengthWord();
        Arrays.sort(lengthWords);
        return (lengthWords[0] + lengthWords[lengthWords.length-1])/2;
    }

    private static int findAvgLengthLine(List<LineInfo> lineInfos){
        int[] lengthLine = new int[lineInfos.size()];
        for(int count = 0; count < lineInfos.size(); count++)   lengthLine[count] = lineInfos.get(count).getLengthLine();
        Arrays.sort(lengthLine);
        return (lengthLine[0] + lengthLine[lengthLine.length-1])/2;
    }

    public String getLongestWord() { return longestWord; }

    public int getLengthOfLongestWord() { return lengthOfLongestWord; }

    public String getShortestWord() { return shortestWord; }

    public int getLengthOfShortestWord() { return lengthOfShortestWord; }

    public int getAvgLengthWord() { return avgLengthWord; }

    public int getAvgLengthLine() { return avgLengthLine; }

    public List<LineInfo> getLineInfos() { return lineInfos; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    public void setLengthOfLongestWord(int lengthOfLongestWord) {
        this.lengthOfLongestWord = lengthOfLongestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
    }

    public void setLengthOfShortestWord(int lengthOfShortestWord) {
        this.lengthOfShortestWord = lengthOfShortestWord;
    }

    public void setAvgLengthWord(int avgLengthWord) {
        this.avgLengthWord = avgLengthWord;
    }

    public void setAvgLengthLine(int avgLengthLine) {
        this.avgLengthLine = avgLengthLine;
    }

    public void setLineInfos(List<LineInfo> lineInfos) {
        this.lineInfos = lineInfos;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", longestWord='" + longestWord + '\'' +
                ", lengthOfLongestWord=" + lengthOfLongestWord +
                ", shortestWord='" + shortestWord + '\'' +
                ", lengthOfShortestWord=" + lengthOfShortestWord +
                ", avgLengthWord=" + avgLengthWord +
                ", avgLengthLine=" + avgLengthLine +
                ",\n" +
                "\t\tlineInfos=" + lineInfos +
                "\n" +
                '}';
    }

}
