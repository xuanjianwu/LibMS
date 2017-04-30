package info.liyc.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by liyc on 17-4-30.
 */
public class TableClickListener implements MouseListener {
    QueryListener ql;

    public TableClickListener(QueryListener ql) {
        this.ql = ql;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ql.viewRowIndex = ql.qp.jTable.getSelectedRow();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
