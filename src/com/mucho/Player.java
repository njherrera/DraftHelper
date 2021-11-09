package com.mucho;


import java.util.Objects;

public class Player {
    /* draft board is composed of these
    HAS AN array of projected/actual stats
    HAS A position
    HAS some way of designating elite/poor stats
    starting format is 9 cat roto

    determining elite cats:
        compare player to averagePlayer and average___
        define std dev for each category, for both all players and position
        categorize players stats in terms of std dev from mean, both averagePlayer and average___
    */

    private String positions;
    private String name;
    private double gamesPlayed;
    private double FGPercentage;
    private double FGAttempted;
    private double FGMade;
    private double FTPercentage;
    private double FTAttempted;
    private double FTMade;
    private double threePM;
    private double PTS;
    private double TREB;
    private double AST;
    private double STL;
    private double BLK;
    private double TO;
    private double HashtagScore;
    private double averageDraftPosition;
    private String positiveOutliers;
    private String negativeOutliers; // only counts FG%/FT%/TO, categories where player can actively hurt you
    private int fitsNeeds;
    private int negativeCats;
    private double zScore;

    public Player(String pos, String playerName, double gp, double fgpercentage, double ftpercentage, double threes, double points,
                  double reb, double assists, double steals, double blocks, double turnovers, double htscore) {
        this.positions = pos;
        this.name = playerName;
        this.gamesPlayed = gp;
        this.FGPercentage = fgpercentage;
        this.FTPercentage = ftpercentage;
        this.threePM = threes;
        this.PTS = points;
        this.TREB = reb;
        this.AST = assists;
        this.STL = steals;
        this.BLK = blocks;
        this.TO = turnovers;
        this.HashtagScore = htscore;
    }

    public Player(String pos, String playerName){
        this.positions = pos;
        this.name = "";
        this.gamesPlayed = 0;
        this.FGPercentage = 0;
        this.FTPercentage = 0;
        this.FTPercentage = 0;
        this.threePM = 0;
        this.PTS = 0;
        this.TREB = 0;
        this.AST = 0;
        this.STL = 0;
        this.BLK = 0;
        this.TO = 0;
        this.HashtagScore = 0;
    }

    // dividing standard deviation by two, since an entire standard deviation is pretty big
    public void setPositiveOutliers(Player averagePlayer, Player standardDeviations){
        StringBuilder outliers = new StringBuilder();
        if (this.getFGPercentage() > averagePlayer.getFGPercentage() + (standardDeviations.getFGPercentage() / 2 )){
            outliers.append("FG, ");
        }
        if (this.getFTPercentage() > averagePlayer.getFTPercentage() + (standardDeviations.getFTPercentage() / 2 )){
            outliers.append("FT, ");
        }
        if (this.getThreePM() > averagePlayer.getThreePM() + (standardDeviations.getThreePM() / 2 )){
            outliers.append("3PM, ");
        }
        if (this.getPTS() > averagePlayer.getPTS() + (standardDeviations.getPTS() / 2 )){
            outliers.append("PTS, ");
        }
        if (this.getTREB() > averagePlayer.getTREB() + (standardDeviations.getTREB() / 2 )){
            outliers.append("REB, ");
        }
        if (this.getAST() > averagePlayer.getAST() + (standardDeviations.getAST() / 2 )){
            outliers.append("AST, ");
        }
        if (this.getSTL() > averagePlayer.getSTL() + (standardDeviations.getSTL() / 2 )){
            outliers.append("STL, ");
        }
        if (this.getBLK() > averagePlayer.getBLK() + (standardDeviations.getBLK() / 2 )){
            outliers.append("BLK, ");
        }
        if (this.getTO() < averagePlayer.getTO() - (standardDeviations.getTO() / 2 )){
            outliers.append("TO");
        }
        positiveOutliers = outliers.toString();
    }

    public void setNegativeOutliers(Player averagePlayer, Player standardDeviations){
        StringBuilder outliers = new StringBuilder();

        if (this.getFGPercentage() < averagePlayer.getFGPercentage() - (standardDeviations.getFGPercentage() / 2)){
            outliers.append("FG, ");
        }
        if (this.getFTPercentage() < averagePlayer.getFTPercentage() - (standardDeviations.getFTPercentage() / 2)){
            outliers.append("FT, ");
        }
        if (this.getTO() > averagePlayer.getTO() + (standardDeviations.getTO() / 2)){
            outliers.append("TO");
        }
        negativeOutliers = outliers.toString();
    }
    // generate z score by seeing how many standard deviations above or below the average player they are
    // find difference of each stat between given player and average player's, then figure out how many std devs away from average it is
    // add ability to ignore some categories when generating z score?
    // maybe pass in a string of categories to ignore, surround each calculation with if statement
    // if (!input.contains("X")), add z score of X to total
    public void generateZScore(DraftBoard board, String excludedCats){
        double zScoreCounter = 0;
        BoardAnalyzer.generateAveragePlayer(board);
        BoardAnalyzer.generateStandardDeviations(board);
        Player averagePlayer = BoardAnalyzer.getAveragePlayer();
        Player standardDeviations = BoardAnalyzer.getStandardDeviations();

        if (excludedCats.equals("none") || !excludedCats.contains("FG")) {
            double FGDiff = FGPercentage - averagePlayer.getFGPercentage();
            double FGPercentageZscore = FGDiff / standardDeviations.getFGPercentage();
            zScoreCounter = zScoreCounter + FGPercentageZscore;
        }

        if (excludedCats.equals("none") || !excludedCats.contains("FT")) {
            double FTDiff = FTPercentage - averagePlayer.getFTPercentage();
            double FTPercentageZscore = FTDiff / standardDeviations.getFTPercentage();
            zScoreCounter = zScoreCounter + FTPercentageZscore;
        }

        if (excludedCats.equals("none") || !excludedCats.contains("ThreePM")) {
            double ThreeDiff = threePM - averagePlayer.getThreePM();
            double threesZscore = ThreeDiff / standardDeviations.getThreePM();
            zScoreCounter = zScoreCounter + threesZscore;
        }

        if (excludedCats.equals("none") || !excludedCats.contains("PTS")) {
            double PTSDiff = PTS - averagePlayer.getPTS();
            double PTSZscore = PTSDiff / standardDeviations.getPTS();
            zScoreCounter = zScoreCounter + PTSZscore;
        }

        if (excludedCats.equals("none") || !excludedCats.contains("TREB")) {
            double REBDiff = TREB - averagePlayer.getTREB();
            double REBZscore = REBDiff / standardDeviations.getTREB();
            zScoreCounter = zScoreCounter + REBZscore;
        }

        if (excludedCats.equals("none") || !excludedCats.contains("AST")) {
            double ASTDiff = AST - averagePlayer.getAST();
            double ASTZscore = ASTDiff / standardDeviations.getAST();
            zScoreCounter = zScoreCounter + ASTZscore;
        }

        if(excludedCats.equals("none") || !excludedCats.contains("STL")) {
            double STLDiff = STL - averagePlayer.getSTL();
            double STLZscore = STLDiff / standardDeviations.getSTL();
            zScoreCounter = zScoreCounter + STLZscore;
        }

        if(excludedCats.equals("none") || !excludedCats.contains("BLK")) {
            double BLKDiff = BLK - averagePlayer.getBLK();
            double BLKZscore = BLKDiff / standardDeviations.getBLK();
            zScoreCounter = zScoreCounter + BLKZscore;
        }

        //subtracting from zscore here because TOs have negative value
        if(excludedCats.equals("none") || !excludedCats.contains("TO")) {
            double TODIff = TO - averagePlayer.getTO();
            double TOZscore = TODIff / standardDeviations.getTO();
            zScoreCounter = zScoreCounter - TOZscore;
        }

        zScore = zScoreCounter;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(double gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public double getFGPercentage() {
        return FGPercentage;
    }

    public void setFGPercentage(double FGPercentage) {
        this.FGPercentage = FGPercentage;
    }

    public double getFTPercentage() {
        return FTPercentage;
    }

    public void setFTPercentage(double FTPercentage) {
        this.FTPercentage = FTPercentage;
    }

    public double getThreePM() {
        return threePM;
    }

    public void setThreePM(double threePM) {
        this.threePM = threePM;
    }

    public double getPTS() {
        return PTS;
    }

    public void setPTS(double PTS) {
        this.PTS = PTS;
    }

    public double getTREB() {
        return TREB;
    }

    public void setTREB(double TREB) {
        this.TREB = TREB;
    }

    public double getAST() {
        return AST;
    }

    public void setAST(double AST) {
        this.AST = AST;
    }

    public double getSTL() {
        return STL;
    }

    public void setSTL(double STL) {
        this.STL = STL;
    }

    public double getBLK() {
        return BLK;
    }

    public void setBLK(double BLK) {
        this.BLK = BLK;
    }

    public double getTO() {
        return TO;
    }

    public void setTO(double TO) {
        this.TO = TO;
    }

    public double getHashtagScore() {
        return HashtagScore;
    }

    public void setHashtagScore(double hashtagScore) {
        HashtagScore = hashtagScore;
    }

    public String getPositiveOutliers() {
        return positiveOutliers;
    }

    public void setPositiveOutliers(String positiveOutliers) {
        this.positiveOutliers = positiveOutliers;
    }

    public String getNegativeOutliers() {
        return negativeOutliers;
    }

    public void setNegativeOutliers(String negativeOutliers) {
        this.negativeOutliers = negativeOutliers;
    }

    public void setFitsNeeds(int needsFit) { this.fitsNeeds = needsFit; }

    public int getFitsNeeds() { return fitsNeeds; }

    public double getAverageDraftPosition() {
        return averageDraftPosition;
    }

    public void setAverageDraftPosition(double averageDraftPosition) {
        this.averageDraftPosition = averageDraftPosition;
    }

    public void setFGAttemptedAndMade(double fgm, double fga){
        this.FGAttempted = fga;
        this.FGMade = fgm;
    }

    public void setFTAttemptedAndMade(double ftm, double fta){
        this.FTMade = ftm;
        this.FTAttempted = fta;
    }

    public double getFGAttempted() {
        return FGAttempted;
    }

    public double getFGMade() {
        return FGMade;
    }

    public double getFTAttempted() {
        return FTAttempted;
    }


    public double getFTMade() {
        return FTMade;
    }

    public double getzScore() {
        return zScore;
    }

    public void setzScore(double zScore) {
        this.zScore = zScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "positions='" + positions + '\'' +
                ", name=" + name +
                ", gamesPlayed=" + gamesPlayed +
                ", FGPercentage=" + FGPercentage +
                ", FTPercentage=" + FTPercentage +
                ", threePM=" + threePM +
                ", PTS=" + PTS +
                ", TREB=" + TREB +
                ", AST=" + AST +
                ", STL=" + STL +
                ", BLK=" + BLK +
                ", TO=" + TO +
                ", HashtagScore=" + HashtagScore +
                ", Average Draft Position= " + averageDraftPosition +
                ", positiveOutliers='" + positiveOutliers + '\'' +
                ", negativeOutliers='" + negativeOutliers + '\'' +
                '}';
    }

}

