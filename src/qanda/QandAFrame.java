
package qanda;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Vindicator
 */
public class QandAFrame extends JFrame {

    private QandAModel QAmodel;
    
    public QandAFrame() {
        super("Question and Answer");
        
        QAmodel = new QandAModel();

        setJMenuBar(new QandAMenuBar(QAmodel));
        
        setMaximumSize(new Dimension(600, 200));
        setContentPane(new JScrollPane(new QandAPanel(QAmodel)));

        setLocation(new Point(300,100));
        pack();
        
        // TODO: GET THIS MAN A WINDOW LISTENER (check if everything is filled in, before tha exit)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
