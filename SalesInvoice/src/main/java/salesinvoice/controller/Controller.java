/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
    private ArrayList<InvoiceHeader> invoiceHeaderArrayDeleted;
    private InvoiceHeader header ;
    private NewInvoiceLine newInvoiceFrame;
    private NewInvoiceHeader newHeaderFrame;
    private static int counter;
    public void actionPerformed(ActionEvent e)
    {
        
        switch(e.getActionCommand())
        {
            case "Load File":
               invoiceHeaderArray = file.readFile();
               jf.setInvoiceHeaderArray(invoiceHeaderArray);
               jf.setOldInvoiceHeader(invoiceHeaderArray);
               jf.setTable(new InvoiceHeaderTable(jf.getInvoiceHeaderArray()));
                for (int i = 0; i < jf.getInvoiceHeaderArray().size(); i++) {
                jf.setLineTable(new InvoiceLineTable(jf.getInvoiceHeaderArray().get(i).getItem()));
                }
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
                //Delete Item
                case "Delete Item":
                deleteItem();
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
       
               jf.getInvoiceHeaderArray().get(numberOfRow).getItem().clear();
            
          //  System.out.println("size"+jf.getInvoiceHeaderArray().get(numberOfRow).getItem().size());

         
             jf.getInvoiceHeaderArray().remove(numberOfRow);  
       
                //invoiceHeaderArrayDeleted.add(invoiceHeaderArray.get(i));
               
                jf.getjLabel5().setText("");
                jf.getjLabel6().setText("");
                jf.getjLabel7().setText("");
                jf.getjLabel8().setText(""); 
             //   jf.getLineTable().fireTableDataChanged();
       
        jf.getTable().fireTableDataChanged();

    }
    public void deleteItem()
    {
           int numberOfRow = jf.getjTable1().getSelectedRow();
           int numberOfRow2 = jf.getjTable2().getSelectedRow();
           jf.getInvoiceHeaderArray().get(numberOfRow).getItem().remove(numberOfRow2);
           jf.getLineTable().fireTableDataChanged();
    }
    public void cancel()
    {
        System.out.println("salesinvoice.controller.Controller.cancel()"+jf.getOldInvoiceHeader().size());
        for (int i = counter; i > 0; i--) {
            jf.getOldInvoiceHeader().remove(jf.getOldInvoiceHeader().size()-1);
            counter--;
        }
        for (int i = 0; i < invoiceHeaderArrayDeleted.size(); i++) {
            jf.getOldInvoiceHeader().add(invoiceHeaderArrayDeleted.get(i));
        }
            jf.getjLabel5().setText(""+header.getNumber());
            jf.getjLabel6().setText(""+header.getDate());
            jf.getjLabel7().setText(""+header.getCustomer());
            jf.getjLabel8().setText(""+header.getTotal()); 
        jf.getTable().fireTableDataChanged();

    }
    
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
            jf.getjTable2().setModel(new InvoiceLineTable(header.getItem()));
        }
    }

    private void okBtn(){
        counter++;
        int num = 0 ; 
        String date =newHeaderFrame.getDateTxt().getText();
        String name = newHeaderFrame.getCustomerNameTxt().getText();
        newHeaderFrame.setVisible(false);
        newHeaderFrame.dispose();
        newHeaderFrame=null;
        for (int i = 0; i < jf.getInvoiceHeaderArray().size(); i++) {
            if(num<jf.getInvoiceHeaderArray().get(i).getNumber())
                num = jf.getInvoiceHeaderArray().get(i).getNumber();
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
                num = jf.getInvoiceHeaderArray().get(numberOfRow).getNumber();
        
        InvoiceLine line = new InvoiceLine(num,itemName,p,d);
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
