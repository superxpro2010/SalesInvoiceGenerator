/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udacity.view;

import com.udacity.InvoiceFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class SaveInvoicesDialog extends JDialog implements ActionListener {

    private JTextField invoiceHeadersFilePathTxt;
    private JTextField invoiceLinesFilePathTxt;
    private JButton browseHeadersFileBtn;
    private JLabel invoiceHeadersFilePathLbl;
    private JLabel invoiceLinesFilePathLbl;
    private JButton browseLinesFileBtn;
    private JButton okBtn;
    private JButton cancelBtn;
    private File headersFile;
    private File linesFile;

    public SaveInvoicesDialog(InvoiceFrame frame) {
        setTitle("Please Select Invoice Files To Save:");
        invoiceHeadersFilePathLbl = new JLabel("Headers File:");
        invoiceHeadersFilePathLbl.setSize(200, 30);
        invoiceHeadersFilePathTxt = new JTextField(20);

        browseHeadersFileBtn = new JButton("Browse...");
        browseHeadersFileBtn.setActionCommand("BrowseHeaders");
        browseHeadersFileBtn.addActionListener(this);

        invoiceLinesFilePathLbl = new JLabel("Lines File:");
        invoiceLinesFilePathLbl.setSize(200, 30);
        invoiceLinesFilePathTxt = new JTextField(20);

        browseLinesFileBtn = new JButton("Browse...");
        browseLinesFileBtn.setActionCommand("BrowseLines");
        browseLinesFileBtn.addActionListener(this);

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("SaveFile");
        cancelBtn.setActionCommand("Cancel");

        okBtn.addActionListener(frame);
        cancelBtn.addActionListener(this);
        setLayout(new GridLayout(3, 1));

        JPanel headersPanel = new JPanel(new FlowLayout());
        headersPanel.add(invoiceHeadersFilePathLbl);
        headersPanel.add(invoiceHeadersFilePathTxt);
        headersPanel.add(browseHeadersFileBtn);
        add(headersPanel);
        JPanel linesPanel = new JPanel(new FlowLayout());
        linesPanel.add(invoiceLinesFilePathLbl);
        linesPanel.add(invoiceLinesFilePathTxt);
        linesPanel.add(browseLinesFileBtn);
        add(linesPanel);
        JPanel actionsPanel = new JPanel(new GridLayout(1, 2));
        actionsPanel.add(okBtn);
        actionsPanel.add(cancelBtn);
        add(actionsPanel);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BrowseHeaders":
                browseHeadersFiles();
                break;
            case "BrowseLines":
                browseLinesFiles();
                break;
            case "Cancel":
                setVisible(false);
                break;
        }
    }

    private void browseHeadersFiles() {
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            headersFile = openFile.getSelectedFile();
            invoiceHeadersFilePathTxt.setText(headersFile.getAbsolutePath());
        }
    }

    private void browseLinesFiles() {
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            linesFile = openFile.getSelectedFile();
            invoiceLinesFilePathTxt.setText(linesFile.getAbsolutePath());
        }
    }

    public File getHeadersFile() {
        return headersFile;
    }

    public File getLinesFile() {
        return linesFile;
    }

    public boolean validateFiles() {
        return headersFile != null && linesFile != null;
    }
}
