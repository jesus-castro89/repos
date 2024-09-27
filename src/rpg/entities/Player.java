package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Player extends GameCharacter {

    public Player(String name) {
        super(name);
    }

    /**
     * Función sobrescrita que inicializa las características
     * del personaje.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }
}
