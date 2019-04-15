import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements ActionListener {

    AdminView adminView;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;
        adminView.btnExit.addActionListener(this);
        adminView.btnChange.addActionListener(this);
        adminView.btnAdd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminView.btnAdd) {
            Application.addUserView.show();
            Application.adminView.dispose();
        }
        if (e.getSource() == adminView.btnChange) {
            Application.changeUserView.show();
            Application.adminView.dispose();
        }
        if (e.getSource() == adminView.btnExit) {
            Application.loginView.show();
            Application.adminView.dispose();
        }
    }
}