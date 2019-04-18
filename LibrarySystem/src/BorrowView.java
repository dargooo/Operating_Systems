import javax.swing.*;
import java.awt.*;

public class BorrowView extends JFrame {
    public JTextField txtBookID = new JTextField(30);
    public JTextField txtReaderID = new JTextField(30);

    public JButton btnBorrow = new JButton("Borrow");
    public JButton btnExit = new JButton("Exit");

    public BorrowView() {

        this.setTitle("Borrow Book");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Book ID"));
        line1.add(txtBookID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Reader ID"));
        line2.add(txtReaderID);
        this.getContentPane().add(line2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnBorrow);
        buttonPanel.add(btnExit);

        this.getContentPane().add(buttonPanel);

    }
}
