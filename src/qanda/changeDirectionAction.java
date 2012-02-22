/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qanda;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Vindicator
 */
public class changeDirectionAction extends AbstractAction {

    private QandAModel QAmodel;

    public changeDirectionAction(QandAModel QAmodel) {
        super("Change direction");
        this.QAmodel = QAmodel;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        QAmodel.changeDirection();
    }
}
