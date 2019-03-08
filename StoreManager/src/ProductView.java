import javax.swing.*;
import java.awt.*;

public class ProductView extends JFrame {

    public JTextField txtProductID = new JTextField(10);
    public JTextField txtProductName = new JTextField(30);
    public JTextField txtProductBarcode = new JTextField(30);
    public JTextField txtProductPrice = new JTextField(30);
    public JTextField txtProductQuantity = new JTextField(30);
    public JTextField txtProvider = new JTextField(30);
    public JTextField txtContact = new JTextField(30);

    public JButton btnCheck = new JButton("Check");
    public JButton btnCancel = new JButton("Cancel");
    public JButton btnSave = new JButton("Save");
    public JPanel line1;
    public JLabel checkLabel;

    public ProductView() {

        this.setTitle("Product Information");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        line1 = new JPanel();
        line1.add(new JLabel("Enter the Product ID: "));
        line1.add(txtProductID);
        line1.add(btnCheck);
        checkLabel = new JLabel("");
        line1.add(checkLabel);
        this.getContentPane().add(line1);


        JPanel line2 = new JPanel();
        line2.add(new JLabel("Product Name"));
        line2.add(txtProductName);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Barcode"));
        line3.add(txtProductBarcode);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Available Quantity"));
        line4.add(txtProductQuantity);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line5.add(new JLabel("Price per unit"));
        line5.add(txtProductPrice);
        this.getContentPane().add(line5);

        JPanel line6 = new JPanel();
        line6.add(new JLabel("Provider"));
        line6.add(txtProvider);
        this.getContentPane().add(line6);

        JPanel line7 = new JPanel();
        line7.add(new JLabel("Provider Contact"));
        line7.add(txtContact);
        this.getContentPane().add(line7);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);

    }

}
