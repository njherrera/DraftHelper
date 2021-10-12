package com.mucho;

import java.util.ArrayList;
import java.util.HashMap;

public class Team {

    private ArrayList<Player> teamRoster;
    private int PGQuota; // a "quota" is the amount of players of a specific position that you must have on your roster (some leagues don't have one)
    private int SGQuota;
    private int SFQuota;
    private int PFQuota;
    private int CQuota;
    private int rosterSpots;
    private double[] totalStats = new double[9];
    private double[] perGameStats = new double[9];
    private double[] benchmarkStats = new double[9]; // holds the "benchmarks" to reach (what it takes to win each category)
    private boolean needsFG; // needs___ are the flags that will be used if a team needs good/elite production in a category
    private boolean needsFT; // i.e. if a team is sorely lacking in assists, then needsAST would be marked true
    private boolean needsThrees;
    private boolean needsPTS;
    private boolean needsREB;
    private boolean needsAST;
    private boolean needsSTL;
    private boolean needsBLK;
    private boolean needsLessTOs;

    public Team(int spots){
        teamRoster = new ArrayList<Player>();
        rosterSpots = spots;
    }

    public Team(int pgQuota, int sgQuota, int sfQuota, int pfQuota, int cQuota, int spots){
        teamRoster = new ArrayList<Player>();
        PGQuota = pgQuota;
        SGQuota = sgQuota;
        SFQuota = sfQuota;
        PFQuota = pfQuota;
        CQuota = cQuota;
        rosterSpots = spots;
    }

    public void setBenchmarkStats(double FGPercentage, double FTPercentage, double threes, double points, double rebounds, double assists, double steals, double blocks, double turnovers){
        benchmarkStats[0] = FGPercentage;
        benchmarkStats[1] = FTPercentage;
        benchmarkStats[2] =  threes;
        benchmarkStats[3] = points;
        benchmarkStats[4] = rebounds;
        benchmarkStats[5] = assists;
        benchmarkStats[6] = steals;
        benchmarkStats[7] = blocks;
        benchmarkStats[8] = turnovers;
    }

    public void addPlayer(Player addedPlayer){
        teamRoster.add(addedPlayer);
        totalStats[0] += addedPlayer.getFGPercentage();
        totalStats[1] += addedPlayer.getFTPercentage();
        totalStats[2] += addedPlayer.getThreePM();
        totalStats[3] += addedPlayer.getPTS();
        totalStats[4] += addedPlayer.getTREB();
        totalStats[5] += addedPlayer.getAST();
        totalStats[6] += addedPlayer.getSTL();
        totalStats[7] += addedPlayer.getBLK();
        totalStats[8] += addedPlayer.getTO();
        for (int i = 0; i < totalStats.length; i++) {
            perGameStats[i] = totalStats[i] / teamRoster.size();
        }
    }

    // determine how far away from benchmarks for success a team is
    public void analyzeTeam(DraftBoard board){
        double neededFG = this.benchmarkStats[0] - this.totalStats[0];
        double neededFT = this.benchmarkStats[1] - this.totalStats[1];
        double neededThrees = this.benchmarkStats[2] - this.totalStats[2];
        double neededPTS = this.benchmarkStats[3] - this.totalStats[3];
        double neededREB = this.benchmarkStats[4] - this.totalStats[4];
        double neededAST = this.benchmarkStats[5] - this.totalStats[5];
        double neededSTL = this.benchmarkStats[6] - this.totalStats[6];
        double neededBLK = this.benchmarkStats[7] - this.totalStats[7];
        double remainingTO = this.benchmarkStats[8] - this.totalStats[8];

        BoardAnalyzer.generateAveragePlayer(board);
        Player averagePlayer = BoardAnalyzer.getAveragePlayer();
        BoardAnalyzer.generateStandardDeviations(board);
        Player standardDeviations = BoardAnalyzer.getStandardDeviations();
        // determine whether you need good average production in FG percentage from the rest of your picks ("good" is defined as more than one standard deviation above normal)
        if ((neededFG / (this.rosterSpots - teamRoster.size())) > averagePlayer.getFGPercentage() + standardDeviations.getFGPercentage()){
            this.needsFG = true;
        }
        if ((neededFT / (this.rosterSpots - teamRoster.size())) > averagePlayer.getFTPercentage() + standardDeviations.getFTPercentage()){
            this.needsFT = true;
        }
        if ((neededThrees / (this.rosterSpots - teamRoster.size())) > averagePlayer.getThreePM() + standardDeviations.getThreePM()){
            this.needsThrees = true;
        }
        if ((neededPTS / (this.rosterSpots - teamRoster.size())) > averagePlayer.getPTS() + standardDeviations.getPTS()){
            this.needsPTS = true;
        }
        if ((neededREB / (this.rosterSpots - teamRoster.size())) > averagePlayer.getTREB() + standardDeviations.getTREB()){
            this.needsREB = true;
        }
        if ((neededAST / (this.rosterSpots - teamRoster.size())) > averagePlayer.getAST() + standardDeviations.getAST()){
            this.needsAST = true;
        }
        if ((neededSTL / (this.rosterSpots - teamRoster.size())) > averagePlayer.getSTL() + standardDeviations.getSTL()){
            this.needsSTL = true;
        }
        if ((neededBLK / (this.rosterSpots - teamRoster.size())) > averagePlayer.getBLK() + standardDeviations.getBLK()){
            this.needsBLK = true;
        }
        if ((remainingTO / (this.rosterSpots - teamRoster.size())) < averagePlayer.getTO() - standardDeviations.getTO()){
            this.needsLessTOs = true;
        }
    }

    public Player recommendAPlayer(DraftBoard board){
        HashMap<Player, Integer> recommendations = new HashMap<Player, Integer>(    );
        if (this.needsFG == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("FG")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsFT == true){

        }
        if (this.needsThrees == true){

        }
        if (this.needsPTS == true){

        }
        if (this.needsREB == true){

        }
        if (this.needsAST == true){

        }
        if (this.needsSTL == true){

        }
        if (this.needsLessTOs == true){

        }
    }

    public Player recommendAPG(){

    }

    public Player recommendASG(){

    }

    public Player recommendASF(){

    }

    public Player recommendAPF(){

    }

    public Player recommendAC(){

    }
}
