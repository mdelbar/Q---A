
package qanda;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * @author Matthias Delbar
 */

public class AddAction extends AbstractAction {
    private CreatePanel panel;

    public AddAction(CreatePanel CPanel) {
        super(" + ");
        panel = CPanel;
    }

    public void actionPerformed(ActionEvent e) {
        panel.addNewLine();
    }
}
