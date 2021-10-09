package com.mucho;

import java.util.ArrayList;

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
}
