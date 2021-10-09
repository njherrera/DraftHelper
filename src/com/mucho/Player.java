package com.mucho;

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
    private double FTPercentage;
    private double threePM;
    private double PTS;
    private double TREB;
    private double AST;
    private double STL;
    private double BLK;
    private double TO;
    private double HashtagScore;
    private String positiveOutliers;
    private String negativeOutliers; // should this only count FG%/FT%/TO, i.e. categories where a player can actively hurt you?

    public Player(String pos, String playerName, double gp, double fg, double ft, double threes, double points,
                  double reb, double assists, double steals, double blocks, double turnovers, double htscore) {
        this.positions = pos;
        this.name = playerName;
        this.gamesPlayed = gp;
        this.FGPercentage = fg;
        this.FTPercentage = ft;
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

    public void generateGPFlag(Player trueAverage, Player averagePositional, double standardDeviation){
        // compare this player's games played to the average player's games played
    }

    public void generateFGFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generateFTFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generate3PMFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generatePtsFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generateRebFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generateAstFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generateStlFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generateBlkFlag(Player trueAverage, Player averagePositional, double standardDeviation){

    }

    public void generateTOFlag(Player trueAverage, Player averagePositional, double standardDeviation){

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
                ", positiveOutliers='" + positiveOutliers + '\'' +
                ", negativeOutliers='" + negativeOutliers + '\'' +
                '}';
    }
}

