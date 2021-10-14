package com.mucho;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {


    @Override
    public int compare(Player x, Player y) {
        return y.getFitsNeeds() - x.getFitsNeeds();
    }
}
