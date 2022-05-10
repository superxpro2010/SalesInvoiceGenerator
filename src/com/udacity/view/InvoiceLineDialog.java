/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udacity.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class InvoiceLineDialog extends JDialog {

    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel itemPriceLbl;
    private JButton okBtn;
    private JButton cancelBtn;

    public InvoiceLineDialog() {
        itemNameField = new JTextField(20);
        itemNameLbl = new JLabel("Item Name");

        itemCountField = new JTextField(20);
        itemCountLbl = new JLabel("Item Count");

        itemPriceField = new JTextField(20);
        itemPriceLbl = new JLabel("Item Price");

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("createLineOK");
        cancelBtn.setActionCommand("createLineCancel");

        setLayout(new GridLayout(4, 2));

        add(itemNameLbl);
        add(itemNameField);
        add(itemCountLbl);
        add(itemCountField);
        add(itemPriceLbl);
        add(itemPriceField);
        add(okBtn);
        add(cancelBtn);

        pack();
    }

    public void setActionsListener(ActionListener actionListener) {
        okBtn.addActionListener(actionListener);
        cancelBtn.addActionListener(actionListener);
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
}
