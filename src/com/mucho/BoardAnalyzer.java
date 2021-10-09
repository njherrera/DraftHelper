package com.mucho;

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


    public void generateAveragePlayer(DraftBoard board){
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

    public void generateAveragePG(DraftBoard board){
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

    public void generateAverageSG(DraftBoard board){
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

    public void generateAverageSF(DraftBoard board){
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

    public void generateAveragePF(DraftBoard board){
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

    public void generateAverageC(DraftBoard board){
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
