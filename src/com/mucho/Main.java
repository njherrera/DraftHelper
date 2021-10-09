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
        BoardAnalyzer analyzer = new BoardAnalyzer();
        board.generateBoards(testReader);
        analyzer.generateAveragePlayer(board);
        System.out.println(analyzer.getAveragePlayer().toString());
    }
}
