import javax.swing.*;
import java.awt.*;

public class CustomerInfoView extends JFrame {

    JTextField txtUserName, txtAddr, txtPhone;
    JButton btnUpdate, btnReturn;

    public CustomerInfoView(CustomerModel customer) {
        this.setTitle("*** Update Customer Info ***");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,2,25,18));
        p.setBorder(BorderFactory.createEmptyBorder(40,120,30,120));

        p.add(new JLabel("User ID", JLabel.TRAILING));
        p.add(new JLabel(String.valueOf(customer.userId)));
        p.add(new JLabel("Name", JLabel.TRAILING));
        p.add(new JLabel(String.valueOf(customer.name)));
        p.add(new JLabel("User Name", JLabel.TRAILING));
        txtUserName = new JTextField(15);
        txtUserName.setText(customer.userName);
        p.add(txtUserName);
        p.add(new JLabel("Address", JLabel.TRAILING));
        txtAddr = new JTextField(15);
        txtAddr.setText(customer.addr);
        p.add(txtAddr);
        p.add(new JLabel("Phone", JLabel.TRAILING));
        txtPhone = new JTextField(15);
        txtPhone.setText(String.valueOf(customer.phone));
        p.add(txtPhone);
        this.getContentPane().add(p);

        JPanel btnPanel = new JPanel();
        //btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        btnUpdate = new JButton("Update");
        btnReturn = new JButton("Return");
        btnPanel.add(btnReturn);
        btnPanel.add(btnUpdate);
        this.getContentPane().add(btnPanel);
    }


}
