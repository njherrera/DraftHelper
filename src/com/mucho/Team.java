package com.mucho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    public ArrayList<Player> recommendAPlayer(DraftBoard board){
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
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("FT")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsThrees == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("3PM")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsPTS == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("PTS")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsREB == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("REB")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsAST == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("AST")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsSTL == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("STL")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsBLK == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("BLK")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        if (this.needsLessTOs == true){
            for(Player plyr : board.getOverallBoard()){
                if (plyr.getPositiveOutliers().contains("TO")){
                    Integer count = recommendations.get(plyr);
                    if (count == null){
                        recommendations.put(plyr, 1);
                    } else {
                        recommendations.put(plyr, count +1);
                    }
                }
            }
        }
        return convertRecommendationsToList(recommendations);
    }

    public ArrayList<Player> convertRecommendationsToList(HashMap<Player, Integer> recommendations){
        ArrayList<Player> listOfRecommendations = new ArrayList<Player>();
        for (Map.Entry<Player, Integer> entry : recommendations.entrySet()) {
            entry.getKey().setFitsNeeds(entry.getValue());
            listOfRecommendations.add(entry.getKey());
        }
        Collections.sort(listOfRecommendations, new PlayerComparator());
        ArrayList<Player> topPlayers = new ArrayList<Player>();
        int counter = 0;
        while (counter < 5 && listOfRecommendations.get(counter) != null){
            topPlayers.add(listOfRecommendations.get(counter));
            counter++;
        }
        return topPlayers;
    }
    /*public Player recommendAPG(){

    }

    public Player recommendASG(){

    }

    public Player recommendASF(){

    }

    public Player recommendAPF(){

    }

    public Player recommendAC(){

    }*/

    public ArrayList<Player> getTeamRoster() {
        return teamRoster;
    }

    public void setTeamRoster(ArrayList<Player> teamRoster) {
        this.teamRoster = teamRoster;
    }
}
