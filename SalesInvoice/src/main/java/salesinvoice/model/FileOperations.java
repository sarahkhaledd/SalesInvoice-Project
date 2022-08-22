/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import salesinvoice.view.JFrame;

/**
 *
 * @author DELL
 */
public class FileOperations {
//loadItem.addActionListener(c);
 //loadItem.setActionCommand("Load File");
 
    JFrame frame;
    
    public FileOperations(JFrame frame) {
        this.frame=frame;
    }
    //Load Files
    public ArrayList<InvoiceHeader> readFile()
    {
        ArrayList<InvoiceLine> itemsInvoiceLine = new ArrayList<>();
        JFileChooser jF = new JFileChooser();
        int result = jF.showOpenDialog(frame);
        BufferedReader reader = null;
        ArrayList<InvoiceHeader> invoiceHeaderArray = new ArrayList<>();
        InvoiceHeader ih =null ;
        if(result == JFileChooser.APPROVE_OPTION)
        {
            String pathFile = jF.getSelectedFile().getPath();
            try{
                reader = new BufferedReader(new FileReader(pathFile));
                String line = reader.readLine();
                while (line != null) {
                    String[] items  = line.split(",");
                    String num = items[0];
                    String date = items[1];
                    String name = items[2];
                   int number = Integer.parseInt(num);
                   ih= new InvoiceHeader(number,date,name);  
                   invoiceHeaderArray.add(ih);  
                   line = reader.readLine();
                   //frame.getInvoiceHeaderArray().add(ih);
		}
           }catch(FileNotFoundException e){
            }catch(IOException e){
            }
            finally{
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         jF = new JFileChooser();
        int file = jF.showOpenDialog(frame);
        ArrayList<InvoiceLine> invoiceLineArray = new ArrayList<>();
        InvoiceLine il =null ;
        if(file == JFileChooser.APPROVE_OPTION)
        {
            String pathFile = jF.getSelectedFile().getPath();
            try{
                reader = new BufferedReader(new FileReader(pathFile));
                String line = reader.readLine();
                while (line != null) {
                    String[] items  = line.split(",");
                    String num = items[0];
                    String itemName = items[1];
                    String itemPrice = items[2];
                    String count = items[3];
                   int number = Integer.parseInt(num);
                   double price = Double.parseDouble(itemPrice);
                   int c = Integer.parseInt(count);
                   InvoiceHeader header= frame.getNumberOfInvoice(number);
                   il= new InvoiceLine(header.getNumber(),itemName,price,c);  
                   invoiceLineArray.add(il);  
                   line = reader.readLine();
		}

           }catch(FileNotFoundException e){
            }catch(IOException e){
            }
            finally{
                try {
                    reader.close();
                    
                } 
                catch (IOException ex) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //itemsInvoiceLine
        for (int i = 0; i < invoiceHeaderArray.size(); i++) {
            for (int j = 0; j < invoiceLineArray.size(); j++) {
                if(invoiceHeaderArray.get(i).getNumber()== invoiceLineArray.get(j).getNumber())
                {
                    itemsInvoiceLine.add(invoiceLineArray.get(j));
                }
            }
           invoiceHeaderArray.get(i).setItem(itemsInvoiceLine);          
          itemsInvoiceLine = new ArrayList<>();
        } 
        return invoiceHeaderArray;
    }
    //Save Data
    public void writeFile(ArrayList<InvoiceHeader> item)
    {
       JFileChooser jF = new JFileChooser(); 
        if (jF.showSaveDialog(jF) == JFileChooser.APPROVE_OPTION) {
            String pathFile = jF.getSelectedFile().getPath();
            FileOutputStream fos = null;
            String x;
           try {
               fos = new FileOutputStream(pathFile);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
           }
           // byte[]array =ta.getText().getByte() ;
            //fos.write(array);
           finally{
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
        }
    }
}
class main{
    public static void main(String args[])  //static method  
    {  
        System.out.println("Static method"); 
        FileOperations f = null ; 
        f.readFile();
    }  
}
