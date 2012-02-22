
package qanda;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Vindicator
 */
public class CorrectAction extends AbstractAction{

    private QandAModel QAmodel;

    public CorrectAction(QandAModel QAmodel) {
        super("Check Answers");
        this.QAmodel = QAmodel;
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<JTextField> tfList;
        ArrayList<JLabel> labelList;
        ArrayList<String> correctAnswers, inputAnswers;
        inputAnswers = new ArrayList<String>();

        // Get info from the model
        if(QAmodel.isLTR())
            correctAnswers = QAmodel.getWordsRight();
        else
            correctAnswers = QAmodel.getWordsLeft();
        tfList = QAmodel.getTfList();
        labelList = QAmodel.getLabelList();

        // Convert to ArrayList<String>
        for(JTextField tf : tfList) {
            inputAnswers.add(tf.getText());
        }

        boolean everyAnswerCorrect = true;
        for(int i = 0; i < labelList.size(); i++) {
            String givenAnswer = inputAnswers.get(i).trim().toLowerCase();
            String correctAnswer = correctAnswers.get(i).trim().toLowerCase();

            if(givenAnswer.equals(correctAnswer)) {
                labelList.get(i).setForeground(new Color(0, 200, 0));
            }
            else {
                labelList.get(i).setForeground(Color.RED);
                everyAnswerCorrect = false;
            }
        }
        QAmodel.setEveryAnswerCorrect(everyAnswerCorrect);

        if(everyAnswerCorrect) {
            JOptionPane.showMessageDialog(null, "Congratulations! You can now exit, if you want.");
        }
    }
}
