package rpg.entities.enemies.bears;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

/**
 * The type Wood bear.
 */
public class WoodBear extends Enemy {

    /**
     * Instantiates a new Wood bear.
     */
    public WoodBear() {
        super("Wood Bear");
        ImageCache.addImage("wood_bear", "enemies/MountainScarbear.png");
    }

    @Override
    public void getLoot() {
        System.out.println("The Wood Bear drops a valuable bear claw.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 8);
        this.stats.put(Stats.DEFENSE, 4);
    }

    @Override
    public String attack(GameCharacter enemy) {

        String message = "";
        int attack = Randomize.getRandomInt(1, 3);
        message = switch (attack) {
            case 1 -> claw(enemy);
            case 2 -> bite(enemy);
            default -> ((GameCharacter) this).attack(enemy);
        };
        return message;
    }

    /**
     * Bite.
     *
     * @param enemy the enemy
     */
    protected String bite(GameCharacter enemy) {

        int damage = 5;
        String message = "";
        String enemyName = enemy.getName();
        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        message += String.format("""
                %s bites %s for %d damage!
                %s has %d HP left.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    /**
     * Claw.
     *
     * @param enemy the enemy
     */
    protected String claw(GameCharacter enemy) {

        int damage = 4;
        String message = "";
        String enemyName = enemy.getName();
        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        message += String.format("""
                %s claws %s for %d damage!
                %s has %d HP left.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("wood_bear");
    }
}
