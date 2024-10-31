package rpg.entities.enemies.wolfs;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;

import javax.swing.*;

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
    protected String bite(GameCharacter enemy) {
        int damage = 4;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        return String.format("""
                        %s bites %s for %d damage!
                        %s has %d HP left.
                        """, this.name, enemy.getName(), damage,
                enemy.getName(), enemy.getStats().get(Stats.HP));
    }

    /**
     * Claw.
     *
     * @param enemy the enemy
     */
    protected String claw(GameCharacter enemy) {
        int damage = 3;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        return String.format("""
                        %s claws %s for %d damage!
                        %s has %d HP left.
                        """, this.name, enemy.getName(), damage,
                enemy.getName(), enemy.getStats().get(Stats.HP));
    }

    /**
     * Slash.
     *
     * @param enemy the enemy
     */
    protected String slash(GameCharacter enemy) {
        int damage = 5;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        return String.format("""
                        %s slashes %s for %d damage!
                        %s has %d HP left.
                        """, this.name, enemy.getName(), damage,
                enemy.getName(), enemy.getStats().get(Stats.HP));
    }

    @Override
    public String attack(GameCharacter enemy) {

        String message = "";
        int attack = Randomize.getRandomInt(1, 3);
        message = switch (attack) {
            case 1 -> bite(enemy);
            case 2 -> claw(enemy);
            default -> slash(enemy);
        };
        return message;
    }

    @Override
    public ImageIcon getSprite() {
        return new ImageIcon("src/rpg/assets/enemies/wolfs/strayWolf.png");
    }
}
