import javax.swing.*;
import java.awt.*;

public class RecordView extends JFrame {



    public JTextField txtBookID = new JTextField(8);
    public JTextField txtReaderID = new JTextField(8);

    public JButton btnBook = new JButton("Search by Book ID");
    public JButton btnReader = new JButton("Search by Reader ID");
    public JButton btnExit = new JButton("Exit");

    public RecordView() {


            this.setTitle("Load Record");
            this.setSize(new Dimension(600, 400));
            this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

            JPanel line1 = new JPanel();
            line1.add(new JLabel("Book ID"));
            line1.add(txtBookID);
            line1.add(btnBook);
            this.getContentPane().add(line1);

            JPanel line2 = new JPanel();
            line2.add(new JLabel("Reader ID"));
            line2.add(txtReaderID);
            line2.add(btnReader);
            this.getContentPane().add(line2);

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(btnExit);
            this.getContentPane().add(buttonPanel);

    }

}
