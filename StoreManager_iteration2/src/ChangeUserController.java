import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class ChangeUserController implements ActionListener {

    ChangeUserView cView;
    RemoteDataAccess db;

    public ChangeUserController(ChangeUserView view, RemoteDataAccess da) {
        cView = view;
        this.db = da;
        cView.btnCancel.addActionListener(this);
        cView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cView.btnSave) {
            saveUser();
        }

        if (e.getSource() == cView.btnCancel) {
            Application.adminView.show();
            Application.changeUserView.setVisible(false);
            Application.changeUserView.clear();
        }

    }


    private void saveUser() {
        //user name exist?
        String userName = cView.txtUserName.getText();
        UserModel user = db.findUser(userName);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "User name doesn't exist!");
            return;
        }
        //old password is correct?
        String password = cView.txtPasswordOld.getText();
        if (!user.password.equals(password)) {
            JOptionPane.showMessageDialog(null, "Old password isn't correct!");
            return;
        }
        //new passwords match?
        String password1 = cView.txtPassword1.getText(), password2 = cView.txtPassword2.getText();
        if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(null, "New passwords doesn't match!");
            return;
        }
        //save
        try {
            user.password = password1;
            db.saveUser(user);
            JOptionPane.showMessageDialog(null, "Password changed successfully!");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for user!");
            ex.printStackTrace();
        }

    }


}
