package com.mucho;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	/*
	roadmap:
	X Player class
	X Season/Projections/PlayerStats class
	X ExcelReader + prototype of DraftBoard
	Actual DraftBoard (might need to use netbeans to design GUI)

	merge ExcelReader and DraftBoard? right now separation seems arbitrary, with generating average players making sense as part of DraftBoard
	 */

        ExcelReader testReader = new ExcelReader("Q:/assorted chicanery/HashtagBasketballProjections2122.xlsx");
        DraftBoard board = new DraftBoard();
        board.generateBoards(testReader);
        BoardAnalyzer.generateAverageC(board);
        BoardAnalyzer.generateStandardDeviations(board);
        System.out.println(BoardAnalyzer.getStandardDeviations().toString());
        BoardAnalyzer.generateStandardDeviationsPG(board);
        System.out.println(BoardAnalyzer.getStandardDeviationsPG().toString());
        BoardAnalyzer.generateStandardDeviationsSG(board);
        System.out.println(BoardAnalyzer.getStandardDeviationsSG().toString());
        BoardAnalyzer.generateStandardDeviationsSF(board);
        System.out.println(BoardAnalyzer.getStandardDeviationsSF().toString());
        BoardAnalyzer.generateStandardDeviationsPF(board);
        System.out.println(BoardAnalyzer.getStandardDeviationsPF().toString());
        BoardAnalyzer.generateStandardDeviationsC(board);
        System.out.println(BoardAnalyzer.getStandardDeviationsC().toString());
    }
}
