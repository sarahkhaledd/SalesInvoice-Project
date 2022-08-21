/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import salesinvoice.model.FileOperations;
import salesinvoice.view.JFrame;

/**
 *
 * @author DELL
 */
public class Controller implements ActionListener
{ 
    JFrame jf;
    public Controller(JFrame frame){
        this.jf=frame;
    }
    FileOperations file = new FileOperations(this.jf) ; 
    public void actionPerformed(ActionEvent e)
    {
        
        switch(e.getActionCommand())
        {
            case "Load File":
                file.readFile();
                break;
            case "Save Data":
                file.writeFile(null);
                break;
            case "Create new invoice":
                createNewInvoice();
                break;
            case "Delete invoice":
                deleteInvoice();
                break;
            case "Save":
                save();
                break;
            case "Cancel":
                cancel();
                break;
            default:
                break;
            
        }
    }
    public void createNewInvoice()
    {
        
    }
    public void deleteInvoice()
    {
        
    }
    public void save()
    {
        
    }
    public void cancel()
    {
        
    }
}
