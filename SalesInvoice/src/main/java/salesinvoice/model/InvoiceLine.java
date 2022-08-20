/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class InvoiceLine extends InvoiceHeader  {
    private int number ;
    private String itemName;
    private double itemPrice;
    private int count;
    private double itemTotal ; 

    public InvoiceLine() {
        
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getItemTotal() {
        return itemTotal * itemPrice ;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }
    
    
}
