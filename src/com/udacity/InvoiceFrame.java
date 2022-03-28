/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udacity;

import com.udacity.exceptions.ValidationException;
import com.udacity.model.InvoiceHeader;
import com.udacity.model.InvoiceHeaderTableModel;
import com.udacity.model.InvoiceLine;
import com.udacity.model.InvoiceLinesTableModel;
import com.udacity.view.InvoiceHeaderDialog;
import com.udacity.view.InvoiceLineDialog;
import com.udacity.view.LoadInvoicesDialog;
import com.udacity.view.SaveInvoicesDialog;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DELL
 */
public class InvoiceFrame extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    /**
     * Creates new form InvoiceFrame
     */
    public InvoiceFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(this);
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(this);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(this);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custNameTF = new javax.swing.JTextField();
        invDateTF = new javax.swing.JTextField();
        invNumLbl = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLinesTable = new javax.swing.JTable();
        applyChangesBtn = new javax.swing.JButton();
        applyChangesBtn.addActionListener(this);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.addActionListener(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(this);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoicesTable);

        createInvBtn.setText("Create New Invoice");
        createInvBtn.setActionCommand("CreateNewInvoice");

        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.setActionCommand("DeleteInvoice");

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoide Date");

        jLabel3.setText("Customer name");

        jLabel4.setText("Invoice Total");

        invLinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invLinesTable);

        applyChangesBtn.setText("save");
        applyChangesBtn.setActionCommand("ApplyChanges");

        cancelBtn.setText("cancel");
        cancelBtn.setActionCommand("discard");

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("BrowsrOpenInvoiceFiles");
        loadMenuItem.setAutoscrolls(true);
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("BrowsrSaveInvoiceFiles");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(custNameTF)
                                            .addComponent(invDateTF)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(invNumLbl)
                                                    .addComponent(invTotalLbl))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(applyChangesBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelBtn)
                                .addGap(101, 101, 101))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(createInvBtn)
                        .addGap(87, 87, 87)
                        .addComponent(deleteInvBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNumLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(custNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(applyChangesBtn)
                            .addComponent(cancelBtn))
                        .addGap(44, 44, 44)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvBtn)
                    .addComponent(createInvBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        applyChangesBtn.getAccessibleContext().setAccessibleName("Save");
        applyChangesBtn.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyChangesBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createInvBtn;
    private javax.swing.JTextField custNameTF;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JTextField invDateTF;
    private javax.swing.JTable invLinesTable;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private List<InvoiceHeader> invoicesList = new ArrayList<>();
    private InvoiceHeaderTableModel invoiceHeaderTableModel;
    private InvoiceLinesTableModel invoiceLinesTableModel;
    private InvoiceHeaderDialog headerDialog;
    private InvoiceLineDialog lineDialog;
    private LoadInvoicesDialog loadInvoicesDialog;
    private SaveInvoicesDialog saveInvoicesDialog;
    private int selectedInvIndex = -1;

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "CreateNewInvoice":
                displayNewInvoiceDialog();
                break;
            case "DeleteInvoice":
                deleteInvoice();
                break;
            case "CreateNewLine":
                displayNewLineDialog();
                break;
            case "DeleteLine":
                deleteLine();
                break;
            case "BrowsrOpenInvoiceFiles":
                browseOpenInvoiceFiles();
                break;
            case "LoadFile":
                loadFile();
                break;
            case "discard":
                discardChanges();
                break;
            case "ApplyChanges":
                applyChanges();
                break;

            case "BrowsrSaveInvoiceFiles":
                browseSaveInvoiceFiles();
                break;
            case "SaveFile":
                saveData();
                break;
            case "createInvCancel":
                createInvCancel();
                break;
            case "createInvOK":
                createInvOK();
                break;
            case "createLineCancel":
                createLineCancel();
                break;
            case "createLineOK":
                createLineOK();
                break;
        }
    }

    private void loadFile() {
        if (!loadInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(this, "please select valid file paths");
            return;
        }
        loadInvoicesDialog.setVisible(false);
        try {
            loadFiles(loadInvoicesDialog.getHeadersFile(), loadInvoicesDialog.getLinesFile());
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMsg());
        }
        clearSelectedInvoice();
    }

    private void discardChanges() {
        if (loadInvoicesDialog == null || !loadInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(this, "No Valid Invoice File Loaded");
            return;
        }
        try {
            loadFiles(loadInvoicesDialog.getHeadersFile(), loadInvoicesDialog.getLinesFile());
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, "No Valid Format Invoice File Loaded");
        }
        clearSelectedInvoice();
    }

    private void saveData() {
        if (!saveInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(this, "please select valid file paths");
            return;
        }
        saveInvoicesDialog.setVisible(false);
        saveData(saveInvoicesDialog.getHeadersFile(), saveInvoicesDialog.getLinesFile());
    }

    private void applyChanges() {
        if (loadInvoicesDialog == null || !loadInvoicesDialog.validateFiles()) {
            JOptionPane.showMessageDialog(this, "No Valid Invoice File Loaded");
            return;
        }
        saveData(loadInvoicesDialog.getHeadersFile(), loadInvoicesDialog.getLinesFile());
    }

    private void clearSelectedInvoice() {
        invoicesTable.clearSelection();
        invLinesTable.setModel(new InvoiceHeaderTableModel(new ArrayList<>()));
        custNameTF.setText("");
        invDateTF.setText("");
        invNumLbl.setText("");
        invTotalLbl.setText("");
    }

    private InvoiceHeader findInvoiceByNum(int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : invoicesList) {
            if (invNum == inv.getInvNum()) {
                header = inv;
                break;
            }
        }
        return header;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        loadSelectedInvoice();
    }

    private void loadSelectedInvoice() {
        int selectedRowIndex = invoicesTable.getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader row = invoiceHeaderTableModel.getInvoicesList().get(selectedRowIndex);
            custNameTF.setText(row.getCustomerName());
            invDateTF.setText(df.format(row.getInvDate()));
            invNumLbl.setText("" + row.getInvNum());
            invTotalLbl.setText("" + row.getInvTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            invoiceLinesTableModel = new InvoiceLinesTableModel(lines);
            invLinesTable.setModel(invoiceLinesTableModel);
            invoiceLinesTableModel.fireTableDataChanged();
        }
    }

    private void displayNewInvoiceDialog() {
        headerDialog = new InvoiceHeaderDialog(this);
        headerDialog.setLocationRelativeTo(this);
        headerDialog.setVisible(true);
    }

    private void displayNewLineDialog() {
        lineDialog = new InvoiceLineDialog(this);
        lineDialog.setLocationRelativeTo(this);
        lineDialog.setVisible(true);
    }

    private void createInvCancel() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog = null;
    }

    private void createInvOK() {
        String custName = headerDialog.getCustNameField().getText();
        String invDateStr = headerDialog.getInvDateField().getText();
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog = null;
        try {
            Date invDate = df.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invNum, custName, invDate);
            invoicesList.add(invoiceHeader);
            invoiceHeaderTableModel.fireTableDataChanged();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        displayInvoices();
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

    private void createLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
    }

    private void browseOpenInvoiceFiles() {
        loadInvoicesDialog = new LoadInvoicesDialog(this);
        loadInvoicesDialog.setLocationRelativeTo(this);
        loadInvoicesDialog.setVisible(true);
    }

    private void browseSaveInvoiceFiles() {
        saveInvoicesDialog = new SaveInvoicesDialog(this);
        saveInvoicesDialog.setLocationRelativeTo(this);
        saveInvoicesDialog.setVisible(true);
    }

    private void createLineOK() {
        String itemName = lineDialog.getItemNameField().getText();
        String itemCountStr = lineDialog.getItemCountField().getText();
        String itemPriceStr = lineDialog.getItemPriceField().getText();
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        int headerIndex = invoicesTable.getSelectedRow();
        InvoiceHeader invoice = invoiceHeaderTableModel.getInvoicesList().get(headerIndex);

        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
        invoice.addInvLine(invoiceLine);
        invoiceLinesTableModel.fireTableDataChanged();
        invoiceHeaderTableModel.fireTableDataChanged();
        invTotalLbl.setText("" + invoice.getInvTotal());
        displayInvoices();
    }

    private void deleteInvoice() {
        int invIndex = invoicesTable.getSelectedRow();
        InvoiceHeader header = invoiceHeaderTableModel.getInvoicesList().get(invIndex);
        invoiceHeaderTableModel.getInvoicesList().remove(invIndex);
        invoiceHeaderTableModel.fireTableDataChanged();
        invoiceLinesTableModel = new InvoiceLinesTableModel(new ArrayList<InvoiceLine>());
        invLinesTable.setModel(invoiceLinesTableModel);
        invoiceLinesTableModel.fireTableDataChanged();
        custNameTF.setText("");
        invDateTF.setText("");
        invNumLbl.setText("");
        invTotalLbl.setText("");
        displayInvoices();
    }

    private void deleteLine() {
        int lineIndex = invLinesTable.getSelectedRow();
        InvoiceLine line = invoiceLinesTableModel.getInvoiceLines().get(lineIndex);
        invoiceLinesTableModel.getInvoiceLines().remove(lineIndex);
        invoiceLinesTableModel.fireTableDataChanged();
        invoiceHeaderTableModel.fireTableDataChanged();
        invTotalLbl.setText("" + line.getHeader().getInvTotal());
        displayInvoices();
    }

    private void displayInvoices() {
        System.out.println("***************************");
        for (InvoiceHeader header : invoicesList) {
            System.out.println(header);
        }
        System.out.println("***************************");
    }

    private void loadFiles(File headerFile, File linesFile) throws ValidationException {
        invoicesList.clear();

        FileReader headerFr;
        try {
            headerFr = new FileReader(headerFile);

            BufferedReader headerBr = new BufferedReader(headerFr);
            String headerLine = null;

            while ((headerLine = headerBr.readLine()) != null) {
                String[] headerParts = headerLine.split(",");
                if (headerParts.length < 3) {
                    throw new ValidationException("Invalid Format Excption");
                }
                try {
                    String invNumStr = headerParts[0];
                    String invDateStr = headerParts[1];
                    String custName = headerParts[2];
                    int invNum = Integer.parseInt(invNumStr);
                    Date invDate = df.parse(invDateStr);
                    InvoiceHeader inv = new InvoiceHeader(invNum, custName, invDate);
                    invoicesList.add(inv);
                } catch (Exception ex) {
                    throw new ValidationException("Invalid Format Excption");
                }

            }

            BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
            String linesLine = null;
            while ((linesLine = linesBr.readLine()) != null) {
                String[] lineParts = linesLine.split(",");
                if (lineParts.length < 4) {
                    throw new ValidationException("Invalid Format Exception");
                }
                try {
                    String invNumStr = lineParts[0];
                    String itemName = lineParts[1];
                    String itemPriceStr = lineParts[2];
                    String itemCountStr = lineParts[3];
                    int invNum = Integer.parseInt(invNumStr);
                    double itemPrice = Double.parseDouble(itemPriceStr);
                    int itemCount = Integer.parseInt(itemCountStr);
                    InvoiceHeader header = findInvoiceByNum(invNum);
                    InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                    header.getLines().add(invLine);
                } catch (Exception ex) {
                    throw new ValidationException("Invalid Format Excption");
                }
            }
            invoiceHeaderTableModel = new InvoiceHeaderTableModel(invoicesList);
            invoicesTable.setModel(invoiceHeaderTableModel);
            invoicesTable.validate();

            System.out.println("Check");
        } catch (FileNotFoundException ex) {
            throw new ValidationException("File Not Found Excption");
        } catch (IOException ex) {
            throw new ValidationException("Invalid Format Excption");
        }
        displayInvoices();
    }

    private void saveData(File headerFile, File linesFile) {
        headerFile.deleteOnExit();
        linesFile.deleteOnExit();
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : invoicesList) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }
        try {
            FileWriter hFW = new FileWriter(headerFile);
            hFW.write(headers);
            hFW.flush();
            hFW.close();

            FileWriter lFW = new FileWriter(linesFile);
            lFW.write(lines);
            lFW.flush();
            lFW.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}