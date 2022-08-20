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
    private Date invoiceDate ;
    private String customerName;
    private double total; 
    ArrayList<InvoiceLine> item ; // Create an ArrayList object

    public InvoiceHeader() {
     item= new ArrayList<InvoiceLine>();
    }
            
    public int getNumber() {
        return invoiceNum;
    }

    public void setNumber(int number) {
        this.invoiceNum = number;
    }

    public Date getDate() {
        return invoiceDate;
    }

    public void setDate(Date date) {
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
