package com.loyanix.textslicer.jdbc;

import com.loyanix.textslicer.jdbc.statisticClasses.fileInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<List> list = new ArrayList<>();
    private static List<fileInfo> fileInfoList= new ArrayList<>();

    public static void main(String[] args) {

        String pathToDirectory = " ";
        File directory = new File(pathToDirectory);
        getListOfFiles(directory);
        for (List<String> listFiles : list) fileInfoList.add(new fileInfo(listFiles));

    }

    private static void getListOfFiles(File file){


    }
}
