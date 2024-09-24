package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.Stats;

public class Enemy extends GameCharacter {

    public Enemy() {
        super("Enemy");
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 4);
    }
}