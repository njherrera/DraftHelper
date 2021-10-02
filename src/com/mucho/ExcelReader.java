package com.mucho;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelReader {
    /*
    reads projections/stats
    calculates average stats overall and by position (maybe create an "average player" for each position, as well as overall?
     */

    private static Player averagePlayer;
    private static Player averagePG;
    private static Player averageSG;
    private static Player averageSF;
    private static Player averagePF;
    private static Player averageC;
    private XSSFSheet importedBoard;

    public static Player getAveragePlayer() {
        return averagePlayer;
    }

    public static void setAveragePlayer(Player averagePlayer) {
        ExcelReader.averagePlayer = averagePlayer;
    }

    public static Player getAveragePG() {
        return averagePG;
    }

    public static void setAveragePG(Player averagePG) {
        ExcelReader.averagePG = averagePG;
    }

    public static Player getAverageSG() {
        return averageSG;
    }

    public static void setAverageSG(Player averageSG) {
        ExcelReader.averageSG = averageSG;
    }

    public static Player getAverageSF() {
        return averageSF;
    }

    public static void setAverageSF(Player averageSF) {
        ExcelReader.averageSF = averageSF;
    }

    public static Player getAveragePF() {
        return averagePF;
    }

    public static void setAveragePF(Player averagePF) {
        ExcelReader.averagePF = averagePF;
    }

    public static Player getAverageC() {
        return averageC;
    }

    public static void setAverageC(Player averageC) {
        ExcelReader.averageC = averageC;
    }

    public XSSFSheet getImportedBoard() {
        return importedBoard;
    }

    public void setImportedBoard(XSSFSheet importedBoard) {
        this.importedBoard = importedBoard;
    }

    public ExcelReader(String filePath) throws FileNotFoundException, IOException {
        File board = new File(filePath);
        FileInputStream inputStream = new FileInputStream(board);
        XSSFWorkbook myWorkbook = new XSSFWorkbook(inputStream);
        this.importedBoard = myWorkbook.getSheetAt(0);
    }

    // for generateAveragePlayer as well as other methods, implement calculating average FG/FT with total makes and attempts of all players?
    public void generateAveragePlayer(){
        // go through importedBoard and average all of the relevant categories
        // create player with constructor using average of each category
        double[] totalStats = new double[10];
        for (int i = 1; i < importedBoard.getLastRowNum(); i++) {
            
            totalStats[0] = totalStats[0] + DoubleimportedBoard.getRow(i).getCell(5).getNumericCellValue();
            String[] FGPercentageSplit = importedBoard.getRow(i).getCell(7).toString().split("\\s*[()]\\s*");
            double actualFGPercentage = Double.parseDouble(FGPercentageSplit[0]);
            totalStats[1] = totalStats[1] + actualFGPercentage;
            String[] FTPercentageSplit = importedBoard.getRow(i).getCell(8).toString().split("\\s*[()]\\s*");
            double actualFTPercentage = Double.parseDouble(FTPercentageSplit[0]);
            totalStats[2] = totalStats[2] + actualFTPercentage;
            totalStats[3] = totalStats[3] + Double.parseDouble(importedBoard.getRow(i).getCell(9).toString());
            totalStats[4] = totalStats[4] + Double.parseDouble(importedBoard.getRow(i).getCell(10).toString());
            totalStats[5] = totalStats[5] + Double.parseDouble(importedBoard.getRow(i).getCell(11).toString());
            totalStats[6] = totalStats[6] + Double.parseDouble(importedBoard.getRow(i).getCell(12).toString());
            totalStats[7] = totalStats[7] + Double.parseDouble(importedBoard.getRow(i).getCell(13).toString());
            totalStats[8] = totalStats[8] + Double.parseDouble(importedBoard.getRow(i).getCell(14).toString());
            totalStats[9] = totalStats[9] + Double.parseDouble(importedBoard.getRow(i).getCell(15).toString());
        }
        for (int i = 0; i < totalStats.length; i++){
            totalStats[i] = totalStats[i] / 200;
        }
        averagePlayer = new Player("none",totalStats[0], totalStats[1], totalStats[2], totalStats[3], totalStats[4], totalStats[5],
                totalStats[6], totalStats[7], totalStats[8], totalStats[9], 0);

    }

    public void generateAveragePG(XSSFSheet board){

    }

    public void generateAverageSG(XSSFSheet board){

    }

    public void generateAverageSF(XSSFSheet board){

    }

    public void generateAveragePF(XSSFSheet board){

    }

    public void generateAverageC(XSSFSheet board){

    }

}
