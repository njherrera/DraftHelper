package com.mucho;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	/*
	roadmap:
	Player class
	Season/Projections/PlayerStats class
	ExcelReader + prototype of DraftBoard
	Actual DraftBoard (might need to use netbeans to design GUI)
	 */

        ExcelReader testReader = new ExcelReader("Q:/assorted chicanery/HashtagBasketballProjections2122.xlsx");
        testReader.generateAveragePlayer();
        System.out.println(testReader.getAveragePlayer().toString());
    }
}
