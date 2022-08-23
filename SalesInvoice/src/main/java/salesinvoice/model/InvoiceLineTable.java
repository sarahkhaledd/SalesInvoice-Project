
package salesinvoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceLineTable extends AbstractTableModel {
    ArrayList<InvoiceLine> invoicelineArray;
    private InvoiceLine il;
     int z ;

    private String[] columnName ={};

    public InvoiceLineTable(ArrayList<InvoiceLine> invoicelineArray) {
        this.invoicelineArray = invoicelineArray;
    }
   public void setRowCount(int x ) {
        if(x==0)
        {
            z=x;
            columnName=new String[]{};
        }
        else
        {
            z=invoicelineArray.size();
            columnName = new String[]{"No.","Item Name","Item Price","Count","Item Total"};
        }
    }
    @Override
    public int getRowCount() {
        return z;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        il=invoicelineArray.get(rowIndex);
        if(columnIndex == 0)
          return il.getNumber();
        else if(columnIndex == 1)
          return il.getItemName();
        else if(columnIndex == 2)
          return il.getItemPrice();
        else if(columnIndex == 3)
          return il.getCount();
        else if(columnIndex == 4)
          return il.getItemTotal();
        return "";
    }
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }
 
}
