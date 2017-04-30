package info.liyc.view;

import javax.swing.*;

/**
 * Created by liyc on 17-4-30.
 */
public class TablePanel extends JPanel {
    public JScrollPane jsp;

    public TablePanel() {
        jsp = new JScrollPane();
        this.add(jsp);
    }
}
