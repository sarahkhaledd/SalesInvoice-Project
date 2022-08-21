/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceTable extends AbstractTableModel {
        ArrayList<InvoiceHeader> invoiceHeaderArray;
    private InvoiceHeader il;
    private String[] columnName = {"No.","Item Name","Item Price","Count","Item Total"};
    public InvoiceTable(ArrayList<InvoiceHeader> invoiceHeaderArray) {
         this.invoiceHeaderArray=invoiceHeaderArray;
    }

    @Override
    public int getRowCount() {
        return invoiceHeaderArray.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        il=invoiceHeaderArray.get(rowIndex);
        if(columnIndex == 0)
          return il.getNumber();
        else if(columnIndex == 1)
          return il.getDate();
        else if(columnIndex == 2)
          return il.getCustomer();
        else if(columnIndex == 3)
          return il.getTotal();
        return "";
    }
    
}
