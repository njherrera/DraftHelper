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
     */

    private XSSFSheet importedBoard;

    public ExcelReader(String filePath) throws FileNotFoundException, IOException {
        File board = new File(filePath);
        FileInputStream inputStream = new FileInputStream(board);
        XSSFWorkbook myWorkbook = new XSSFWorkbook(inputStream);
        this.importedBoard = myWorkbook.getSheetAt(0);
    }

    public XSSFSheet getImportedBoard() {
        return importedBoard;
    }

    public void setImportedBoard(XSSFSheet importedBoard) {
        this.importedBoard = importedBoard;
    }




}
