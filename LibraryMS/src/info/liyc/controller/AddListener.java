package info.liyc.controller;

import info.liyc.factory.DaoFactory;
import info.liyc.view.AddPanel;
import info.liyc.vo.Book;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by liyc on 17-4-30.
 */
public class AddListener implements ActionListener {
    AddPanel ap;

    public AddListener(AddPanel ap) {
        this.ap = ap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnTemp = (JButton) e.getSource();
        if (btnTemp == ap.btnAdd) {
            Book book = new Book();
            book.setId(DaoFactory.getBookDaoInstance().getMaxId() + 1);
            book.setTitle(ap.txtTitle.getText());
            book.setAuthor(ap.txtAuthor.getText());
            book.setPublisherId(DaoFactory.getPublisherDaoInstance().getPublisherId(
                    String.valueOf(ap.jcbPublisher.getSelectedItem())));
            book.setPublishDate(ap.txtPublishDate.getText());
            book.setIsbn(ap.txtIsbn.getText());
            if (ap.txtUnitPrice.getText().equals("")) {
                book.setUnitPrice(0);
            } else {
                book.setUnitPrice(Double.valueOf(ap.txtUnitPrice.getText()));
            }
            book.setBookDescription(ap.txtBookDescription.getText());
            book.setAuthorDescription(ap.txtAuthorDescription.getText());
            book.setCategoryId(DaoFactory.getCategoryDaoInstance().getCategoryId(
                    String.valueOf(ap.jcbCategory.getSelectedItem())));

            if (DaoFactory.getBookDaoInstance().addBook(book) == true) {
                JOptionPane.showMessageDialog(null, "添加成功！");
            } else {
                JOptionPane.showMessageDialog(null, "添加失败！");
            }
        }
    }
}
