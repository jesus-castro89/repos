package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class GameCharacter {

    protected String name;
    protected HashMap<Stats, Integer> stats;

    public GameCharacter(String name) {

        this.name = name;
        this.stats = new HashMap<>();
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(GameCharacter enemy) {
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
