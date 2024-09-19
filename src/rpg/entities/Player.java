package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Player extends GameCharacter {

    public Player(String name) {
        super(name);
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }
}
