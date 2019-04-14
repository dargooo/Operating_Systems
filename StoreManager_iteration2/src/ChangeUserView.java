import javax.swing.*;
import java.awt.*;

public class ChangeUserView extends JFrame {

    public JTextField txtUserName = new JTextField(15);
    public JTextField txtPasswordOld = new JTextField(15);
    public JTextField txtPassword1 = new JTextField(15);
    public JTextField txtPassword2 = new JTextField(15);

    public JButton btnCancel = new JButton("Cancel");
    public JButton btnSave = new JButton("Save");

    public ChangeUserView() {

        this.setTitle("*** Add a New User ***");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        //infos
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0,2,25,10));
        p.setBorder(BorderFactory.createEmptyBorder(20,150,20,150));
        p.add(new JLabel("User Name", JLabel.TRAILING));
        p.add(txtUserName);
        p.add(new JLabel("Old Password", JLabel.TRAILING));
        p.add(txtPasswordOld);
        p.add(new JLabel("New Password", JLabel.TRAILING));
        p.add(txtPassword1);
        p.add(new JLabel("Re-enter New Password", JLabel.TRAILING));
        p.add(txtPassword2);

        this.getContentPane().add(p);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);
    }

    public void clear() {
        txtPassword1.setText("");
        txtPassword2.setText("");
        txtUserName.setText("");
        txtPasswordOld.setText("");
    }

}
