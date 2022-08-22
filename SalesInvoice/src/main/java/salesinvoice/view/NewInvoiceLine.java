/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesinvoice.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewInvoiceLine extends JDialog {
    private javax.swing.JLabel itamNameLabel;
    private javax.swing.JLabel itemCountLabel;
    private javax.swing.JLabel itemPricelLabel;
    private javax.swing.JTextField itamNameTxt;
    private javax.swing.JTextField itemCountTxt;
    private javax.swing.JTextField itemPricelTxt;
    private javax.swing.JButton okBtn;
    private javax.swing.JButton cancelBtn;

    public JTextField getItamNameTxt() {
        return itamNameTxt;
    }

    public void setItamNameTxt(JTextField itamNameTxt) {
        this.itamNameTxt = itamNameTxt;
    }

    public JTextField getItemCountTxt() {
        return itemCountTxt;
    }

    public void setItemCountTxt(JTextField itemCountTxt) {
        this.itemCountTxt = itemCountTxt;
    }

    public JTextField getItemPricelTxt() {
        return itemPricelTxt;
    }

    public void setItemPricelTxt(JTextField itemPricelTxt) {
        this.itemPricelTxt = itemPricelTxt;
    }

    public NewInvoiceLine(JFrame frame) {
        super(frame);
        itamNameTxt = new JTextField(20);
        itamNameLabel = new JLabel("Item Name:");

        itemCountTxt = new JTextField(20);
        itemCountLabel = new JLabel("Item Count:");

        itemPricelTxt= new JTextField(20);
        itemPricelLabel = new JLabel("Item Price:");
        
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("okBtnLine");
        cancelBtn.setActionCommand("cancelBtnLine");
        okBtn.addActionListener(frame.getC());
        cancelBtn.addActionListener(frame.getC());
        setLayout (new GridLayout(4, 2));
      //  setLayout(new GridLayout(3,2));
        add(itamNameLabel);
        add(itamNameTxt);
        add(itemCountLabel);
        add(itemCountTxt);
        add(itemPricelLabel);
        add(itemPricelTxt);
        add(okBtn);
        add(cancelBtn);
        setModal(true);
        pack();


    }
    }
