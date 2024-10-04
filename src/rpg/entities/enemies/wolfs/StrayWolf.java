package rpg.entities.enemies.wolfs;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;

/**
 * The type Stray wolf.
 */
public class StrayWolf extends Enemy {

    /**
     * Instantiates a new Stray wolf.
     */
    public StrayWolf() {
        super("Stray Wolf");
    }

    @Override
    public void getLoot() {
        System.out.println("The Stray Wolf drops a valuable wolf pelt.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 2);
    }

    /**
     * Bite.
     *
     * @param enemy the enemy
     */
    protected void bite(GameCharacter enemy) {
        int damage = 4;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " bites " + enemy.getName() + " for " + damage + " damage!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    /**
     * Claw.
     *
     * @param enemy the enemy
     */
    protected void claw(GameCharacter enemy) {
        int damage = 3;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " claws " + enemy.getName() + " for "
                + damage + " damage!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    /**
     * Slash.
     *
     * @param enemy the enemy
     */
    protected void slash(GameCharacter enemy) {
        int damage = 5;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " slashes " + enemy.getName() + " for "
                + damage + " damage!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    @Override
    public void attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 3);
        switch (attack) {
            case 1:
                bite(enemy);
                break;
            case 2:
                claw(enemy);
                break;
            default:
                slash(enemy);
                break;
        }
    }
}
