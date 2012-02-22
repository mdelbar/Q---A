
package qanda;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author Matthias Delbar
 */
public class CreateMenuBar extends JMenuBar {

    public CreateMenuBar(CreatePanel panel) {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem save = new JMenuItem("Save");
        save.setAction(new SaveFileAction(panel));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        save.setMnemonic(KeyEvent.VK_S);

        file.add(save);
        add(file);
    }
}
