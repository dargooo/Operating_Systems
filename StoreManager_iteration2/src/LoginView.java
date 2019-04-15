import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JButton btnLogin, btnExit;
    public JTextField txtId, txtPassword;

    public LoginView() {
        this.setTitle("*** Store Management System ***");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        //2 rows
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2,25,40));
        p.setBorder(BorderFactory.createEmptyBorder(80,100,80,150));

        p.add(new JLabel("User Name", JLabel.TRAILING));
        txtId = new JTextField(15);
        p.add(txtId);

        p.add(new JLabel("Password", JLabel.TRAILING));
        txtPassword = new JTextField(15);
        p.add(txtPassword);

        this.getContentPane().add(p);

        //buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,60,0));
        btnExit = new JButton("Exit");
        btnPanel.add(btnExit);
        btnLogin = new JButton("Login");
        btnPanel.add(btnLogin);

        this.getContentPane().add(btnPanel);
    }

    public void clear() {
        txtId.setText("");
        txtPassword.setText("");
    }

}
