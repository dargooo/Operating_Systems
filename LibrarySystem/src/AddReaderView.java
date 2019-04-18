import javax.swing.*;
import java.awt.*;

public class AddReaderView extends JFrame{

    public JTextField txtReaderID = new JTextField(30);
    public JTextField txtName = new JTextField(30);
    public JTextField txtAddr = new JTextField(30);
    public JTextField txtPhone = new JTextField(30);

    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");
    public JButton btnExit = new JButton("Exit");

    public AddReaderView() {

        this.setTitle("Add a New Reader");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Reader ID"));
        line1.add(txtReaderID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Reader Name"));
        line2.add(txtName);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Address"));
        line3.add(txtAddr);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Phone"));
        line4.add(txtPhone);
        this.getContentPane().add(line4);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnExit);

        this.getContentPane().add(buttonPanel);

    }

}
