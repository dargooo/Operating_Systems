import javax.swing.*;
import java.awt.*;

public class ProductView extends JFrame {

    public JTextField txtProductID = new JTextField(15);
    public JTextField txtProductName = new JTextField(15);
    public JTextField txtProductBarcode = new JTextField(15);
    public JTextField txtProductPrice = new JTextField(15);
    public JTextField txtProductQuantity = new JTextField(15);
    public JTextField txtProvider = new JTextField(15);
    public JTextField txtContact = new JTextField(15);

    public JButton btnCheck = new JButton("Check");
    public JButton btnCancel = new JButton("Cancel");
    public JButton btnSave = new JButton("Save");
    public JPanel line1;

    public ProductView() {

        this.setTitle("*** Product Information ***");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        line1 = new JPanel();
        line1.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        line1.add(new JLabel("Enter the Product ID: "));
        line1.add(txtProductID);
        line1.add(btnCheck);
        this.getContentPane().add(line1);

        //infos
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0,2,25,10));
        p.setBorder(BorderFactory.createEmptyBorder(20,150,20,150));
        p.add(new JLabel("Product Name", JLabel.TRAILING));
        p.add(txtProductName);
        p.add(new JLabel("Barcode", JLabel.TRAILING));
        p.add(txtProductBarcode);
        p.add(new JLabel("Available Quantity", JLabel.TRAILING));
        p.add(txtProductQuantity);
        p.add(new JLabel("Price per unit", JLabel.TRAILING));
        p.add(txtProductPrice);
        p.add(new JLabel("Provider", JLabel.TRAILING));
        p.add(txtProvider);
        p.add(new JLabel("Provider Contact", JLabel.TRAILING));
        p.add(txtContact);

        this.getContentPane().add(p);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);
    }

    public void clear() {
        txtProductBarcode.setText("");
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtContact.setText("");
        txtProductQuantity.setText("");
        txtProvider.setText("");
        txtProductID.setText("");
    }

}
