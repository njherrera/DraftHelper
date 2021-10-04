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
        testReader.generateAveragePlayer();
        testReader.generateAveragePG();
        testReader.generateAverageSG();
        testReader.generateAverageSF();
        testReader.generateAveragePF();
        testReader.generateAverageC();
        System.out.println(testReader.getAveragePlayer().toString());
        System.out.println(testReader.getAveragePG().toString());
        System.out.println(testReader.getAverageSG().toString());
        System.out.println(testReader.getAverageSF().toString());
        System.out.println(testReader.getAveragePF().toString());
        System.out.println(testReader.getAverageC().toString());
        DraftBoard board = new DraftBoard();
        board.generateBoards(testReader);
        for (Player plyr : board.getPGBoard()){
            System.out.println(plyr.toString());
        }
    }
}
