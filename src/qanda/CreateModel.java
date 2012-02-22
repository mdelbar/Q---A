
package qanda;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * @author Matthias Delbar
 */

public class CreateModel extends Model {
    private String filename, from, to;
    private ArrayList<JTextField> left, right;
    private boolean filenameSet;

    public CreateModel() {
        filename = "Untitled*";
        filenameSet = false;
        
        left = new ArrayList<JTextField>();
        right = new ArrayList<JTextField>();
    }

    public void addLeft(JTextField f) {
        left.add(f);
    }
    public void addRight(JTextField f) {
        right.add(f);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    public String getFilename() {
        return filename;
    }
    public void setFilename(String name) {
        filename = name;
        filenameSet = true;
        fireStateChanged();
    }

    public boolean isFilenameSet() {
        return filenameSet;
    }

    public ArrayList<JTextField> getLeft() {
        return left;
    }

    public ArrayList<JTextField> getRight() {
        return right;
    }
}
