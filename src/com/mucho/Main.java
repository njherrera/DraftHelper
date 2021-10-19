package com.mucho;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	/*
	roadmap:
	X Player class
	X Season/Projections/PlayerStats class
	X ExcelReader + prototype of DraftBoard
	X Team analysis
	X Player recommending
	Calculating FG and FT% by using FGA/FTA and FGM/FTM
	Recommending with quotas
	Actual DraftBoard (might need to use netbeans to design GUI)

	 */

        ExcelReader testReader = new ExcelReader("Q:/assorted chicanery/HashtagBasketballProjections2122.xlsx");
        DraftBoard board = new DraftBoard();
        board.generateBoards(testReader);
        Team myTeam = new Team(12);
        myTeam.addPlayer(board.getOverallBoard().get(40));
        board.getOverallBoard().remove(40);
        myTeam.addPlayer(board.getOverallBoard().get(35));
        board.getOverallBoard().remove(35);
        myTeam.addPlayer(board.getOverallBoard().get(30));
        board.getOverallBoard().remove(30);
        for (Player plyr : myTeam.getTeamRoster()) {
            System.out.println(plyr.toString());
        }
        myTeam.setBenchmarkStats(.464, .783, 1.066, 14.776, 5.994, 3.33, 1.094, .740, 1.8, 12);
        myTeam.analyzeTeam(board);
        board.flagPlayers();
        System.out.println(Arrays.toString(myTeam.getPerGameStats()));
        System.out.println(Arrays.toString(myTeam.getBenchmarkStats()));
        System.out.println(myTeam.toString());
        for (Player plyr : myTeam.recommendAPlayer(board)) {
            System.out.println(plyr.toString());
        }
//        BoardAnalyzer.generateAveragePlayer(board);
//        System.out.println(BoardAnalyzer.getAveragePlayer().toString());
//        BoardAnalyzer.generateStandardDeviations(board);
//        System.out.println(BoardAnalyzer.getStandardDeviations().toString());
//        BoardAnalyzer.generateStandardDeviationsPG(board);
//        System.out.println(BoardAnalyzer.getStandardDeviationsPG().toString());
//        BoardAnalyzer.generateStandardDeviationsSG(board);
//        System.out.println(BoardAnalyzer.getStandardDeviationsSG().toString());
//        BoardAnalyzer.generateStandardDeviationsSF(board);
//        System.out.println(BoardAnalyzer.getStandardDeviationsSF().toString());
//        BoardAnalyzer.generateStandardDeviationsPF(board);
//        System.out.println(BoardAnalyzer.getStandardDeviationsPF().toString());
//        BoardAnalyzer.generateStandardDeviationsC(board);
//        System.out.println(BoardAnalyzer.getStandardDeviationsC().toString());
    }
}
