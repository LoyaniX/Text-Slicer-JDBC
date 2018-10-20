package com.loyanix.textslicer.jdbc;

import com.loyanix.textslicer.jdbc.Services.FileInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<List> filesList = new ArrayList<>();
    private static List<FileInfo> fileInfoList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Hello, please enter path to the directory with file(s) : ");
        String pathToDirectory = in.nextLine();
        File directory = new File(pathToDirectory);
        getListOfFiles(directory);
        for (List<String> listFiles : filesList) fileInfoList.add(new FileInfo(listFiles));
        for(FileInfo out :fileInfoList){
            System.out.println(out.toString());
        }
    }

    private static void getListOfFiles(File file){
        for(File currentFile:file.listFiles()){
            if(currentFile.isDirectory()){
              getListOfFiles(currentFile);
            } else {
                List<String> listOfLines = new ArrayList<>();
                try (BufferedReader input = new BufferedReader(new FileReader(currentFile))){
                    String line;
                    while ((line = input.readLine()) != null) listOfLines.add(line);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                filesList.add(listOfLines);
            }
        }

    }
}
