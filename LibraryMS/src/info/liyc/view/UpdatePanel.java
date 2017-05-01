package info.liyc.view;

import info.liyc.controller.UpdateListener;
import info.liyc.factory.DaoFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by Lyc on 2017/5/1.
 */
public class UpdatePanel extends JPanel {
    public JLabel lbeTitle, lbeAuthor, lbePublisher, lbePublishDate,
            lbeIsbn, lbeUnitPrice, lbeBookDescription, lbeAuthorDescription,
            lbeCategory;

    public JTextField txtTitle, txtAuthor, txtPublishDate, txtIsbn,
            txtUnitPrice;
    public JTextArea txtBookDescription, txtAuthorDescription;
    public JComboBox jcbPublisher, jcbCategory;
    public JButton btnUpdate, btnCancel;

    public UpdatePanel(UpdateFrame uf, Vector<String> updateV) {
        lbeTitle = new JLabel("图书标题：");
        lbeAuthor = new JLabel("作者：");
        lbePublisher = new JLabel("出版社：");
        lbePublishDate = new JLabel("出版日期：");
        lbeIsbn = new JLabel("ISBN:");
        lbeUnitPrice = new JLabel("图书单价：");
        lbeBookDescription = new JLabel("图书描述：");
        lbeAuthorDescription = new JLabel("作者简介：");
        lbeCategory = new JLabel("图书分类:");

        txtTitle = new JTextField(20);
        txtAuthor = new JTextField(10);
        txtPublishDate = new JTextField(10);
        txtIsbn = new JTextField(10);
        txtUnitPrice = new JTextField(10);
        txtBookDescription = new JTextArea(3, 20);
        txtAuthorDescription = new JTextArea(3, 20);


        txtTitle.setText(updateV.elementAt(1));
        txtAuthor.setText(updateV.elementAt(2));
        txtPublishDate.setText(updateV.elementAt(4));
        txtIsbn.setText(updateV.elementAt(5));
        txtUnitPrice.setText(updateV.elementAt(6));
        txtBookDescription.setText(updateV.elementAt(7));
        txtAuthorDescription.setText(updateV.elementAt(8));

        jcbPublisher = new JComboBox(DaoFactory.getPublisherDaoInstance().getPublisherByAllToString());
        jcbCategory = new JComboBox(DaoFactory.getCategoryDaoInstance().getCategoryByAllToString());

        jcbPublisher.setSelectedIndex(Integer.valueOf(updateV.elementAt(3)) - 1);
        jcbCategory.setSelectedIndex(Integer.valueOf(updateV.elementAt(9)) - 1);

        btnUpdate = new JButton("确定编辑");
        btnCancel = new JButton("取消编辑");

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbl.setConstraints(lbeTitle, gbc);
        this.add(lbeTitle);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbl.setConstraints(txtTitle, gbc);
        this.add(txtTitle);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbl.setConstraints(lbeAuthor, gbc);
        this.add(lbeAuthor);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbl.setConstraints(txtAuthor, gbc);
        this.add(txtAuthor);

        gbc.gridx = 5;
        gbc.gridy = 1;
        gbl.setConstraints(lbePublishDate, gbc);
        this.add(lbePublishDate);

        gbc.gridx = 6;
        gbc.gridy = 1;
        gbl.setConstraints(txtPublishDate, gbc);
        this.add(txtPublishDate);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbl.setConstraints(lbePublisher, gbc);
        this.add(lbePublisher);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbl.setConstraints(jcbPublisher, gbc);
        this.add(jcbPublisher);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbl.setConstraints(lbeIsbn, gbc);
        this.add(lbeIsbn);

        gbc.gridx = 4;
        gbc.gridy = 2;
        gbl.setConstraints(txtIsbn, gbc);
        this.add(txtIsbn);

        gbc.gridx = 5;
        gbc.gridy = 2;
        gbl.setConstraints(lbeUnitPrice, gbc);
        this.add(lbeUnitPrice);

        gbc.gridx = 6;
        gbc.gridy = 2;
        gbl.setConstraints(txtUnitPrice, gbc);
        this.add(txtUnitPrice);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbl.setConstraints(lbeCategory, gbc);
        this.add(lbeCategory);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbl.setConstraints(jcbCategory, gbc);
        this.add(jcbCategory);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbl.setConstraints(lbeBookDescription, gbc);
        this.add(lbeBookDescription);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbl.setConstraints(txtBookDescription, gbc);
        this.add(txtBookDescription);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbl.setConstraints(lbeAuthorDescription, gbc);
        this.add(lbeAuthorDescription);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbl.setConstraints(txtAuthorDescription, gbc);
        this.add(txtAuthorDescription);

        gbc.gridx = 3;
        gbc.gridy = 6;
        gbl.setConstraints(btnUpdate, gbc);
        this.add(btnUpdate);

        gbc.gridx = 4;
        gbc.gridy = 6;
        gbl.setConstraints(btnCancel, gbc);
        this.add(btnCancel);

        UpdateListener ul = new UpdateListener(uf, this, Integer.valueOf(updateV.elementAt(0)));
        btnUpdate.addActionListener(ul);
        btnCancel.addActionListener(ul);
    }
}
