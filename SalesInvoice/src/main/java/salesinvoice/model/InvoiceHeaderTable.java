/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceHeaderTable extends AbstractTableModel {
    ArrayList<InvoiceHeader> invoiceHeaderArray;
    private InvoiceHeader ih;
    private String[] columnName = {"No.","Date","Customer","Total"};
    public InvoiceHeaderTable(ArrayList<InvoiceHeader> invoiceHeaderArray) {
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
        ih=invoiceHeaderArray.get(rowIndex);
        if(columnIndex == 0)
          return ih.getNumber();
        else if(columnIndex == 1)
          return ih.getDate();
        else if(columnIndex == 2)
          return ih.getCustomer();
        else if(columnIndex == 3)
          return ih.getTotal();
        return "";
    }

    public String getColumnName(int column) {
        return columnName[column];
    }

    public void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }
    
}
