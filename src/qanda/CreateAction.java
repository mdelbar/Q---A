
package qanda;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * @author Matthias Delbar
 */
public class CreateAction extends AbstractAction {

    public CreateAction() {
        super("Create New File");
    }

    public void actionPerformed(ActionEvent e) {
        new CreateFrame();
    }
}
