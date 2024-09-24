package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.entities.enemies.slimes.BasicSlime;

public class Game {

    private Player player;
    private Enemy enemy;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public Game() {
        this.player = new Player("Player");
        int enemyType = (int) (Math.random() * 3) + 1;
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime();
            default -> new Enemy();
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
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }
    }
}
