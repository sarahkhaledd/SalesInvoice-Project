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
public class InvoiceTable {
    private int number ;
    private Date date ;
    private String customer;
    private double total; 
    ArrayList<InvoiceItem> item ; // Create an ArrayList object

    public InvoiceTable() {
     item= new ArrayList<InvoiceItem>();
    }
            
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotal() {
        double result=0.0 ;
        for (int i = 0; i < item.size(); i++){
                  }
        
        return result;
    }

    public void setTotal(double total) {
        this.total = total;
        
    }
    
}
