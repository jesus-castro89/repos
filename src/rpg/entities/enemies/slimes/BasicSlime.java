package rpg.entities.enemies.slimes;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;

import javax.swing.*;

/**
 * The type Basic slime.
 */
public class BasicSlime extends Enemy {

    /**
     * Instantiates a new Basic slime.
     */
    public BasicSlime() {
        super("Basic Slime");
    }

    @Override
    public void getLoot() {
        System.out.println("The Basic Slime drops a bottle of slime.");
    }

    /**
     * Función sobrescrita que inicializa las características del Slime.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 20);
        this.stats.put(Stats.HP, 20);
        this.stats.put(Stats.ATTACK, 4);
        this.stats.put(Stats.DEFENSE, 1);
    }

    /**
     * Función de ataque de salpicadura. Este ataque no hace daño.
     *
     * @param enemy el enemigo a atacar. Que en este caso no recibe daño y es el jugador.
     */
    protected void splash(GameCharacter enemy) {
        // Recuperamos el nombre del enemigo.
        String enemyName = enemy.getName();
        // Calculamos la vida del enemigo después del ataque. El daño es 0 en este caso.
        int newHP = enemy.getStats().get(Stats.HP);
        System.out.printf("""
                %s splashes %s and does nothing.
                %s has %d HP left.
                """, this.name, enemyName, enemyName, newHP);
    }

    /**
     * Función de ataque de lanzamiento de lodo. Este ataque hace un 80% del daño de ataque.
     *
     * @param enemy el enemigo a atacar.
     */
    protected void trhowSlime(GameCharacter enemy) throws EnemyDeathException {

        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) * 8 / 10;
        int newHP = reduceHP(enemy, this.stats.get(Stats.ATTACK) * 8 / 10);
        System.out.printf("""
                %s throws slime at %s for %d damage!
                %s has %d HP left.
                """, this.name, enemyName, damage, enemyName, newHP);
    }

    /**
     * Función de ataque del enemigo. El enemigo tiene un 50% de probabilidad de hacer un ataque de salpicadura
     * y un 50% de probabilidad de hacer un ataque de lanzamiento de lodo.
     *
     * @param enemy el enemigo a atacar.
     */
    @Override
    public void attack(GameCharacter enemy) {

        if (Randomize.getRandomBoolean()) splash(enemy);
        else {
            try {
                trhowSlime(enemy);
            } catch (EnemyDeathException e) {
                enemy.getStats().put(Stats.HP, 0);
                System.out.printf("""
                        %s throws slime at you for %d damage!
                        You have 0 HP left.
                        You have died.
                        """, this.name, (this.stats.get(Stats.ATTACK) * 8 / 10));
            }
        }
    }

    @Override
    public ImageIcon getSprite() {
        return new ImageIcon("src/rpg/assets/sprites/enemies/slimes/basicSlime.png");
    }
}
