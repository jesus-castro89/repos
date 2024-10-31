package rpg.entities.enemies;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import rpg.enums.EnemyType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EnemyFactory {

    private static final Random random = new Random();

    public static Enemy getEnemy() {

        Enemy enemyInstance;
        Enemy enemy;
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));
        Set<Class<? extends Enemy>> enemyClasses = reflections.getSubTypesOf(Enemy.class);
        List<Class<? extends Enemy>> classList = filterList(enemyClasses.stream().toList(), EnemyType.BASIC);
        // Obtiene una clase aleatoria de la lista
        int randomIndex = random.nextInt(classList.size());
        try {
            enemyInstance = classList.get(randomIndex).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return enemyInstance;
    }

    private static List filterList(List<Class<? extends Enemy>> classList, EnemyType enemyType) {
        Enemy enemy;
        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>();
        for (Class<? extends Enemy> enemyClass : classList) {

            try {
                enemy = enemyClass.getDeclaredConstructor().newInstance();
                if (enemy.getType() == enemyType) {
                    classListFiltered.add(enemyClass);
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return classListFiltered;
    }
}
