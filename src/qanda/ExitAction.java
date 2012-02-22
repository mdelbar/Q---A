
package qanda;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author Vindicator
 */
public class ExitAction extends AbstractAction {
    private QandAModel QAmodel;

    public ExitAction(QandAModel QAmodel) {
        super("Exit");
        this.QAmodel = QAmodel;
    }

    public void actionPerformed(ActionEvent e) {
        if(QAmodel.isEveryAnswerCorrect() || QAmodel.isEmpty())
            System.exit(0);
        else {
            // TODO: MAKE OWN DIALOG FOR THIS, PASSWORD PROTECTION (Dots instead of letters)
            String password = JOptionPane.showInputDialog("Please enter the exit password");
            if(password.equals("the exit password"))
                System.exit(0);
            else
                JOptionPane.showMessageDialog(null, "Nice try, kiddo.\n" +
                        "You need to answer everything correctly before you can escape.");
        }
    }
}
