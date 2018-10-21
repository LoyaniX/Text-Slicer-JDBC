package com.loyanix.textslicer.jdbc;

import com.loyanix.textslicer.jdbc.DAO.Table;
import com.loyanix.textslicer.jdbc.Services.FileInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<List> filesList = new ArrayList<>();
    private static List<String> filesName = new ArrayList<>();
    private static List<FileInfo> fileInfoList = new ArrayList<>();

    private static List<FileInfo> fileInfoListRead = null;


    public static void main(String[] args) throws SQLException {

        Scanner in = new Scanner(System.in);
        Table tables = new Table();
        System.out.println("Hello, please enter path to the directory with file(s) : ");
        String pathToDirectory = in.nextLine();
        File directory = new File(pathToDirectory);
        getListOfFiles(directory);
        for (int count = 0; count < filesList.size(); count++) {
            fileInfoList.add(new FileInfo(filesList.get(count),filesName.get(count)));
        }

        tables.insertToDB(fileInfoList);
        fileInfoListRead = tables.selectAllFromDB();
        for(FileInfo out : tables.selectAllFromDB()){
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
                filesName.add(currentFile.getName());
            }
        }

    }
}
