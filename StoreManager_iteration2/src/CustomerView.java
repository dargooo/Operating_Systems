import javax.swing.*;
import java.awt.*;

public class CustomerView extends JFrame {

    public JButton btnInfo, btnStatus, btnExit;

    public CustomerView() {
        this.setTitle("Welcome. Dear Customer!");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,150,30,150));
        p.setLayout(new GridLayout(3,1,0, 30));

        btnInfo = new JButton("Update Info");
        btnStatus = new JButton("View Status");
        btnExit = new JButton("Exit");
        p.add(btnInfo);
        p.add(btnStatus);
        p.add(btnExit);

        this.getContentPane().add(p);
    }
}
