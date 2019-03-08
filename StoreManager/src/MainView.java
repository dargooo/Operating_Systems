import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public JButton btnAdd, btnUpdate, btnCheckout;

    public MainView() {
        this.setTitle("Store Management System");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        btnCheckout = new JButton("Check Out");
        JPanel line1 = new JPanel();
        line1.add(btnCheckout);
        this.getContentPane().add(line1);

        btnAdd = new JButton("Add Product");
        JPanel line2 = new JPanel();
        line2.add(btnAdd);
        this.getContentPane().add(line2);

        btnUpdate = new JButton("Update Product");
        JPanel line3 = new JPanel();
        line3.add(btnUpdate);
        this.getContentPane().add(line3);
    }
}
