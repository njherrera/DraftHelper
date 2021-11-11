package com.mucho;

import java.util.Comparator;

public class zScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player x, Player y) {
        return (int)Math.round(y.getzScore() - x.getzScore());
    }
}
