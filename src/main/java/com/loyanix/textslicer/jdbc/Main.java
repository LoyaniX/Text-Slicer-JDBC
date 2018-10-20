package com.loyanix.textslicer.jdbc;

import com.loyanix.textslicer.jdbc.Services.FileInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<List> list = new ArrayList<>();
    private static List<FileInfo> fileInfoList= new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String pathToDirectory = in.nextLine();
        File directory = new File(pathToDirectory);
        getListOfFiles(directory);
        for (List<String> listFiles : list) fileInfoList.add(new FileInfo(listFiles));
/*
        String[] wordsInLine = {"lol", "asdsa", "dasdasda", "sd"};
        for(String out:wordsInLine){
            System.out.println(out);
        }
        System.out.println(wordsInLine.length);
        System.out.println(wordsInLine[wordsInLine.length-1]);
        System.out.println(" ");
        Arrays.asList(wordsInLine).sort((first, second) -> Integer.compare(first.length(), second.length()));
        System.out.println(wordsInLine.length);
        for(String out:wordsInLine){
            System.out.println(out);
        }*/

    }

    private static void getListOfFiles(File file){


    }
}
