
package qanda;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Matthias Delbar
 */
public class CreatePanel extends JPanel implements ChangeListener {
    private GridBagConstraints gbcLeft, gbcRight, gbcAdd;
    private Insets insets;
    private JButton addBtn;
    private CreateFrame frame;
    private CreateModel model;

    public CreatePanel(CreateFrame CFrame) {
        frame = CFrame;

        setLayout(new GridBagLayout());
        gbcLeft = new GridBagConstraints();
        gbcRight = new GridBagConstraints();
        gbcAdd = new GridBagConstraints();
        insets = new Insets(3,5,3,5);
        addBtn = new JButton(" + ");
        model = new CreateModel();
        model.addChangeListener(this);

        Action addAction = new AddAction(this);
        addBtn.setAction(addAction);
        addBtn.getActionMap().put("Add", addAction);
        ComponentInputMap cm = new ComponentInputMap(addBtn);
        cm.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.SHIFT_DOWN_MASK), "Add");
        cm.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Add");
        addBtn.setInputMap(WHEN_IN_FOCUSED_WINDOW, cm);

        gbcLeft.gridx = 0;
        gbcRight.gridx = 2;
        gbcAdd.gridx = 0;

        gbcLeft.gridy = 0;
        gbcRight.gridy = 0;
        gbcAdd.gridy = 1;

        gbcLeft.gridheight = 1;
        gbcRight.gridheight = 1;
        gbcAdd.gridheight = 2;

        gbcLeft.gridwidth = 2;
        gbcRight.gridwidth = 2;
        gbcAdd.gridwidth = 4;

        gbcLeft.insets = gbcRight.insets = insets;

        gbcLeft.anchor = GridBagConstraints.CENTER;
        gbcRight.anchor = GridBagConstraints.CENTER;
        gbcAdd.anchor = GridBagConstraints.CENTER;

        
        JLabel from = new JLabel(JOptionPane.showInputDialog("Please enter the \"From\" language"));
        JLabel to = new JLabel(JOptionPane.showInputDialog("Please enter the \"To\" language"));
        from.setAlignmentX(CENTER_ALIGNMENT);
        to.setAlignmentX(CENTER_ALIGNMENT);
        from.setAlignmentY(CENTER_ALIGNMENT);
        to.setAlignmentY(CENTER_ALIGNMENT);

        JTextField fLeft = new JTextField(15);
        JTextField fRight = new JTextField(15);


        add(from, gbcLeft);
        add(to, gbcRight);
        gbcLeft.gridy++;
        gbcRight.gridy++;
        gbcAdd.gridy++;

        add(fLeft, gbcLeft);
        add(fRight, gbcRight);
        model.addLeft(fLeft);
        model.addRight(fRight);
        gbcLeft.gridy++;
        gbcRight.gridy++;
        gbcAdd.gridy++;

        add(addBtn, gbcAdd);
    }

    public void resizeParentFrame() {
        // Resize parent frame. Parents are in order:
        // ViewPort | JScrollPane | LayeredPane | RootPane | JFrame
        JFrame par = (JFrame) getParent().getParent().getParent().getParent().getParent();
        par.pack();
        if(par.getHeight() > 600)
            par.setSize(new Dimension(par.getWidth() + 25, 600));

        // Scroll to the bottom
        JScrollPane scrollPane = (JScrollPane) getParent().getParent();
        scrollPane.getVerticalScrollBar().addAdjustmentListener(
            new AdjustmentListener() {
                public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                }
            }
        );
    }

    public void addNewLine() {
        JTextField fLeft = new JTextField(15);
        JTextField fRight = new JTextField(15);

        remove(addBtn);
        
        add(fLeft, gbcLeft, getComponentCount() - 1);
        add(fRight, gbcRight, getComponentCount() - 1);
        model.addLeft(fLeft);
        model.addRight(fRight);
        
        gbcLeft.gridy++;
        gbcRight.gridy++;
        gbcAdd.gridy++;
        
        add(addBtn, gbcAdd);

        fLeft.requestFocusInWindow();

        updateUI();
        resizeParentFrame();
    }

    public CreateModel getModel() {
        return model;
    }

    public void stateChanged(ChangeEvent e) {
        frame.setTitle(model.getFilename());
    }
}
