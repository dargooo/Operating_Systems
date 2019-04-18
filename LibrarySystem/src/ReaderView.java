import javax.swing.*;
import java.awt.*;

public class ReaderView extends JFrame {

    public JButton btnBorrow, btnInfo, btnSaveReader, btnRecord, btnExit;

    public ReaderView() {
        this.setTitle("Welcome. Dear Reader!");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(80,80,80,80));
        p.setLayout(new GridLayout(2,2,30, 30));

        btnBorrow = new JButton("Borrow a Book");
        btnInfo = new JButton("Load/Save Book");
        btnSaveReader = new JButton("Load/Save Reader");
        btnRecord = new JButton("Load Borrow Record");
        //btnExit = new JButton("Exit");

        p.add(btnInfo);
        p.add(btnSaveReader);
        p.add(btnBorrow);
        p.add(btnRecord);
        //p.add(btnExit);

        this.getContentPane().add(p);
    }
}
