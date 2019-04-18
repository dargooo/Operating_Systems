import javax.swing.*;
import java.awt.*;

public class BookView extends JFrame {

    public JTextField txtBookID = new JTextField(30);
    public JTextField txtTitle = new JTextField(30);
    public JTextField txtAuthor = new JTextField(30);
    public JTextField txtPages = new JTextField(30);
    public JTextField txtPublicationYear = new JTextField(30);

    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");
    public JButton btnExit = new JButton("Exit");

    public BookView() {

        this.setTitle("Book View");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Book ID"));
        line1.add(txtBookID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Book Title"));
        line2.add(txtTitle);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Author"));
        line3.add(txtAuthor);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Number of Pages"));
        line4.add(txtPages);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line5.add(new JLabel("Publication Year"));
        line5.add(txtPublicationYear);
        this.getContentPane().add(line5);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnExit);

        this.getContentPane().add(buttonPanel);

    }

}
