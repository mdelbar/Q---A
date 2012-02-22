
package qanda;

import javax.swing.JDialog;
import javax.swing.JPasswordField;

/**
 * @author Matthias Delbar
 */

public class JPasswordDialog extends JDialog {

    public JPasswordDialog() {
        super();

        add(new JPasswordField());
    }
}
