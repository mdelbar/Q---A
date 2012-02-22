
package qanda;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Matthias Delbar
 */

public class QandAFilenameFilter implements FilenameFilter {

    public QandAFilenameFilter() {
        
    }

    public boolean accept(File dir, String name) {
        return (name.endsWith(".qanda"));
    }
}
