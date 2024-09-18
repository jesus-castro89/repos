package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Enemy {

    private String name;
    private HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 9);
        this.stats.put(Stats.DEFENSE, 5);
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(Player player) {
        int damage = this.stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " attacks " + player.getName() + " for " + damage + " damage!");
            System.out.println(player.getName() + " has " + player.getStats().get(Stats.HP) + " HP left.");
        } else {
            System.out.println(this.name + " attacks " + player.getName() + " but does no damage!");
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
