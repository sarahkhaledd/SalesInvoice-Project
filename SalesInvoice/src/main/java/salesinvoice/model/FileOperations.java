/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.model;

import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author DELL
 */
public class FileOperations {
    //Load Files
    public ArrayList<InvoiceHeader> readFile()
    {
        JFileChooser jF = new JFileChooser();
        int dialog = jF.showOpenDialog(this);
        return null;
    }
    //Save Data
    public void writeFile(ArrayList<InvoiceHeader> item)
    {
        
    }
}
