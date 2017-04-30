package info.liyc.view;

import info.liyc.controller.QueryListener;
import info.liyc.vo.Publisher;

import javax.swing.*;
import java.awt.*;

/**
 * Created by liyc on 17-4-30.
 */
public class QueryPanel extends JPanel {
    public JTextField txtInput;
    public JButton btnSelect, btnClear, btnAdd, btnEdit, btnDelete;
    public JLabel lbeSelect, lbeOperation;
    public JTable jTable;
    public JComboBox jcb;
    public TablePanel tablePanel;

    public QueryPanel(TablePanel tablePanel, MainFrame mf) {
        this.tablePanel = tablePanel;

        txtInput = new JTextField(30);
        btnSelect = new JButton("搜索");
        lbeSelect = new JLabel("图书检索：");
        btnClear = new JButton("清空");
        lbeOperation = new JLabel("图书操作:");
        btnAdd = new JButton("添加");
        btnEdit = new JButton("编辑");
        btnDelete = new JButton("删除");

        String[] jcbList = {"--请选择--", "书名", "作者", "所有图书", "ISBN"};
        jcb = new JComboBox(jcbList);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbl.setConstraints(lbeSelect, gbc);
        this.add(lbeSelect);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbl.setConstraints(jcb, gbc);
        this.add(jcb);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbl.setConstraints(txtInput, gbc);
        this.add(txtInput);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbl.setConstraints(btnSelect, gbc);
        this.add(btnSelect);

        gbc.gridx = 5;
        gbc.gridy = 1;
        gbl.setConstraints(btnClear, gbc);
        this.add(btnClear);

        gbc.gridx = 6;
        gbc.gridy = 1;
        gbl.setConstraints(lbeOperation, gbc);
        this.add(lbeOperation);

        gbc.gridx = 7;
        gbc.gridy = 1;
        gbl.setConstraints(btnAdd, gbc);
        this.add(btnAdd);

        gbc.gridx = 8;
        gbc.gridy = 1;
        gbl.setConstraints(btnEdit, gbc);
        this.add(btnEdit);

        gbc.gridx = 9;
        gbc.gridy = 1;
        gbl.setConstraints(btnDelete, gbc);
        this.add(btnDelete);

        QueryListener ql = new QueryListener(this, mf);
        btnSelect.addActionListener(ql);
        btnClear.addActionListener(ql);
        btnAdd.addActionListener(ql);
        btnEdit.addActionListener(ql);
        btnDelete.addActionListener(ql);
    }

}
