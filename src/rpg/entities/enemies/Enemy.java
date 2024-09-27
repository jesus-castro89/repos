package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;

public abstract class Enemy extends GameCharacter {

    protected EnemyType type;

    public Enemy(String name) {
        super(name);
    }

    /**
     * Función que permite recuperar el botín del enemigo.
     */
    public abstract void getLoot();

    public abstract void attack(GameCharacter enemy);

    public EnemyType getType() {
        return type;
    }
}