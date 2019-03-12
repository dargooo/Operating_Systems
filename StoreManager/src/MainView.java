import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public JButton btnAdd, btnUpdate, btnCheckout, btnOrder;

    public MainView() {
        this.setTitle("*** Store Management System ***");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,120,30,120));
        p.setLayout(new GridLayout(4,1,0, 10));

        btnCheckout = new JButton("Check Out");
        p.add(btnCheckout);

        btnAdd = new JButton("Add Product");
        p.add(btnAdd);

        btnUpdate = new JButton("Update Product");
        p.add(btnUpdate);

        btnOrder = new JButton("Search Order");
        p.add(btnOrder);

        this.getContentPane().add(p);
    }
}
