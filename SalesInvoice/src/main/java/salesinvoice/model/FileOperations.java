/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author DELL
 */
public class FileOperations {
    //Load Files
    public void readFile()
    {
        JFileChooser jF = new JFileChooser();
        int result = jF.showOpenDialog(jF);
        FileInputStream fis = null;
        if(result == JFileChooser.APPROVE_OPTION)
        {
            String pathFile = jF.getSelectedFile().getPath();
            try{
                fis = new FileInputStream(pathFile);
                int size = fis.available();
                byte[]array = new byte[size];
                fis.read(array);
                String[] items = new String(array).split(",");
                System.out.println("salesinvoice.model.FileOperations.readFile()");
                System.out.println(items[0]);
            }catch(FileNotFoundException e){
            }catch(IOException e){
            }
            finally{
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       // return null;
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
