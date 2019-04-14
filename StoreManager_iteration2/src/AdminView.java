import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame
{
    public JButton btnAdd, btnChange, btnExit;

    public AdminView() {
        this.setTitle("Welcome. Dear Administrator!");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,150,30,150));
        p.setLayout(new GridLayout(3,1,0, 30));

        btnAdd = new JButton("Add New User");
        btnChange = new JButton("Change Password");
        btnExit = new JButton("Exit");
        p.add(btnAdd);
        p.add(btnChange);
        p.add(btnExit);

        this.getContentPane().add(p);
    }
}
