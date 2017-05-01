package info.liyc.controller;

import info.liyc.factory.DaoFactory;
import info.liyc.view.AddFrame;
import info.liyc.view.MainFrame;
import info.liyc.view.QueryPanel;
import info.liyc.view.UpdateFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by liyc on 17-4-30.
 */
public class QueryListener implements ActionListener {
    QueryPanel qp;
    MainFrame mf;
    int viewRowIndex;

    public QueryListener(QueryPanel qp, MainFrame mf) {
        this.qp = qp;
        this.mf = mf;
        viewRowIndex = -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnTemp = (JButton) e.getSource();
        if (btnTemp == qp.btnSelect) {
            ResultSet rs = null;
            int selectIndex = qp.jcb.getSelectedIndex();
            String txtInput = qp.txtInput.getText();
            switch (selectIndex) {
                case 1:
                    rs = DaoFactory.getBookDaoInstance().getBooksByTitle(txtInput);
                    break;
                case 2:
                    rs = DaoFactory.getBookDaoInstance().getBookByAuthor(txtInput);
                    break;
                case 3:
                    rs = DaoFactory.getBookDaoInstance().getBooksByAll();
                    break;
                case 4:
                    rs = DaoFactory.getBookDaoInstance().getBooksByIsbn(txtInput);
                    break;
            }
            try {
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columns = TableOperation.getColumnName(rsmd);
                Vector<Vector<String>> data = TableOperation.getTableData(rs, rsmd);

                qp.jTable = new JTable(data, columns);
                qp.jTable.setPreferredScrollableViewportSize(new Dimension(670, 350));
                qp.jTable.addMouseListener(new TableClickListener(this));
                qp.tablePanel.jsp.setViewportView(qp.jTable);
                qp.tablePanel.updateUI();
                viewRowIndex = -1;
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } else if (btnTemp == qp.btnClear) {
            ((DefaultTableModel)qp.jTable.getModel()).getDataVector().clear();
            ((DefaultTableModel)qp.jTable.getModel()).fireTableDataChanged();
            viewRowIndex = -1;
        } else if (btnTemp == qp.btnAdd) {
            AddFrame af = new AddFrame();
        } else if (btnTemp == qp.btnEdit) {
            if (viewRowIndex > -1) {
                int id = Integer.valueOf((String) qp.jTable.getValueAt(viewRowIndex, 0));
                Vector<String> updateV = new Vector<String>();
                for (int i = 0; i < qp.jTable.getColumnCount(); i++) {
                    updateV.add((String) qp.jTable.getValueAt(viewRowIndex, i));
                }
                UpdateFrame uf = new UpdateFrame(updateV);
            }
        } else if (btnTemp == qp.btnDelete) {
            if (viewRowIndex > -1) {
                if (JOptionPane.showConfirmDialog(null, "你真的要删除吗？", "删除图书",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    //int modelRowIndex = qp.jTable.convertRowIndexToModel(viewRowIndex);
                    String id = (String) qp.jTable.getValueAt(viewRowIndex, 0);
                    if (DaoFactory.getBookDaoInstance().deleteBookById(Integer.valueOf(id)) == true) {
                        ((DefaultTableModel) qp.jTable.getModel()).removeRow(viewRowIndex);
                        JOptionPane.showMessageDialog(null, "删除成功！");
                    } else {
                        JOptionPane.showMessageDialog(null, "删除失败！");
                    }
                }
            }
        }
    }
}
