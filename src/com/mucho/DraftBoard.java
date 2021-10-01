package com.mucho;

import java.util.ArrayList;

public class DraftBoard {
    /*
    maintains list of all Players still remaining in draft
    sorts players based on BPA, as well as by whatever criteria the user is looking for (i.e. sorted by impact in each category)
    list is ArrayList(?) of Player objects
    has position quotas (set by user)
    tracks player/position scarcity
    test for git
     */

    private ArrayList<Player> overallBoard;
    private ArrayList<Player> PGBoard;
    private ArrayList<Player> SGBoard;
    private ArrayList<Player> SFBoard;
    private ArrayList<Player> PFBoard;
    private ArrayList<Player> CBoard;
}
