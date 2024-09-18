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

    public void attack(Enemy enemy) {
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage!");
            System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
        } else {
            System.out.println(this.name + " attacks " + enemy.getName() + " but does no damage!");
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
