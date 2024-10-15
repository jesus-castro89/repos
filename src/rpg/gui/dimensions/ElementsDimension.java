package rpg.gui.dimensions;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface ElementsDimension {

    // Márgenes
    int MARGIN = 5;
    // Bordes
    EmptyBorder EMPTY_BORDER = new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN);
    // Dimensiones
    Dimension MAIN_WINDOW_DIMENSION = new Dimension(1520, 900);
    Dimension TOP_PANEL_DIMENSION = new Dimension(MAIN_WINDOW_DIMENSION.width, 250);
    Dimension BAR_LABEL = new Dimension(172, 51);
}