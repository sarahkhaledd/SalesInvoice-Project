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

/**
 *
 * @author DELL
 */
public class NewInvoiceHeader extends JDialog {

    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JTextField DateTxt;
    private javax.swing.JTextField customerNameTxt;
    private javax.swing.JButton okBtn;
    private javax.swing.JButton cancelBtn;

    public JTextField getDateTxt() {
        return DateTxt;
    }

    public void setDateTxt(JTextField DateTxt) {
        this.DateTxt = DateTxt;
    }

    public JTextField getCustomerNameTxt() {
        return customerNameTxt;
    }

    public void setCustomerNameTxt(JTextField customerNameTxt) {
        this.customerNameTxt = customerNameTxt;
    }
    
    public NewInvoiceHeader(JFrame frame) {
        DateLabel = new JLabel("Invoice Date:");
        customerNameLabel = new JLabel("Customer Name:");
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        DateTxt = new JTextField(20);
        customerNameTxt = new JTextField(20);
        okBtn.setActionCommand("okBtn");
        cancelBtn.setActionCommand("cancelBtn");
        okBtn.addActionListener(frame.getC());
        cancelBtn.addActionListener(frame.getC());
        setLayout (new GridLayout(3, 2));
      //  setLayout(new GridLayout(3,2));
      add(DateLabel);
      add(DateTxt);
      add(customerNameLabel);
      add(customerNameTxt);
      add(okBtn);
      add(cancelBtn);
      setModal(true);




    }
    
}
