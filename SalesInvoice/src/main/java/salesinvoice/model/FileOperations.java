/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
                   // header= frame.getNumberOfInvoice(number);
                   il= new InvoiceLine(number,itemName,price,c);  
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
    public void writeFile(ArrayList<InvoiceHeader> item) throws IOException
    {
        FileWriter fileLine ;
        BufferedWriter bufferLineFile = null ;
        FileWriter fileHeader ;
        BufferedWriter bufferHeaderFile =null;
       JFileChooser jF = new JFileChooser(); 
        if (jF.showSaveDialog(jF) == JFileChooser.APPROVE_OPTION) {
            String pathFileHeader = jF.getSelectedFile().getPath();
           try {
               fileHeader = new FileWriter(pathFileHeader, true);
               bufferHeaderFile = new BufferedWriter(fileHeader);

           } catch (FileNotFoundException ex) {
               Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
           }
        } 
        jF = new JFileChooser(); 
        if (jF.showSaveDialog(jF) == JFileChooser.APPROVE_OPTION) {
            String pathFileLine = jF.getSelectedFile().getPath();
            
           try {
               fileLine = new FileWriter(pathFileLine, true);
               bufferLineFile = new BufferedWriter(fileLine);

           } catch (FileNotFoundException ex) {
               Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
           }
        } 
        String dataOfHeader = "";
        String dataOfLine = "";
        for (int i = 0; i < item.size(); i++) {
            if(item.size()-1!=i)
            {
                dataOfHeader+=item.get(i).getNumber()+","+item.get(i).getDate()+","+item.get(i).getCustomer()+'\n';
                for (int j = 0; j < item.get(i).getItem().size(); j++) {
                    dataOfLine+=item.get(i).getItem().get(j).getNumber()+","+item.get(i).getItem().get(j).getItemName()
                      +","+item.get(i).getItem().get(j).getItemPrice()
                      +","+item.get(i).getItem().get(j).getCount()+'\n';
            }

            }
            else
            {
               dataOfHeader+=item.get(i).getNumber()+","+item.get(i).getDate()+","+item.get(i).getCustomer();
               for (int j = 0; j < item.get(i).getItem().size(); j++) {
                if(item.get(i).getItem().size()-1!=j)
              dataOfLine+=item.get(i).getItem().get(j).getNumber()+","+item.get(i).getItem().get(j).getItemName()
                      +","+item.get(i).getItem().get(j).getItemPrice()
                      +","+item.get(i).getItem().get(j).getCount()+'\n';
                else
                    dataOfLine+=item.get(i).getItem().get(j).getNumber()+","+item.get(i).getItem().get(j).getItemName()
                      +","+item.get(i).getItem().get(j).getItemPrice()
                      +","+item.get(i).getItem().get(j).getCount();
            }

            }

        }
        bufferHeaderFile.write(dataOfHeader);
        bufferLineFile.write(dataOfLine);
        bufferHeaderFile.close();
        bufferLineFile.close();
    }
    
}
class main{
    public static void main(String[]arg)
    {
        FileOperations file = null;
        ArrayList<InvoiceHeader> h = file.readFile();
        for(int i = 0;i<h.size();i++)
            {
                System.out.println("Invoice "+h.get(i).getNumber()+"\n" +
                        "{\n"+ "  "+h.get(i).getDate()+", "
                        +h.get(i).getCustomer());

                for(int j = 0;j<h.get(i).getItem().size();j++)
                {
                    System.out.println("Invoice"+h.get(i).getItem().get(j).getItemName()+", "
                            +h.get(i).getItem().get(j).getItemPrice() +", "
                            +h.get(i).getItem().get(j).getCount());
                }

                System.out.println("}\n");


            }
        
    }
}
