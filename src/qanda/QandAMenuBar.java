
package qanda;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Vindicator
 */
public class QandAMenuBar extends JMenuBar {

    public QandAMenuBar(QandAModel QAmodel) {
        JMenu file = new JMenu("File");

        JMenuItem openFile = new JMenuItem();
        openFile.setAction(new OpenFileAction(QAmodel));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                        InputEvent.CTRL_DOWN_MASK)); // Ctrl + O
        file.add(openFile);

        JMenuItem addFile = new JMenuItem();
        addFile.setAction(new AddFileAction(QAmodel));
        addFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                                        InputEvent.CTRL_DOWN_MASK)); // Ctrl + A
        file.add(addFile);

        JMenuItem create = new JMenuItem("Create New File");
        create.setAction(new CreateAction());
        create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                                        InputEvent.CTRL_DOWN_MASK)); // Ctrl + N
        file.add(create);

        file.addSeparator();

        JMenuItem exit = new JMenuItem();
        exit.setAction(new ExitAction(QAmodel));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,
                                        InputEvent.SHIFT_DOWN_MASK));  // Shift + Escape
        file.add(exit);

        
        add(file);


//        JMenu view = new JMenu("View");
//        JMenuItem change = new JMenuItem();
//
//        changeDirectionAction changeAction = new changeDirectionAction(QAmodel);
//        change.setAction(changeAction);
//
//        change.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
//                                        InputEvent.CTRL_DOWN_MASK)); // Ctrl + C
//
//        view.add(change);
//        add(view);
    }
}
