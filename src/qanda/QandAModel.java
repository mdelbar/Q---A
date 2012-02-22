
package qanda;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Vindicator
 */
public class QandAModel extends Model {

    private ArrayList<String> wordsLeft, wordsRight;
    private ArrayList<JTextField> tfList;
    private ArrayList<JLabel> labelList;
    private boolean ltr, ltrSet, everyAnswerCorrect;

    public QandAModel() {
        wordsLeft = new ArrayList<String>();
        wordsRight = new ArrayList<String>();
        tfList = new ArrayList<JTextField>();
        labelList = new ArrayList<JLabel>();
        ltrSet = false;
        ltr = true;
        everyAnswerCorrect = false;
    }
    
    public void clear() {
        wordsLeft.clear();
        wordsRight.clear();
        tfList.clear();
        labelList.clear();
        everyAnswerCorrect = false;
    }

    public boolean isEmpty() {
        return wordsLeft.isEmpty() && wordsRight.isEmpty()
               && tfList.isEmpty() && labelList.isEmpty();
    }



    public void addLeft(String s){
        wordsLeft.add(s);
    }

    public void addRight(String s){
        wordsRight.add(s);
    }

    public void addTextField(JTextField tf) {
        tfList.add(tf);
    }

    public void addLabel(JLabel l) {
        labelList.add(l);
    }

    public void changeDirection() {
        ltr = !ltr;
        fireStateChanged();
    }



    public ArrayList<String> getWordsLeft() {
        return wordsLeft;
    }

    public ArrayList<String> getWordsRight() {
        return wordsRight;
    }

    public ArrayList<JLabel> getLabelList() {
        return labelList;
    }

    public ArrayList<JTextField> getTfList() {
        return tfList;
    }

    public boolean isLTRSet() {
        return ltrSet;
    }

    public boolean isLTR() {
        return ltr;
    }

    public boolean isEveryAnswerCorrect() {
        return everyAnswerCorrect;
    }

    public void setEveryAnswerCorrect(boolean everyAnswerCorrect) {
        this.everyAnswerCorrect = everyAnswerCorrect;
    }
}
