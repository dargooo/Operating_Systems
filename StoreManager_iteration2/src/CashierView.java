import javax.swing.*;
import java.awt.*;

public class CashierView extends JFrame {
    public JButton btnCheckout, btnReturn, btnExit;

    public CashierView() {
        this.setTitle("Welcome. Dear Cashier!");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,150,30,150));
        p.setLayout(new GridLayout(3,1,0, 30));

        btnCheckout = new JButton("Check Out");
        btnReturn = new JButton("Return Product");
        btnExit = new JButton("Exit");
        p.add(btnCheckout);
        p.add(btnReturn);
        p.add(btnExit);

        this.getContentPane().add(p);
    }
}
