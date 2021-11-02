package com.mucho;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class BoardAnalyzer {

    // analyzes draft board and generates average players, as well as standard deviations in each category

    private static Player averagePlayer;
    private static Player averagePG;
    private static Player averageSG;
    private static Player averageSF;
    private static Player averagePF;
    private static Player averageC;
    private static Player standardDeviations; // making players to house the standard deviations on all categories
    private static Player standardDeviationsPG;
    private static Player standardDeviationsSG;
    private static Player standardDeviationsSF;
    private static Player standardDeviationsPF;
    private static Player standardDeviationsC;

    public BoardAnalyzer(){ // not sure if this class even needs a constructor

    }


    // generateAveragePlayer goes through each player on the overall draft board, adds up per-game stats in each category, then divides the totals by board size (# of players)
    public static void generateAveragePlayer(DraftBoard board){
        Player averageP = new Player("none", "THE TRUE AVERAGE PLAYER");
        for (Player p : board.getOverallBoard()){
            averageP.setFGPercentage(averageP.getFGPercentage() + p.getFGPercentage());
            averageP.setFTPercentage(averageP.getFTPercentage() + p.getFTPercentage());
            averageP.setThreePM(averageP.getThreePM() + p.getThreePM());
            averageP.setPTS(averageP.getPTS() + p.getPTS());
            averageP.setTREB(averageP.getTREB() + p.getTREB());
            averageP.setAST(averageP.getAST() + p.getAST());
            averageP.setSTL(averageP.getSTL() + p.getSTL());
            averageP.setBLK(averageP.getBLK() + p.getBLK());
            averageP.setTO(averageP.getTO() + p.getTO());
        }
        averageP.setFGPercentage(averageP.getFGPercentage() / board.getOverallBoard().size());
        averageP.setFTPercentage(averageP.getFTPercentage() / board.getOverallBoard().size());
        averageP.setThreePM(averageP.getThreePM() / board.getOverallBoard().size());
        averageP.setPTS(averageP.getPTS() / board.getOverallBoard().size());
        averageP.setTREB(averageP.getTREB() / board.getOverallBoard().size());
        averageP.setAST(averageP.getAST() / board.getOverallBoard().size());
        averageP.setSTL(averageP.getSTL() / board.getOverallBoard().size());
        averageP.setBLK(averageP.getBLK() / board.getOverallBoard().size());
        averageP.setTO(averageP.getTO() / board.getOverallBoard().size());
        averagePlayer = averageP;
    }

    // same process as with generateAveragePlayer, except this time it's intended for use with the draft board of point guards
    public static void generateAveragePG(DraftBoard board){
        Player averageP = new Player("PG", "Average PG");
        for (Player p : board.getPGBoard()){
            averageP.setFGPercentage(averageP.getFGPercentage() + p.getFGPercentage());
            averageP.setFTPercentage(averageP.getFTPercentage() + p.getFTPercentage());
            averageP.setThreePM(averageP.getThreePM() + p.getThreePM());
            averageP.setPTS(averageP.getPTS() + p.getPTS());
            averageP.setTREB(averageP.getTREB() + p.getTREB());
            averageP.setAST(averageP.getAST() + p.getAST());
            averageP.setSTL(averageP.getSTL() + p.getSTL());
            averageP.setBLK(averageP.getBLK() + p.getBLK());
            averageP.setTO(averageP.getTO() + p.getTO());
        }
        averageP.setFGPercentage(averageP.getFGPercentage() / board.getPGBoard().size());
        averageP.setFTPercentage(averageP.getFTPercentage() / board.getPGBoard().size());
        averageP.setThreePM(averageP.getThreePM() / board.getPGBoard().size());
        averageP.setPTS(averageP.getPTS() / board.getPGBoard().size());
        averageP.setTREB(averageP.getTREB() / board.getPGBoard().size());
        averageP.setAST(averageP.getAST() / board.getPGBoard().size());
        averageP.setSTL(averageP.getSTL() / board.getPGBoard().size());
        averageP.setBLK(averageP.getBLK() / board.getPGBoard().size());
        averageP.setTO(averageP.getTO() / board.getPGBoard().size());
        averagePG = averageP;
    }

    public static void generateAverageSG(DraftBoard board){
        Player averageP = new Player("SG", "Average SG");
        for (Player p : board.getSGBoard()){
            averageP.setFGPercentage(averageP.getFGPercentage() + p.getFGPercentage());
            averageP.setFTPercentage(averageP.getFTPercentage() + p.getFTPercentage());
            averageP.setThreePM(averageP.getThreePM() + p.getThreePM());
            averageP.setPTS(averageP.getPTS() + p.getPTS());
            averageP.setTREB(averageP.getTREB() + p.getTREB());
            averageP.setAST(averageP.getAST() + p.getAST());
            averageP.setSTL(averageP.getSTL() + p.getSTL());
            averageP.setBLK(averageP.getBLK() + p.getBLK());
            averageP.setTO(averageP.getTO() + p.getTO());
        }
        averageP.setFGPercentage(averageP.getFGPercentage() / board.getSGBoard().size());
        averageP.setFTPercentage(averageP.getFTPercentage() / board.getSGBoard().size());
        averageP.setThreePM(averageP.getThreePM() / board.getSGBoard().size());
        averageP.setPTS(averageP.getPTS() / board.getSGBoard().size());
        averageP.setTREB(averageP.getTREB() / board.getSGBoard().size());
        averageP.setAST(averageP.getAST() / board.getSGBoard().size());
        averageP.setSTL(averageP.getSTL() / board.getSGBoard().size());
        averageP.setBLK(averageP.getBLK() / board.getSGBoard().size());
        averageP.setTO(averageP.getTO() / board.getSGBoard().size());
        averageSG = averageP;
    }

    public static void generateAverageSF(DraftBoard board){
        Player averageP = new Player("SF", "Average SF");
        for (Player p : board.getSFBoard()){
            averageP.setFGPercentage(averageP.getFGPercentage() + p.getFGPercentage());
            averageP.setFTPercentage(averageP.getFTPercentage() + p.getFTPercentage());
            averageP.setThreePM(averageP.getThreePM() + p.getThreePM());
            averageP.setPTS(averageP.getPTS() + p.getPTS());
            averageP.setTREB(averageP.getTREB() + p.getTREB());
            averageP.setAST(averageP.getAST() + p.getAST());
            averageP.setSTL(averageP.getSTL() + p.getSTL());
            averageP.setBLK(averageP.getBLK() + p.getBLK());
            averageP.setTO(averageP.getTO() + p.getTO());
        }
        averageP.setFGPercentage(averageP.getFGPercentage() / board.getSFBoard().size());
        averageP.setFTPercentage(averageP.getFTPercentage() / board.getSFBoard().size());
        averageP.setThreePM(averageP.getThreePM() / board.getSFBoard().size());
        averageP.setPTS(averageP.getPTS() / board.getSFBoard().size());
        averageP.setTREB(averageP.getTREB() / board.getSFBoard().size());
        averageP.setAST(averageP.getAST() / board.getSFBoard().size());
        averageP.setSTL(averageP.getSTL() / board.getSFBoard().size());
        averageP.setBLK(averageP.getBLK() / board.getSFBoard().size());
        averageP.setTO(averageP.getTO() / board.getSFBoard().size());
        averageSF = averageP;
    }

    public static void generateAveragePF(DraftBoard board){
        Player averageP = new Player("PF", "Average PF");
        for (Player p : board.getPFBoard()){
            averageP.setFGPercentage(averageP.getFGPercentage() + p.getFGPercentage());
            averageP.setFTPercentage(averageP.getFTPercentage() + p.getFTPercentage());
            averageP.setThreePM(averageP.getThreePM() + p.getThreePM());
            averageP.setPTS(averageP.getPTS() + p.getPTS());
            averageP.setTREB(averageP.getTREB() + p.getTREB());
            averageP.setAST(averageP.getAST() + p.getAST());
            averageP.setSTL(averageP.getSTL() + p.getSTL());
            averageP.setBLK(averageP.getBLK() + p.getBLK());
            averageP.setTO(averageP.getTO() + p.getTO());
        }
        averageP.setFGPercentage(averageP.getFGPercentage() / board.getPFBoard().size());
        averageP.setFTPercentage(averageP.getFTPercentage() / board.getPFBoard().size());
        averageP.setThreePM(averageP.getThreePM() / board.getPFBoard().size());
        averageP.setPTS(averageP.getPTS() / board.getPFBoard().size());
        averageP.setTREB(averageP.getTREB() / board.getPFBoard().size());
        averageP.setAST(averageP.getAST() / board.getPFBoard().size());
        averageP.setSTL(averageP.getSTL() / board.getPFBoard().size());
        averageP.setBLK(averageP.getBLK() / board.getPFBoard().size());
        averageP.setTO(averageP.getTO() / board.getPFBoard().size());
        averagePF = averageP;
    }

    public static void generateAverageC(DraftBoard board){
        Player averageP = new Player("C", "Average Center");
        for (Player p : board.getCBoard()){
            averageP.setFGPercentage(averageP.getFGPercentage() + p.getFGPercentage());
            averageP.setFTPercentage(averageP.getFTPercentage() + p.getFTPercentage());
            averageP.setThreePM(averageP.getThreePM() + p.getThreePM());
            averageP.setPTS(averageP.getPTS() + p.getPTS());
            averageP.setTREB(averageP.getTREB() + p.getTREB());
            averageP.setAST(averageP.getAST() + p.getAST());
            averageP.setSTL(averageP.getSTL() + p.getSTL());
            averageP.setBLK(averageP.getBLK() + p.getBLK());
            averageP.setTO(averageP.getTO() + p.getTO());
        }
        averageP.setFGPercentage(averageP.getFGPercentage() / board.getCBoard().size());
        averageP.setFTPercentage(averageP.getFTPercentage() / board.getCBoard().size());
        averageP.setThreePM(averageP.getThreePM() / board.getCBoard().size());
        averageP.setPTS(averageP.getPTS() / board.getCBoard().size());
        averageP.setTREB(averageP.getTREB() / board.getCBoard().size());
        averageP.setAST(averageP.getAST() / board.getCBoard().size());
        averageP.setSTL(averageP.getSTL() / board.getCBoard().size());
        averageP.setBLK(averageP.getBLK() / board.getCBoard().size());
        averageP.setTO(averageP.getTO() / board.getCBoard().size());
        averageC = averageP;
    }

    // creates a player object, which houses the standard deviations for a position (in this case, standard deviations for all positions)
    public static void generateStandardDeviations(DraftBoard board){
        Player stdDevAllPositions =     new Player("all positions", "standard deviations - all positions", 0, generateStandardDeviationFG(board.getOverallBoard()),
                generateStandardDeviationFT(board.getOverallBoard()), generateStandardDeviationThrees(board.getOverallBoard()), generateStandardDeviationPTS(board.getOverallBoard()),
                generateStandardDeviationTREB(board.getOverallBoard()), generateStandardDeviationAST(board.getOverallBoard()), generateStandardDeviationSTL(board.getOverallBoard()),
                generateStandardDeviationBLK(board.getOverallBoard()), generateStandardDeviationTO(board.getOverallBoard()), 0);
        standardDeviations = stdDevAllPositions;
    }

    public static void generateStandardDeviationsPG(DraftBoard board){
        Player stdDevPG = new Player("point guard", "standard deviations - point guard", 0, generateStandardDeviationFG(board.getPGBoard()),
                generateStandardDeviationFT(board.getPGBoard()), generateStandardDeviationThrees(board.getPGBoard()), generateStandardDeviationPTS(board.getPGBoard()),
                generateStandardDeviationTREB(board.getPGBoard()), generateStandardDeviationAST(board.getPGBoard()), generateStandardDeviationSTL(board.getPGBoard()),
                generateStandardDeviationBLK(board.getPGBoard()), generateStandardDeviationTO(board.getPGBoard()), 0);
        standardDeviationsPG = stdDevPG;
    }

    public static void generateStandardDeviationsSG(DraftBoard board){
        Player stdDevSG = new Player("shooting guard", "standard deviations - shooting guard", 0, generateStandardDeviationFG(board.getSGBoard()),
                generateStandardDeviationFT(board.getSGBoard()), generateStandardDeviationThrees(board.getSGBoard()), generateStandardDeviationPTS(board.getSGBoard()),
                generateStandardDeviationTREB(board.getSGBoard()), generateStandardDeviationAST(board.getSGBoard()), generateStandardDeviationSTL(board.getSGBoard()),
                generateStandardDeviationBLK(board.getSGBoard()), generateStandardDeviationTO(board.getSGBoard()), 0);
        standardDeviationsSG = stdDevSG;
    }

    public static void generateStandardDeviationsSF(DraftBoard board){
        Player stdDevSF = new Player("small forward", "standard deviations - small forward", 0, generateStandardDeviationFG(board.getSFBoard()),
                generateStandardDeviationFT(board.getSFBoard()), generateStandardDeviationThrees(board.getSFBoard()), generateStandardDeviationPTS(board.getSFBoard()),
                generateStandardDeviationTREB(board.getSFBoard()), generateStandardDeviationAST(board.getSFBoard()), generateStandardDeviationSTL(board.getSFBoard()),
                generateStandardDeviationBLK(board.getSFBoard()), generateStandardDeviationTO(board.getSFBoard()), 0);
        standardDeviationsSF = stdDevSF;
    }

    public static void generateStandardDeviationsPF(DraftBoard board){
        Player stdDevPF = new Player("power forward", "standard deviations - power forward", 0, generateStandardDeviationFG(board.getPFBoard()),
                generateStandardDeviationFT(board.getPFBoard()), generateStandardDeviationThrees(board.getPFBoard()), generateStandardDeviationPTS(board.getPFBoard()),
                generateStandardDeviationTREB(board.getPFBoard()), generateStandardDeviationAST(board.getPFBoard()), generateStandardDeviationSTL(board.getPFBoard()),
                generateStandardDeviationBLK(board.getPFBoard()), generateStandardDeviationTO(board.getPFBoard()), 0);
        standardDeviationsPF = stdDevPF;
    }

    public static void generateStandardDeviationsC(DraftBoard board){
        Player stdDevC = new Player("center", "standard deviations - center", 0, generateStandardDeviationFG(board.getCBoard()),
                generateStandardDeviationFT(board.getCBoard()), generateStandardDeviationThrees(board.getCBoard()), generateStandardDeviationPTS(board.getCBoard()),
                generateStandardDeviationTREB(board.getCBoard()), generateStandardDeviationAST(board.getCBoard()), generateStandardDeviationSTL(board.getCBoard()),
                generateStandardDeviationBLK(board.getCBoard()), generateStandardDeviationTO(board.getCBoard()), 0);
        standardDeviationsC = stdDevC;
    }

    // takes a list of players (i.e. PGBoard, SGBoard, etc.) and calculates the standard deviation of their FG percentages
    public static double generateStandardDeviationFG(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getFGPercentage());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationFT(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getFTPercentage());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationThrees(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getThreePM());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationPTS(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getPTS());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationTREB(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getTREB());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationAST(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getAST());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationSTL(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getSTL());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationBLK(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getBLK());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }

    public static double generateStandardDeviationTO(ArrayList<Player> players){
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Player plyr : players) {
            stats.addValue(plyr.getTO());
        }
        double standardDeviation = stats.getStandardDeviation();
        return standardDeviation;
    }


    public static Player getStandardDeviations() {
        return standardDeviations;
    }

    public static void setStandardDeviations(Player standardDeviations) {
        BoardAnalyzer.standardDeviations = standardDeviations;
    }

    public static Player getStandardDeviationsPG() {
        return standardDeviationsPG;
    }

    public static void setStandardDeviationsPG(Player standardDeviationsPG) {
        BoardAnalyzer.standardDeviationsPG = standardDeviationsPG;
    }

    public static Player getStandardDeviationsSG() {
        return standardDeviationsSG;
    }

    public static void setStandardDeviationsSG(Player standardDeviationsSG) {
        BoardAnalyzer.standardDeviationsSG = standardDeviationsSG;
    }

    public static Player getStandardDeviationsSF() {
        return standardDeviationsSF;
    }

    public static void setStandardDeviationsSF(Player standardDeviationsSF) {
        BoardAnalyzer.standardDeviationsSF = standardDeviationsSF;
    }

    public static Player getStandardDeviationsPF() {
        return standardDeviationsPF;
    }

    public static void setStandardDeviationsPF(Player standardDeviationsPF) {
        BoardAnalyzer.standardDeviationsPF = standardDeviationsPF;
    }

    public static Player getStandardDeviationsC() {
        return standardDeviationsC;
    }

    public static void setStandardDeviationsC(Player standardDeviationsC) {
        BoardAnalyzer.standardDeviationsC = standardDeviationsC;
    }


    public static Player getAveragePlayer() {
        return averagePlayer;
    }

    public static void setAveragePlayer(Player averagePlayer) {
        BoardAnalyzer.averagePlayer = averagePlayer;
    }

    public static Player getAveragePG() {
        return averagePG;
    }

    public static void setAveragePG(Player averagePG) {
        BoardAnalyzer.averagePG = averagePG;
    }

    public static Player getAverageSG() {
        return averageSG;
    }

    public static void setAverageSG(Player averageSG) {
        BoardAnalyzer.averageSG = averageSG;
    }

    public static Player getAverageSF() {
        return averageSF;
    }

    public static void setAverageSF(Player averageSF) {
        BoardAnalyzer.averageSF = averageSF;
    }

    public static Player getAveragePF() {
        return averagePF;
    }

    public static void setAveragePF(Player averagePF) {
        BoardAnalyzer.averagePF = averagePF;
    }

    public static Player getAverageC() {
        return averageC;
    }

    public static void setAverageC(Player averageC) {
        BoardAnalyzer.averageC = averageC;
    }
}
