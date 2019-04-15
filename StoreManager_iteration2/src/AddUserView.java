import javax.swing.*;
import java.awt.*;

public class AddUserView extends JFrame {

    public JTextField txtUserName = new JTextField(15);
    public JTextField txtRole = new JTextField(15);
    public JTextField txtName = new JTextField(15);
    public JTextField txtPassword1 = new JTextField(15);
    public JTextField txtPassword2 = new JTextField(15);

    public JButton btnCancel = new JButton("Cancel");
    public JButton btnSave = new JButton("Save");

    public AddUserView() {

        this.setTitle("*** Add a New User ***");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        //infos
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,2,25,20));
        p.setBorder(BorderFactory.createEmptyBorder(40,120,30,120));
        p.add(new JLabel("Name", JLabel.TRAILING));
        p.add(txtName);
        p.add(new JLabel("Role", JLabel.TRAILING));
        p.add(txtRole);
        p.add(new JLabel("User Name", JLabel.TRAILING));
        p.add(txtUserName);
        p.add(new JLabel("Password", JLabel.TRAILING));
        p.add(txtPassword1);
        p.add(new JLabel("Re-enter Password", JLabel.TRAILING));
        p.add(txtPassword2);

        this.getContentPane().add(p);

        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);
    }

    public void clear() {
        txtPassword1.setText("");
        txtPassword2.setText("");
        txtUserName.setText("");
        txtRole.setText("");
        txtName.setText("");
    }

}
