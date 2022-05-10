package com.udacity;

import com.udacity.controller.InvoiceController;
import com.udacity.view.InvoiceFrame;

public class SalesInvoice {
    public static void main(String[] args)
    {
        InvoiceFrame view = new InvoiceFrame();
        InvoiceController controller = new InvoiceController(view);
        controller.init();
    }
}
