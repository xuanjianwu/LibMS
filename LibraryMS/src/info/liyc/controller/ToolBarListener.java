package info.liyc.controller;

import info.liyc.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by liyc on 17-5-4.
 */
public class ToolBarListener implements ActionListener {
    private MainFrame mf;

    public ToolBarListener(MainFrame mf) {
        this.mf = mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem itemTemp = (JMenuItem) e.getSource();
        if (itemTemp == mf.menuOut) {
            mf.dispose();
        }
    }
}
