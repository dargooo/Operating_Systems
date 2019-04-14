import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {


    LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginView.btnExit.addActionListener(this);
        loginView.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == loginView.btnLogin) {
            //check role and switch to view
        }
        if (e.getSource() == loginView.btnExit) {
            System.exit(1);
        }
    }

}
