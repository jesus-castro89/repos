package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

/**
 * Clase que representa a un personaje del juego.
 */
public abstract class GameCharacter {
    /**
     * Nombre del personaje.
     */
    protected String name;
    /**
     * Características del personaje.
     */
    protected HashMap<Stats, Integer> stats;

    /**
     * Instantiates a new Game character.
     *
     * @param name the name
     */
    public GameCharacter(String name) {

        this.name = name;
        this.stats = new HashMap<>();
        initCharacter();
    }

    /**
     * Función que inicializa las características del personaje.
     * Implementada por las clases hijas.
     * Deberá de incluir el nombre del personaje y las características mínimas para su funcionamiento.
     */
    protected abstract void initCharacter();

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Función que simula un ataque del personaje al enemigo e imprime un mensaje
     * en consola con el resultado del ataque. Si el daño es mayor a 0, se resta
     * la cantidad de daño a la vida del enemigo. Si el daño es menor o igual a 0,
     * se imprime un mensaje indicando que no se hizo daño.
     *
     * @param enemy el enemigo a atacar.
     */
    public void attack(GameCharacter enemy) {

        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);
        if (damage > 0) {

            newHP = enemy.getStats().get(Stats.HP) - damage;
            enemy.getStats().put(Stats.HP, newHP);
            message += String.format("""
                    %s attacks %s for %d damage!
                    %s has %d HP left.
                    """, this.name, enemyName, damage, enemyName, newHP);
        } else {
            message += String.format("""
                    %s attacks %s but does no damage!
                    %s has %d HP left.
                    """, this.name, enemyName, enemyName, newHP);
        }
        System.out.println(message);
    }

    /**
     * Función que reduce la vida del enemigo y actualiza sus características.
     *
     * @param enemy  el enemigo a atacar.
     * @param damage el daño a realizar.
     * @return la nueva vida del enemigo.
     */
    protected int reduceHP(GameCharacter enemy, int damage) {

        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        return newHP;
    }

    /**
     * Devuelve el nombre del personaje con un epíteto.
     *
     * @return el nombre del personaje con el epíteto.
     */
    public String getName() {
        return String.format("%s", name);
    }

    /**
     * Gets stats.
     *
     * @return the stats
     */
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
