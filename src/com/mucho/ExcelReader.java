package com.mucho;

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

    public ExcelReader(String filePath) throws FileNotFoundException, IOException {
        File board = new File(filePath);
        FileInputStream inputStream = new FileInputStream(board);
        XSSFWorkbook myWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet importedBoard = myWorkbook.getSheetAt(0);
    }

    public void generate

    public void generateAveragePlayer(DraftBoard board){
        // go through importedBoard and average all of the relevant categories
        // create player with constructor using average of each category
    }

    public void generateAveragePG(DraftBoard PGBoard){

    }

    public void generateAverageSG(DraftBoard SGBoard){

    }

    public void generateAverageSF(DraftBoard SFBoard){

    }

    public void generateAveragePF(DraftBoard PFBoard){

    }

    public void generateAverageC(DraftBoard CBoard){

    }

}
