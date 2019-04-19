import javax.swing.*;
import java.awt.*;

public class CustomerInfoView extends JFrame {

    JTextField txtAddr, txtPhone;
    JButton btnUpdate = new JButton("Update");
    JButton btnReturn = new JButton("Return");
    JPanel p;

    public CustomerInfoView() {
        this.setTitle("*** Update Customer Info ***");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
    }


    public void build(CustomerModel customer) {

        if (customer != null) {
            this.getContentPane().removeAll();
            p = new JPanel();
            p.setLayout(new GridLayout(4, 2, 25, 25));
            p.setBorder(BorderFactory.createEmptyBorder(50, 120, 40, 120));

            p.add(new JLabel("UserName", JLabel.TRAILING));
            p.add(new JLabel(String.valueOf(customer.userName)));

            p.add(new JLabel("Name", JLabel.TRAILING));
            p.add(new JLabel(String.valueOf(customer.name)));

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
            btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

            btnPanel.add(btnReturn);
            btnPanel.add(btnUpdate);
            this.getContentPane().add(btnPanel);
        }

    }
}
