package info.liyc.controller;

import info.liyc.factory.DaoFactory;
import info.liyc.view.UpdateFrame;
import info.liyc.view.UpdatePanel;
import info.liyc.vo.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lyc on 2017/5/1.
 */
public class UpdateListener implements ActionListener {
    UpdateFrame uf;
    UpdatePanel up;
    int updateId;

    public UpdateListener(UpdateFrame uf, UpdatePanel up, int updateId) {
        this.uf = uf;
        this.up = up;
        this.updateId = updateId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnTemp = (JButton) e.getSource();
        if (btnTemp == up.btnUpdate) {
            Book book = new Book();
            book.setId(updateId);
            book.setTitle(up.txtTitle.getText());
            book.setAuthor(up.txtAuthor.getText());
            book.setPublisherId(DaoFactory.getPublisherDaoInstance().getPublisherId(
                    String.valueOf(up.jcbPublisher.getSelectedItem())));
            book.setPublishDate(up.txtPublishDate.getText());
            book.setIsbn(up.txtIsbn.getText());
            if (up.txtUnitPrice.getText().equals("")) {
                book.setUnitPrice(0);
            } else {
                book.setUnitPrice(Double.valueOf(up.txtUnitPrice.getText()));
            }
            book.setBookDescription(up.txtBookDescription.getText());
            book.setAuthorDescription(up.txtAuthorDescription.getText());
            book.setCategoryId(DaoFactory.getCategoryDaoInstance().getCategoryId(
                    String.valueOf(up.jcbCategory.getSelectedItem())));

            if (DaoFactory.getBookDaoInstance().updateBook(book) == true) {
                JOptionPane.showMessageDialog(null, "编辑成功！");
            } else {
                JOptionPane.showMessageDialog(null, "编辑失败！");
            }
        } else if (btnTemp == up.btnCancel) {
            uf.dispose();
        }
    }
}
