import javax.swing.*;
import java.awt.*;

public class ManagerView extends JFrame {

    public JButton btnAdd, btnUpdate, btnExit;

    public ManagerView() {
        this.setTitle("Welcome. Dear Product Manager!");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,150,30,150));
        p.setLayout(new GridLayout(3,1,0, 30));

        btnAdd = new JButton("Add Product");
        btnUpdate = new JButton("Update Product");
        btnExit = new JButton("Exit");
        p.add(btnAdd);
        p.add(btnUpdate);
        p.add(btnExit);

        this.getContentPane().add(p);
    }
}
