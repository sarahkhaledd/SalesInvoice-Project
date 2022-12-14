/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class InvoiceHeader  {
    private int invoiceNum ;
    private String invoiceDate ;
    private String customerName;
    private double total; 
    ArrayList<InvoiceLine> item = new ArrayList<InvoiceLine>() ; // Create an ArrayList object

    public ArrayList<InvoiceLine> getItem() {
        return item;
    }

    public void setItem(ArrayList<InvoiceLine> item) {
        this.item = item;
    }

    public InvoiceHeader() {
    // item= new ArrayList<InvoiceLine>();
    }
    public InvoiceHeader(int num,String date,String name) {
        this.invoiceNum=num;
        this.invoiceDate=date;
        this.customerName=name;
    }
            
    public int getNumber() {
        return invoiceNum;
    }

    public void setNumber(int number) {
        this.invoiceNum = number;
    }

    public String getDate() {
        return invoiceDate;
    }

    public void setDate(String date) {
        this.invoiceDate = date;
    }

    public String getCustomer() {
        return customerName;
    }

    public void setCustomer(String customer) {
        this.customerName = customer;
    }

    public double getTotal() {
        double result=0.0 ;
        for (int i = 0; i < item.size(); i++){
           result+=item.get(i).getItemTotal();
    }
        return result;
    }

    public void setTotal(double total) {
        this.total = total;
        
    }
    
}
