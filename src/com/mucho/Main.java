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
	ExcelReader + prototype of DraftBoard
	Actual DraftBoard (might need to use netbeans to design GUI)
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
        ArrayList<Player> ovrboard = new ArrayList<Player>();
        ArrayList<Player> pgboard = new ArrayList<Player>();
        ArrayList<Player> sgboard = new ArrayList<Player>();
        ArrayList<Player> sfboard = new ArrayList<Player>();
        ArrayList<Player> pfboard = new ArrayList<Player>();
        ArrayList<Player> cboard = new ArrayList<Player>();
        DraftBoard board = new DraftBoard(ovrboard, pgboard, sgboard, sfboard, pfboard, cboard);
        board.generateBoards(testReader);
        for (Player plyr : board.getOverallBoard()) {
            System.out.println(plyr.toString());
        }
    }
}
