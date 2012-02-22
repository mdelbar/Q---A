
package qanda;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * @author Matthias Delbar
 */
public class CreateFrame extends JFrame {

    public CreateFrame() {
        super("Untitled*");

        CreateModel CModel = new CreateModel();
        CreatePanel CPanel = new CreatePanel(this);

        setJMenuBar(new CreateMenuBar(CPanel));

        setMaximumSize(new Dimension(600, 200));
        setMinimumSize(new Dimension(200, 200));
        setContentPane(new JScrollPane(CPanel));

        setLocation(new Point(350,150));
        pack();
        
        // TODO: ADD WINDOWLISTENER HERE (check if saved)!!! See Musique for more info
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
