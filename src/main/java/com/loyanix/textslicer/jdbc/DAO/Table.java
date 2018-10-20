package com.loyanix.textslicer.jdbc.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {

    public Table() throws SQLException {
        createTable();
    }

    private static void createTable(){
        String sqlDropTableFile = "DROP TABLE IF EXISTS INFO_ABOUT_FILES";
        String sqlCreateTableFile = "CREATE TABLE INFO_ABOUT_FILES(ID_FILE NUMBER PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME_OF_FILE VARCHAR(32) NOT NULL," +
                "LONGEST_WORD_IN_FILE VARCHAR(32) NOT NULL," +
                "LENGHT_WORD NUMBER NOT NULL," +
                "SHORTEST_WORD_IN_FILE VARCHAR(32) NOT NULL," +
                "LENGHT_LINE NUMBER NOT NULL," +
                "AVG_WORD_LENGTH_IN_FILE NUMBER," +
                "AVG_LINE_LENGTH_IN_FILE NUMBER NOT NULL)";
        String sqlDropTableLine = "DROP TABLE IF EXISTS INFO_ABOUT_LINES";
        String sqlCreateTableLine = "CREATE TABLE INFO_ABOUT_LINES(ID_LINE NUMBER PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "ID_FILE NUMBER NOT NULL," +
                "LONGEST_WORD_IN_LINE VARCHAR(32) NOT NULL," +
                "LENGHT_WORD NUMBER NOT NULL," +
                "SHORTEST_WORD_IN_LINE VARCHAR(32) NOT NULL," +
                "LENGHT_LINE NUMBER NOT NULL," +
                "AVG_WORD_LENGTH_IN_LINE NUMBER," +
                "LINE_LENGTH NUMBER NOT NULL," +
                "CONSTRAINT FILE FOREIGN KEY (ID_FILE) REFERENCES INFO_ABOUT_FILES (ID_FILE))";

        try(Connection connection = DataBaseConnect.connection();){
            Statement statementFiles = connection.createStatement();
            Statement statementLines = connection.createStatement();
            statementFiles.executeUpdate(sqlDropTableFile);
            statementFiles.executeUpdate(sqlCreateTableFile);
            statementLines.executeUpdate(sqlDropTableLine);
            statementLines.executeUpdate(sqlCreateTableLine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("DB is created");

    }


}