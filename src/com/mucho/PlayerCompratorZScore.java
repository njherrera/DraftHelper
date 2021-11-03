package com.mucho;

import java.util.Comparator;

public class PlayerCompratorZScore implements Comparator<Player> {

    public int compare(Player x, Player y){
        return Double.compare(x.getzScore(), y.getzScore());
    }
}
