package com.udacity.view;

import com.udacity.model.InvoiceHeader;
import com.udacity.model.InvoiceHeaderTableModel;
import com.udacity.model.InvoiceLine;
import com.udacity.model.InvoiceLinesTableModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;

public class InvoiceFrame extends javax.swing.JFrame {

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
    private javax.swing.JLabel invNumberLabel;
    private javax.swing.JLabel invDateLabel;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel invTotalLabel;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane invoicesTableScrollPane;
    private javax.swing.JScrollPane invLinesTableScrollPane;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private final DateFormat df;

    private InvoiceHeaderTableModel invoiceHeaderTableModel;
    private InvoiceLinesTableModel invoiceLinesTableModel;

    public InvoiceFrame() {
        this.init();
        this.df = new SimpleDateFormat("dd-MM-yyyy");
        this.df.setLenient(false);

    }

    public void init() {
        initJMenu();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(getHorizontalGroup(layout));
        layout.setVerticalGroup(getVerticalGroup(layout));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void initJMenu() {
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();

            jFileMenu = new JMenu();
            jFileMenu.setText("File");

            jFileMenu.add(initLoadMenuItem());
            jFileMenu.add(initSaveMenuItem());

            jMenuBar.add(jFileMenu);
        }
        setJMenuBar(jMenuBar);
    }

    private GroupLayout.ParallelGroup getVerticalGroup(GroupLayout layout) {
        return layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(LEADING, false)
                                .addComponent(initInvoicesTableScrollPane(), PREFERRED_SIZE, 548, PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(initInvNumberLabel())
                                                .addComponent(initInvNumlabel()))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(initInvDateLabel())
                                                .addComponent(initInvDateTF(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(initCustomerNameLabel())
                                                .addComponent(initCustNameTF(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(initInvTotalLabel())
                                                .addComponent(initInvTotalLbl()))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(initInvLinesTableScrollPane(), javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(BASELINE)
                                                .addComponent(initApplyBtn())
                                                .addComponent(initCancelBtn()))
                                        .addGap(44, 44, 44)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(initDeleteInvBtn())
                                .addComponent(initCreateInvBtn()))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }

    private GroupLayout.ParallelGroup getHorizontalGroup(GroupLayout layout) {
        return layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(initInvoicesTableScrollPane(), PREFERRED_SIZE, 434, PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(LEADING)
                                                                                .addComponent(initCustomerNameLabel())
                                                                                .addComponent(initInvNumberLabel())
                                                                                .addComponent(initInvDateLabel())
                                                                                .addComponent(initInvTotalLabel()))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(layout.createParallelGroup(LEADING)
                                                                                .addComponent(initCustNameTF())
                                                                                .addComponent(initInvDateTF())
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(LEADING)
                                                                                                .addComponent(initInvNumlabel())
                                                                                                .addComponent(initInvTotalLbl()))
                                                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(initInvLinesTableScrollPane(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(76, 76, 76)
                                                        .addComponent(initApplyBtn())
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(initCancelBtn())
                                                        .addGap(101, 101, 101))))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(initCreateInvBtn())
                                        .addGap(87, 87, 87)
                                        .addComponent(initDeleteInvBtn())))
                        .addContainerGap());
    }

    private JMenuItem initSaveMenuItem() {
        if (saveMenuItem == null) {
            saveMenuItem = new JMenuItem();
            saveMenuItem.setText("Save File");
            saveMenuItem.setActionCommand("BrowsrSaveInvoiceFiles");
        }
        return saveMenuItem;
    }

    private JMenuItem initLoadMenuItem() {
        if (loadMenuItem == null) {
            loadMenuItem = new JMenuItem();
            loadMenuItem.setText("Load File");
            loadMenuItem.setActionCommand("BrowsrOpenInvoiceFiles");
            loadMenuItem.setAutoscrolls(true);
        }
        return loadMenuItem;
    }

    private JLabel initInvTotalLabel() {
        if (invTotalLabel == null) {
            invTotalLabel = new JLabel();
            invTotalLabel.setText("Invoice Total");
        }
        return invTotalLabel;
    }

    private JLabel initCustomerNameLabel() {
        if (customerNameLabel == null) {
            customerNameLabel = new JLabel();
            customerNameLabel.setText("Customer name");
        }
        return customerNameLabel;
    }

    private JLabel initInvDateLabel() {
        if (invDateLabel == null) {
            invDateLabel = new JLabel();
            invDateLabel.setText("Invoide Date");
        }
        return invDateLabel;
    }

    private JLabel initInvNumberLabel() {
        if (invNumberLabel == null) {
            invNumberLabel = new JLabel();
            invNumberLabel.setText("Invoice Number");
        }
        return invNumberLabel;
    }

    private JLabel initInvTotalLbl() {
        if (invTotalLbl == null) {
            invTotalLbl = new JLabel();
        }
        return invTotalLbl;
    }

    private JLabel initInvNumlabel() {
        if (invNumLbl == null) {
            invNumLbl = new JLabel();
        }
        return invNumLbl;
    }

    private JTextField initInvDateTF() {
        if (invDateTF == null) {
            invDateTF = new JTextField();
        }
        return invDateTF;
    }

    private JTextField initCustNameTF() {
        if (custNameTF == null) {
            custNameTF = new JTextField();
        }
        return custNameTF;
    }

    private JScrollPane initInvLinesTableScrollPane() {
        if (invLinesTableScrollPane == null) {
            invLinesTableScrollPane = new JScrollPane();
            invLinesTableScrollPane.setViewportView(initInvLinesTable());
        }
        return invLinesTableScrollPane;
    }

    private JScrollPane initInvoicesTableScrollPane() {
        if (invoicesTableScrollPane == null) {
            invoicesTableScrollPane = new JScrollPane();
            invoicesTableScrollPane.setViewportView(initInvoicesTable());
        }
        return invoicesTableScrollPane;
    }

    private JTable initInvoicesTable() {
        if (invoicesTable == null) {
            invoicesTable = new JTable();
            invoicesTable.setModel(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{}
            ));
        }
        return invoicesTable;
    }

    private JTable initInvLinesTable() {
        if (invLinesTable == null) {
            invLinesTable = new JTable();
            invLinesTable.setModel(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{}
            ));
        }
        return invLinesTable;
    }

    private JButton initApplyBtn() {
        if (applyChangesBtn == null) {
            applyChangesBtn = new JButton();
            applyChangesBtn.setText("save");
            applyChangesBtn.setActionCommand("ApplyChanges");
            applyChangesBtn.getAccessibleContext().setAccessibleName("Save");
            applyChangesBtn.getAccessibleContext().setAccessibleDescription("");
        }
        return applyChangesBtn;
    }

    private JButton initCancelBtn() {
        if (cancelBtn == null) {
            cancelBtn = new JButton();
            cancelBtn.setText("cancel");
            cancelBtn.setActionCommand("discard");
        }
        return cancelBtn;
    }

    private JButton initDeleteInvBtn() {
        if (deleteInvBtn == null) {
            deleteInvBtn = new JButton();
            deleteInvBtn.setText("Delete Invoice");
            deleteInvBtn.setActionCommand("DeleteInvoice");
        }
        return deleteInvBtn;
    }

    private JButton initCreateInvBtn() {
        if (createInvBtn == null) {
            createInvBtn = new JButton();
            createInvBtn.setText("Create New Invoice");
            createInvBtn.setActionCommand("CreateNewInvoice");
        }
        return createInvBtn;
    }

    public void setActionsListener(ActionListener actionListener) {
        saveMenuItem.addActionListener(actionListener);
        loadMenuItem.addActionListener(actionListener);
        applyChangesBtn.addActionListener(actionListener);
        cancelBtn.addActionListener(actionListener);
        deleteInvBtn.addActionListener(actionListener);
        createInvBtn.addActionListener(actionListener);
    }

    public void setInvoiceSelectionListener(ListSelectionListener listSelectionListener) {
        invoicesTable.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public void clearSelectedInvoice() {
        invoicesTable.clearSelection();
        invLinesTable.setModel(new InvoiceHeaderTableModel(new ArrayList<>()));
        custNameTF.setText("");
        invDateTF.setText("");
        invNumLbl.setText("");
        invTotalLbl.setText("");
    }

    public void updateInvoicesTable(InvoiceHeaderTableModel invoiceHeaderTableModel) {
        this.invoiceHeaderTableModel = invoiceHeaderTableModel;
        invoicesTable.setModel(invoiceHeaderTableModel);
        invoicesTable.validate();
    }

    public void loadSelectedInvoice() {
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

    public void deleteSelectedInvoice() {
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
    }

    public void deleteSelectedInvoiceLine() {
        int lineIndex = invLinesTable.getSelectedRow();
        InvoiceLine line = invoiceLinesTableModel.getInvoiceLines().get(lineIndex);
        invoiceLinesTableModel.getInvoiceLines().remove(lineIndex);
        invoiceLinesTableModel.fireTableDataChanged();
        invoiceHeaderTableModel.fireTableDataChanged();
        invTotalLbl.setText("" + line.getHeader().getInvTotal());
    }

    public int getSelectedInvoiceIndex() {
        return invoicesTable.getSelectedRow();
    }

    public void updateSelectedInvoiceTotalLabel(double invTotal) {
        invTotalLbl.setText("" + invTotal);
    }
}
