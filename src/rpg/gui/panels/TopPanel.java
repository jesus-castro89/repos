package rpg.gui.panels;

import rpg.gui.WindowConstants;

public class TopPanel extends BackgroundPanel {

    public TopPanel() {
        super("panels/statusPanel.png");
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}
