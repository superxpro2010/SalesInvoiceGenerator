/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udacity.controller;

import com.udacity.exceptions.ValidationException;
import com.udacity.model.InvoiceHeader;
import com.udacity.model.InvoiceHeaderTableModel;
import com.udacity.model.InvoiceLine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mohab
 */
public class FileOperations {

    private static DateFormat df;

    static {
        df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
    }

    public static List<InvoiceHeader> loadFiles(File headerFile, File linesFile) throws ValidationException {
        List<InvoiceHeader> invoicesList = new ArrayList<>();

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
                    InvoiceHeader header = findInvoiceByNum(invoicesList, invNum);
                    InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                    header.getLines().add(invLine);
                } catch (Exception ex) {
                    throw new ValidationException("Invalid Format Excption");
                }
            }

            System.out.println("Check");
        } catch (FileNotFoundException ex) {
            throw new ValidationException("File Not Found Excption");
        } catch (IOException ex) {
            throw new ValidationException("Invalid Format Excption");
        }
        return invoicesList;
    }

    public static void saveData(List<InvoiceHeader> invoicesList, File headerFile, File linesFile) throws IOException {
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
        FileWriter hFW = new FileWriter(headerFile);
        hFW.write(headers);
        hFW.flush();
        hFW.close();

        FileWriter lFW = new FileWriter(linesFile);
        lFW.write(lines);
        lFW.flush();
        lFW.close();
    }

    private static InvoiceHeader findInvoiceByNum(List<InvoiceHeader> invoicesList, int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : invoicesList) {
            if (invNum == inv.getInvNum()) {
                header = inv;
                break;
            }
        }
        return header;
    }

}
