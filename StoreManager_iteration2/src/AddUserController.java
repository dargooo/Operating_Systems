import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class AddUserController implements ActionListener {

    AddUserView aView;
    RemoteDataAccess db;

    public AddUserController(AddUserView view, RemoteDataAccess da) {
        aView = view;
        this.db = da;
        aView.btnCancel.addActionListener(this);
        aView.btnSave.addActionListener(this);
        aView.roleCombo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == aView.btnSave) {
            addUser();
        }

        if (e.getSource() == aView.btnCancel) {
            Application.adminView.show();
            Application.addUserView.setVisible(false);
            Application.addUserView.clear();
        }

    }


    public void addUser() {
        UserModel user = new UserModel();

        try {
            user.userName = aView.txtUserName.getText();
            user.role = aView.roleCombo.getSelectedItem().toString();
            user.password = aView.txtPassword1.getText();
            user.name = aView.txtName.getText();

            if (user.userName.equals("") || user.role.equals("") || user.password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all the blanks!");
                return;
            }

            if (db.findUser(user.userName) != null) {
                JOptionPane.showMessageDialog(null, "User Name already exists!");
                return;
            }

            if (!user.password.equals(aView.txtPassword2.getText())) {
                JOptionPane.showMessageDialog(null, "Passwords don't match!");
                return;
            }

            db.saveUser(user);
            JOptionPane.showMessageDialog(null, "User added successfully!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for User");
            ex.printStackTrace();
        }
    }


}
