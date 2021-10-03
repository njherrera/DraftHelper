package com.mucho;

public class Player {
    /* draft board is composed of these
    HAS AN array of projected/actual stats
    HAS A position
    HAS some way of designating elite/poor stats
    starting format is 9 cat roto
    */

    private String positions;
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

    public Player(String pos, double gp, double fg, double ft, double threes, double points,
                  double reb, double assists, double steals, double blocks, double turnovers, double htscore) {
        this.positions = pos;
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

