/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import salesinvoice.model.FileOperations;
import salesinvoice.model.InvoiceHeader;
import salesinvoice.model.InvoiceHeaderTable;
import salesinvoice.model.InvoiceLine;
import salesinvoice.model.InvoiceLineTable;
import salesinvoice.view.JFrame;
import salesinvoice.view.NewInvoiceHeader;
import salesinvoice.view.NewInvoiceLine;

public class Controller implements ActionListener , ListSelectionListener
{ 
    JFrame jf;
    public Controller(JFrame frame){
        this.jf=frame;
    }
    private FileOperations file = new FileOperations(jf) ; 
    private ArrayList<InvoiceHeader> invoiceHeaderArray;
    private InvoiceHeader header ;
    private NewInvoiceLine newInvoiceFrame;
    private NewInvoiceHeader newHeaderFrame;

    public void actionPerformed(ActionEvent e)
    {
        
        switch(e.getActionCommand())
        {
            case "Load File":
               invoiceHeaderArray = file.readFile();
               jf.setInvoiceHeaderArray(invoiceHeaderArray);
               jf.setTable(new InvoiceHeaderTable(jf.getInvoiceHeaderArray()));
               jf.getjTable1().setModel(jf.getTable());
               

                break;
            case "Save Data":
            {
                try {
                    file.writeFile(jf.getInvoiceHeaderArray());
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "Create New Invoice":
                createNewInvoice();
                break;
                case "okBtn":
                okBtn();
                break;
                case "cancelBtn":
                cancelBtn();
                break;
                
            case "Delete invoice":
                deleteInvoice();
                break;
            case "Save":
                {
                try {
                    file.writeFile(jf.getInvoiceHeaderArray());
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case "Create New Item":
                CreateItem();
                break;
                case "okBtnLine":
                okBtnLine();
                break;
                case "cancelBtnLine":
                cancelBtnLine();
                break;
            case "Cancel":
                cancel();
                break;
            default:
                break;
            
        }
    }
    public void createNewInvoice()
    {
        
        newHeaderFrame = new NewInvoiceHeader(jf);
        newHeaderFrame.setVisible(true);
        
    }
    public void deleteInvoice()
    {   
        int numberOfRow = jf.getjTable1().getSelectedRow();
        
        for (int i = 0; i < invoiceHeaderArray.size() ;i++) {
        
            if(i == numberOfRow )
            {
                for (int j = 0; j < invoiceHeaderArray.get(i).getItem().size(); j++) {
                    
                    invoiceHeaderArray.get(i).getItem().remove(j);
                }
                invoiceHeaderArray.remove(i);
                jf.getjLabel5().setText("");
                jf.getjLabel6().setText("");
                jf.getjLabel7().setText("");
                jf.getjLabel8().setText(""); 
                
               jf.getLineTable().setRowCount(0);
                break;
            }    
        }
       // jf.getjTable1().setModel(new InvoiceHeaderTable(invoiceHeaderArray));
        //jf.getjTable2().removeAll();
        jf.getTable().fireTableDataChanged();
        //jf.getLineTable().fireTableDataChanged();

       // jf.getjTable2().clearSelection();


    }
    public void cancel()
    {
        
    }

    /*@Override
    public void valueChanged(ListSelectionEvent e) {
        int numberOfRow = jf.getjTable1().getSelectedRow();
        if(numberOfRow >=0)
        {
            header = jf.getInvoiceHeaderArray().get(numberOfRow);
            jf.getjLabel5().setText(""+header.getNumber());
            jf.getjLabel6().setText(""+header.getDate());
            jf.getjLabel7().setText(""+header.getCustomer());
            jf.getjLabel8().setText(""+header.getTotal()); 
            jf.getjTable2().setModel(new InvoiceLineTable(header.getItem()));
          /*  InvoiceLineTable invoiceTable = new InvoiceLineTable(header.getItem());
            invoiceTable.setRowCount(header.getItem().size());
            jf.getjTable2().setModel(invoiceTable);
            jf.getjTable2().setModel(new InvoiceHeaderTable(invoiceHeaderArray));
        }
    }*/
     @Override
    public void valueChanged(ListSelectionEvent e) {
        int numberOfRow = jf.getjTable1().getSelectedRow();
        if(numberOfRow >=0)
        {
            header = jf.getInvoiceHeaderArray().get(numberOfRow);
            jf.getjLabel5().setText(""+header.getNumber());
            jf.getjLabel6().setText(""+header.getDate());
            jf.getjLabel7().setText(""+header.getCustomer());
            jf.getjLabel8().setText(""+header.getTotal());  
            //jf.getjTable2().setModel(new InvoiceLineTable(header.getItem()));
            InvoiceLineTable invoiceTable = new InvoiceLineTable(header.getItem());
          //  jf.setLineTable(new InvoiceLineTable(header.getItem()));
            invoiceTable.setRowCount(header.getItem().size());
            jf.getjTable2().setModel(invoiceTable);
            //jf.getjTable2().setModel(new InvoiceHeaderTable(invoiceHeaderArray));

           // jf.getjTable2().setModel(new InvoiceHeaderTable(invoiceHeaderArray));
        }
    }

    private void okBtn(){
        int num = 0 ; 
        String date =newHeaderFrame.getDateTxt().getText();
        String name = newHeaderFrame.getCustomerNameTxt().getText();
        newHeaderFrame.setVisible(false);
        newHeaderFrame.dispose();
        newHeaderFrame=null;
        for (int i = 0; i < header.getItem().size(); i++) {
            if(num<header.getItem().size())
                num = header.getItem().size();
        }
        InvoiceHeader header = new InvoiceHeader(++num,date,name);
        jf.getInvoiceHeaderArray().add(header);
        jf.getTable().fireTableDataChanged();
        
        
    }

    private void cancelBtn() {
        newHeaderFrame.setVisible(false);
        newHeaderFrame.dispose();
        newHeaderFrame=null;
    }

    private void okBtnLine() {
         int numberOfRow = jf.getjTable1().getSelectedRow();
        if(numberOfRow >=0)
        {
            header = jf.getInvoiceHeaderArray().get(numberOfRow);
        }
        int num = 0 ; 
        String itemName =newInvoiceFrame.getItamNameTxt().getText();
        String count = newInvoiceFrame.getItemCountTxt().getText();
        int d=Integer.parseInt(count);
         String price = newInvoiceFrame.getItemPricelTxt().getText();
         double p=Double.parseDouble(price);
        newInvoiceFrame.setVisible(false);
        newInvoiceFrame.dispose();
        newInvoiceFrame=null;
        for (int i = 0; i < header.getItem().size(); i++) {
            if(num<header.getNumber())
                num = header.getNumber();
        }
        InvoiceLine line = new InvoiceLine(++num,itemName,p,d);
        header.getItem().add(line);
        jf.setLineTable(new InvoiceLineTable(header.getItem()));
        jf.getTable().fireTableDataChanged();
        jf.getLineTable().fireTableDataChanged();
    }

    private void CreateItem() {
        newInvoiceFrame = new NewInvoiceLine(jf);
        newInvoiceFrame.setVisible(true);
    }

    private void cancelBtnLine() {
        newInvoiceFrame.setVisible(true);
        newInvoiceFrame.dispose();
        newInvoiceFrame=null;
    }
}
