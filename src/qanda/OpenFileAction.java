
package qanda;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vindicator
 */
public class OpenFileAction extends AbstractAction {

    private QandAModel QAmodel;

    public OpenFileAction(QandAModel model) {
        super("Open File...");
        QAmodel = model;
    }

    public void openFile() {
        FileDialog dialog = new FileDialog(new JFrame(), "Open File...", FileDialog.LOAD);
        dialog.setFilenameFilter(new QandAFilenameFilter());
        // NOODZAKELIJK! Anders krijgt de gebruiker geen dialoogvenster en is er een error
        dialog.setVisible(true);
        String filename = dialog.getDirectory() + dialog.getFile();
        if(dialog.getFile() != null) { // getFile() == null betektent dat de gebruiker Cancel klikte
            File f = new File(filename);
            try {
                QAmodel.clear();
                FileReader in = new FileReader(f);

                String line = "";
                int c = in.read();
                while(c != -1) {
                    if(c == '\n') {
                        String lineDecrypted = Cryptonite.decryptRotatingClearText(line);
                        if(lineDecrypted.contains("#")) {
                            String[] lineSplit = lineDecrypted.split("#");
                            QAmodel.addLeft(lineSplit[0].trim());
                            QAmodel.addRight(lineSplit[1].trim());
                        }
                        line = "";
                    }
                    else
                        line += (char) c;
                    c = in.read();
                }
                in.close();

                QAmodel.fireStateChanged();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error while loading file. Please try again");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        int keepLTR;
        if(QAmodel.isLTR()) {
            keepLTR = JOptionPane.showConfirmDialog(null,
                   "Current direction is Left To Right!\nKeep this direction?");
        }
        else {
            keepLTR = JOptionPane.showConfirmDialog(null,
                   "Current direction is Right To Left!\nKeep this direction?");
        }
        
        switch (keepLTR) {
            case JOptionPane.NO_OPTION:
                QAmodel.changeDirection();
                openFile();
                break;
            case JOptionPane.YES_OPTION:
                openFile();
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
        }
    }
}
