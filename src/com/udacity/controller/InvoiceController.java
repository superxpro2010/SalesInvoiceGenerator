/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udacity.controller;

import com.udacity.exceptions.ValidationException;
import com.udacity.model.InvoiceHeader;
import com.udacity.model.InvoiceHeaderTableModel;
import com.udacity.model.InvoiceLine;
import com.udacity.model.InvoiceLinesTableModel;
import com.udacity.view.InvoiceFrame;
import com.udacity.view.InvoiceHeaderDialog;
import com.udacity.view.InvoiceLineDialog;
import com.udacity.view.LoadInvoicesDialog;
import com.udacity.view.SaveInvoicesDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mohab
 */
public class InvoiceController implements ActionListener, ListSelectionListener {

    private final InvoiceFrame invoiceFrame;
    private InvoiceHeaderDialog invoiceHeaerDiaog;
    private InvoiceLineDialog invoiceLineDialog;
    private LoadInvoicesDialog loadInvoicesDialog;
    private SaveInvoicesDialog saveInvoicesDialog;

    private List<InvoiceHeader> invoicesList = new ArrayList<>();
    private InvoiceHeaderTableModel invoiceHeaderTableModel;
    private InvoiceLinesTableModel invoiceLinesTableModel;

    private final DateFormat df;

    public InvoiceController(InvoiceFrame view) {
        this.invoiceFrame = view;
        this.df = new SimpleDateFormat("dd-MM-yyyy");
        this.df.setLenient(false);
    }

    public void init() {
        this.invoiceFrame.setActionsListener(this);
        this.invoiceFrame.setInvoiceSelectionListener(this);
        this.invoiceFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BrowsrOpenInvoiceFiles":
                browseOpenInvoiceFiles();
                break;
            case "LoadFile":
                loadFile();
                break;
            case "BrowsrSaveInvoiceFiles":
                browseSaveInvoiceFiles();
                break;
            case "SaveFile":
                saveData();
                break;

            case "CreateNewInvoice":
                displayNewInvoiceDialog();
                break;
            case "createInvCancel":
                createInvCancel();
                break;
            case "createInvOK":
                createInvOK();
                break;

            case "DeleteInvoice":
                deleteSelectedInvoice();
                break;

            case "CreateNewLine":
                displayNewLineDialog();
                break;
            case "createLineCancel":
                createLineCancel();
                break;
            case "createLineOK":
                createLineOK();
                break;

            case "DeleteLine":
                deleteSelectedInvoiceLine();
                break;

            case "discard":
                discardChanges();
                break;
            case "ApplyChanges":
                applyChanges();
                break;

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        invoiceFrame.loadSelectedInvoice();
    }

    private void browseOpenInvoiceFiles() {
        loadInvoicesDialog = new LoadInvoicesDialog();
        loadInvoicesDialog.addOkActionListener(this);
        loadInvoicesDialog.setLocationRelativeTo(invoiceFrame);
        loadInvoicesDialog.setVisible(true);
    }

    private void loadFile() {
        if (!loadInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(invoiceFrame, "please select valid file paths");
            return;
        }
        loadInvoicesDialog.setVisible(false);
        try {
            invoicesList = FileOperations.loadFiles(loadInvoicesDialog.getHeadersFile(), loadInvoicesDialog.getLinesFile());
            invoiceHeaderTableModel = new InvoiceHeaderTableModel(invoicesList);
            invoiceFrame.updateInvoicesTable(invoiceHeaderTableModel);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(invoiceFrame, ex.getMsg());
        }
        invoiceFrame.clearSelectedInvoice();
    }

    private void browseSaveInvoiceFiles() {
        saveInvoicesDialog = new SaveInvoicesDialog();
        saveInvoicesDialog.addOkActionListener(this);
        saveInvoicesDialog.setLocationRelativeTo(invoiceFrame);
        saveInvoicesDialog.setVisible(true);
    }

    private void saveData() {
        if (!saveInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(invoiceFrame, "please select valid file paths");
            return;
        }
        saveInvoicesDialog.setVisible(false);
        try {
            FileOperations.saveData(invoicesList, saveInvoicesDialog.getHeadersFile(), saveInvoicesDialog.getLinesFile());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(invoiceFrame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayNewInvoiceDialog() {
        invoiceHeaerDiaog = new InvoiceHeaderDialog();
        invoiceHeaerDiaog.setLocationRelativeTo(invoiceFrame);
        invoiceHeaerDiaog.setActionsListener(this);
        invoiceHeaerDiaog.setVisible(true);
    }

    private void displayNewLineDialog() {
        invoiceLineDialog = new InvoiceLineDialog();
        invoiceLineDialog.setLocationRelativeTo(invoiceFrame);
        invoiceHeaerDiaog.setActionsListener(this);
        invoiceLineDialog.setVisible(true);
    }

    private void createInvCancel() {
        invoiceHeaerDiaog.setVisible(false);
        invoiceHeaerDiaog.dispose();
        invoiceHeaerDiaog = null;
    }

    private void createInvOK() {
        String custName = invoiceHeaerDiaog.getCustNameField().getText();
        String invDateStr = invoiceHeaerDiaog.getInvDateField().getText();
        invoiceHeaerDiaog.setVisible(false);
        invoiceHeaerDiaog.dispose();
        invoiceHeaerDiaog = null;
        try {
            Date invDate = df.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invNum, custName, invDate);
            invoicesList.add(invoiceHeader);
            invoiceHeaderTableModel.fireTableDataChanged();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        logInvoices();
    }

    private int getNextInvoiceNum() {
        int max = 0;
        for (InvoiceHeader header : invoicesList) {
            if (header.getInvNum() > max) {
                max = header.getInvNum();
            }
        }
        return max + 1;
    }

    private void deleteSelectedInvoice() {
        invoiceFrame.deleteSelectedInvoice();
    }

    private void deleteSelectedInvoiceLine() {
        invoiceFrame.deleteSelectedInvoiceLine();
    }

    private void createLineCancel() {
        invoiceLineDialog.setVisible(false);
        invoiceLineDialog.dispose();
        invoiceLineDialog = null;
    }

    private void createLineOK() {
        String itemName = invoiceLineDialog.getItemNameField().getText();
        String itemCountStr = invoiceLineDialog.getItemCountField().getText();
        String itemPriceStr = invoiceLineDialog.getItemPriceField().getText();
        invoiceLineDialog.setVisible(false);
        invoiceLineDialog.dispose();
        invoiceLineDialog = null;

        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        int headerIndex = invoiceFrame.getSelectedInvoiceIndex();
        InvoiceHeader invoice = invoiceHeaderTableModel.getInvoicesList().get(headerIndex);

        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
        invoice.addInvLine(invoiceLine);
        invoiceLinesTableModel.fireTableDataChanged();
        invoiceHeaderTableModel.fireTableDataChanged();
        invoiceFrame.updateSelectedInvoiceTotalLabel(invoice.getInvTotal());
        logInvoices();
    }

    private void applyChanges() {
        if (loadInvoicesDialog == null || !loadInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(invoiceFrame, "No Valid Invoice File Loaded");
            return;
        }
        try {
            FileOperations.saveData(invoicesList, loadInvoicesDialog.getHeadersFile(), loadInvoicesDialog.getLinesFile());
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(invoiceFrame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void discardChanges() {
        if (loadInvoicesDialog == null || !loadInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(invoiceFrame, "No Valid Invoice File Loaded");
            return;
        }
        try {
            invoicesList = FileOperations.loadFiles(loadInvoicesDialog.getHeadersFile(), loadInvoicesDialog.getLinesFile());
            invoiceHeaderTableModel = new InvoiceHeaderTableModel(invoicesList);
            invoiceFrame.updateInvoicesTable(invoiceHeaderTableModel);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(invoiceFrame, "No Valid Format Invoice File Loaded");
        }
        invoiceFrame.clearSelectedInvoice();
    }

    private void logInvoices() {
        System.out.println("***************************");
        for (InvoiceHeader header : invoicesList) {
            System.out.println(header);
        }
        System.out.println("***************************");
    }

}
