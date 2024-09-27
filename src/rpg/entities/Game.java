package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.entities.enemies.slimes.BasicSlime;
import rpg.utils.Randomize;

public class Game {

    private Player player;
    private Enemy enemy;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public Game() {
        this.player = new Player("Player");
        int enemyType = Randomize.getRandomInt(1, 3);
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            default -> new BasicSlime();
        };
    }

    public void startGame() {

        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        if (player.isAlive()) {

            enemy.getLoot();
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }
    }
}
