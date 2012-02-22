
package qanda;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Vindicator
 */
public class QandAPanel extends JPanel implements ChangeListener {

    private QandAModel QAmodel;

    public QandAPanel(QandAModel model) {
        super();
        QAmodel = model;
        QAmodel.addChangeListener(this);
    }

    public void stateChanged(ChangeEvent e) {
        removeAll();
        setLayout(new GridBagLayout());

        fillPanel();

        resizeParentFrame();
    }

    public void resizeParentFrame() {
        // Resize parent frame. Parents are in order:
//         ViewPort | JScrollPane | LayeredPane | RootPane | JFrame
        JFrame par = (JFrame) getParent().getParent().getParent().getParent().getParent();
        par.pack();
        if(par.getHeight() > 600)
            par.setSize(new Dimension(par.getWidth() + 25, 600));
    }

    public void fillPanel() {
        GridBagConstraints gbcLeft = new GridBagConstraints();
        GridBagConstraints gbcRight = new GridBagConstraints();
        GridBagConstraints gbcCheckAnswers = new GridBagConstraints();

        gbcLeft.gridx = 0;
        gbcRight.gridx = 2;
        gbcLeft.gridheight = 1;
        gbcRight.gridheight = 1;
        if(QAmodel.isLTR()) {
            gbcLeft.gridwidth = 1;
            gbcRight.gridwidth = 2;
        }
        else {
            gbcLeft.gridwidth = 2;
            gbcRight.gridwidth = 1;
        }
        gbcLeft.gridy = 0;
        gbcRight.gridy = 0;
        gbcCheckAnswers.gridy = 0;
        gbcLeft.insets = new Insets(3,5,3,5);
        gbcRight.insets = new Insets(3,5,3,5);
        gbcLeft.anchor = GridBagConstraints.WEST;
        gbcRight.anchor = GridBagConstraints.EAST;

        ArrayList<String> QAleft = QAmodel.getWordsLeft();
        ArrayList<String> QAright = QAmodel.getWordsRight();

        for(int i = 0; i < QAleft.size(); i++) {
            if(QAmodel.isLTR()) {
//                add(new JLabel(QAleft.get(i)), gbcLeft);
                JLabel l = new JLabel(QAleft.get(i));
                add(l, gbcLeft);
                // TODO: Still having errors!!! When Open > Check > Add > Check
                QAmodel.addLabel(l);
                
                JTextField tf = new JTextField(20);
                add(tf, gbcRight);
                QAmodel.addTextField(tf);
            }
            else {
                JTextField tf = new JTextField(20);
                add(tf, gbcLeft);
                QAmodel.addTextField(tf);

//                add(new JLabel(QAright.get(i)), gbcRight);
                JLabel l = new JLabel(QAright.get(i));
                add(l, gbcRight);
                QAmodel.addLabel(l);
            }
            
            gbcLeft.gridy++;
            gbcRight.gridy++;
            gbcCheckAnswers.gridy++;
        }

        gbcCheckAnswers.gridx = 0;
        gbcCheckAnswers.gridheight = 1;
        gbcCheckAnswers.gridwidth = 3;
        gbcCheckAnswers.insets = new Insets(5,5,2,5);
        gbcCheckAnswers.anchor = GridBagConstraints.WEST;
        gbcCheckAnswers.fill = GridBagConstraints.HORIZONTAL;

        add(new JButton(new CorrectAction(QAmodel)), gbcCheckAnswers);
//        add(new JButton(new ShowAnswersAction(QAmodel)), gbcShowAnswers);
    }
}