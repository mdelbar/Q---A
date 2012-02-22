
package qanda;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Matthias Delbar
 */

public class SaveFileAction extends AbstractAction {
    private CreateModel model;

    public SaveFileAction(CreatePanel panel) {
        super("Save");
        model = panel.getModel();
    }

    public void actionPerformed(ActionEvent e) {
        String filename = "", path = "";
        if(!model.isFilenameSet()) {
            FileDialog dialog = new FileDialog(new JFrame(), "Save File...", FileDialog.SAVE);
            dialog.setFilenameFilter(new QandAFilenameFilter());
            // NOODZAKELIJK! Anders krijgt de gebruiker geen popupvenster en volgt er een error
            dialog.setVisible(true);
            path = dialog.getDirectory();
            filename = dialog.getFile();
//            filename = dialog.getDirectory() + dialog.getFile();
            if(filename != null && !filename.endsWith(".qanda")) {
                filename += ".qanda";
            }
            model.setFilename(filename);
        }
        else {
            filename = model.getFilename();
        }

        // Een check voor filename.isEmpty() is niet nodig omdat FileDialog zelf al
        // die voorwaarde inlast
        if(filename != null && !filename.isEmpty()) {
            try {
                FileWriter output = new FileWriter(path + filename);

                // Start at 2 because the first 2 are JLabel
                // End at count - 1 because the last is JButton
                for(int i = 0; i < model.getLeft().size(); i ++) {
                    String left = ((JTextField) model.getLeft().get(i)).getText();
                    String right = ((JTextField) model.getRight().get(i)).getText();

                    String line = Cryptonite.encryptRotatingClearText(left + " # " + right);
                    line += "\n";

                    output.write(line);
                }
                output.flush();
                output.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error during saving. Please try again.");
            }
        }
    }
}
