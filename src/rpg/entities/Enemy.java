package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Enemy extends GameCharacter {

    public Enemy(String name) {
        super(name);
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 4);
    }
}