package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Player {

    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    /**
     * Verifica si el jugador está vivo.
     *
     * @return true si el jugador está vivo, false en caso contrario.
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Recepción de daño.
     *
     * @param damage daño recibido.
     */
    public void receiveDamage(int damage) {

        int defense = stats.get(Stats.DEFENSE);
        int finalDamage = damage - defense;
        int hp = stats.get(Stats.HP);
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        hp -= finalDamage;
        if (hp < 0) {
            hp = 0;
        }
        stats.put(Stats.HP, hp);
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
