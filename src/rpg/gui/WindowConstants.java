package rpg.gui;

import rpg.utils.cache.FontCache;

import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Constantes para las dimensiones de las ventanas.
 */
public interface WindowConstants {
    Font FONT = FontCache.addFont("PIXM", "fonts/PixeloidMono.otf");
    /**
     * Ancho de la ventana.
     */
    int WINDOW_WIDTH = 1500;
    /**
     * Alto de la parte superior de la ventana.
     */
    int TOP_HEIGHT = 150;
    /**
     * Alto de la parte media de la ventana.
     */
    int MIDDLE_HEIGHT = 320;
    /**
     * Alto de la parte inferior de la ventana.
     */
    int BOTTOM_HEIGHT = 350;
    /**
     * Margen simple.
     */
    int SIMPLE_MARGIN = 18;
    int CORNER_WIDTH = 52;
    int CORNER_HEIGHT = 77;
    int CENTER_WIDTH = 350 - 2 * CORNER_WIDTH;
    /**
     * Dimensión de la parte superior de la ventana.
     */
    Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);
    /**
     * Dimensión de la parte media de la ventana.
     */
    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
    /**
     * Dimensión de la parte inferior de la ventana.
     */
    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
    Dimension CORNER_DIMENSION = new Dimension(52, 77);
    Dimension CENTER_DIMENSION = new Dimension(CENTER_WIDTH, 77);
    /**
     * Borde vacío de margen simple. Que se puede usar para dar un margen a los paneles.
     */
    EmptyBorder EMPTY_BORDER = new EmptyBorder(SIMPLE_MARGIN, SIMPLE_MARGIN,
            SIMPLE_MARGIN, SIMPLE_MARGIN);
}
