package rpg.gui.buttons;

import rpg.gui.buttons.events.NewFileEvent;
import rpg.gui.windows.NewFileWindow;
import rpg.gui.windows.StartWindow;

public class CreateButton extends UserButton {

    public CreateButton(int slot, NewFileWindow window) {

        super("¡A la aventura!");
        addActionListener(new NewFileEvent(slot, window));
    }
}
