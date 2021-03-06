package com.loyanix.textslicer.jdbc.DAO;

import com.loyanix.textslicer.jdbc.Services.FileInfo;
import com.loyanix.textslicer.jdbc.Services.LineInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Table {

    public Table() throws SQLException {
        createTable();
    }

    private static void createTable(){
        String sqlDropTableFile = "DROP TABLE IF EXISTS INFO_ABOUT_FILES";
        String sqlCreateTableFile = "CREATE TABLE INFO_ABOUT_FILES(ID_FILE INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME_OF_FILE VARCHAR(32) NOT NULL," +
                "LONGEST_WORD_IN_FILE VARCHAR(32) NOT NULL," +
                "LENGTH_WORD_LONG INT NOT NULL," +
                "SHORTEST_WORD_IN_FILE VARCHAR(32) NOT NULL," +
                "LENGTH_WORD_SHORT INT NOT NULL," +
                "AVG_WORD_LENGTH_IN_FILE INT," +
                "AVG_LINE_LENGTH_IN_FILE INT NOT NULL)";
        String sqlDropTableLine = "DROP TABLE IF EXISTS INFO_ABOUT_LINES";
        String sqlCreateTableLine = "CREATE TABLE INFO_ABOUT_LINES(ID_LINE INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "ID_FILE INT NOT NULL," +
                "LONGEST_WORD_IN_LINE VARCHAR(32) NOT NULL," +
                "LENGTH_WORD_LONG INT NOT NULL," +
                "SHORTEST_WORD_IN_LINE VARCHAR(32) NOT NULL," +
                "LENGTH_WORD_SHORT INT NOT NULL," +
                "AVG_WORD_LENGTH_IN_LINE INT," +
                "LINE_LENGTH INT NOT NULL," +
                "CONSTRAINT FILE FOREIGN KEY (ID_FILE) REFERENCES INFO_ABOUT_FILES (ID_FILE))";
        try(Connection connection = DataBaseConnect.connection()){
            Statement statementFiles = connection.createStatement();
            Statement statementLines = connection.createStatement();
            statementFiles.executeUpdate(sqlDropTableFile);
            statementLines.executeUpdate(sqlDropTableLine);
            statementFiles.executeUpdate(sqlCreateTableFile);
            statementLines.executeUpdate(sqlCreateTableLine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("DB is created");
    }

    public void insertToDB(List<FileInfo> fileInfos){
        String sqlInsertDataOfFile = "INSERT INTO INFO_ABOUT_FILES(NAME_OF_FILE," +
                "LONGEST_WORD_IN_FILE," +
                "LENGTH_WORD_LONG, " +
                "SHORTEST_WORD_IN_FILE," +
                "LENGTH_WORD_SHORT," +
                "AVG_WORD_LENGTH_IN_FILE," +
                "AVG_LINE_LENGTH_IN_FILE)" +
                "VALUES (?,?,?,?,?,?,?)";
        String sqlInsertDataOfLine = "INSERT INTO INFO_ABOUT_LINES(ID_FILE," +
                "LONGEST_WORD_IN_LINE," +
                "LENGTH_WORD_LONG, " +
                "SHORTEST_WORD_IN_LINE," +
                "LENGTH_WORD_SHORT," +
                "AVG_WORD_LENGTH_IN_LINE," +
                "LINE_LENGTH) " +
                "VALUES (?,?,?,?,?,?,?)";
        try(Connection connection = DataBaseConnect.connection()) {
            PreparedStatement preparedStatementFile = connection.prepareStatement(sqlInsertDataOfFile);
            PreparedStatement preparedStatementLine = connection.prepareStatement(sqlInsertDataOfLine);
            Statement statement = connection.createStatement();
            for(FileInfo fileInfo:fileInfos){
                preparedStatementFile.setString(1,fileInfo.getFileName());
                preparedStatementFile.setString(2,fileInfo.getLongestWord());
                preparedStatementFile.setInt(3,fileInfo.getLengthOfLongestWord());
                preparedStatementFile.setString(4,fileInfo.getShortestWord());
                preparedStatementFile.setInt(5, fileInfo.getLengthOfShortestWord());
                preparedStatementFile.setInt(6,fileInfo.getAvgLengthWord());
                preparedStatementFile.setInt(7,fileInfo.getAvgLengthLine());
                preparedStatementFile.executeUpdate();
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID() AS ID_FILE");
                int idFile = 0;
                while (resultSet.next()) idFile = resultSet.getInt("id_file");
                for (LineInfo lineInfo: fileInfo.getLineInfos()){
                    preparedStatementLine.setInt(1, idFile);
                    preparedStatementLine.setString(2, lineInfo.getLongestWord());
                    preparedStatementLine.setInt(3,lineInfo.getLengthOfLongestWord());
                    preparedStatementLine.setString(4, lineInfo.getShortestWord());
                    preparedStatementLine.setInt(5, lineInfo.getLengthOfShortestWord());
                    preparedStatementLine.setInt(6,lineInfo.getAvgLengthWord());
                    preparedStatementLine.setInt(7,lineInfo.getLengthLine());
                    preparedStatementLine.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<FileInfo> selectAllFromDB(){
        List<FileInfo> fileInfo = new ArrayList<>();
        List<LineInfo> lineInfos = new ArrayList<>();
        ResultSet resultSet;
        ResultSet resultSetFile;
        try(Connection connection = DataBaseConnect.connection()) {
            Statement statementLine = connection.createStatement();
            Statement statementFile = connection.createStatement();
            String sqlSelectFile = "SELECT * FROM INFO_ABOUT_FILES";
            resultSetFile = statementFile.executeQuery(sqlSelectFile);
            while (resultSetFile.next()){
                String sqlSelect = "SELECT * FROM INFO_ABOUT_LINES WHERE ID_FILE = " + resultSetFile.getRow();
                resultSet = statementLine.executeQuery(sqlSelect);
                lineInfos.clear();
                while (resultSet.next())   {
                    LineInfo lineInfo = new LineInfo("");
                    lineInfo.setLongestWord(resultSet.getString("LONGEST_WORD_IN_LINE"));
                    lineInfo.setLengthOfLongestWord(resultSet.getInt("LENGTH_WORD_LONG"));
                    lineInfo.setShortestWord(resultSet.getString("SHORTEST_WORD_IN_LINE"));
                    lineInfo.setLengthOfShortestWord(resultSet.getInt("LENGTH_WORD_SHORT"));
                    lineInfo.setAvgLengthWord(resultSet.getInt("AVG_WORD_LENGTH_IN_LINE"));
                    lineInfo.setLengthLine(resultSet.getInt("LINE_LENGTH"));
                    lineInfos.add(lineInfo);
                }
                fileInfo.add(new FileInfo(lineInfos, resultSetFile.getString("NAME_OF_FILE"), null));
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return fileInfo;
    }
}