import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    DataAdapter db;
    LoginView loginView;

    public LoginController(LoginView loginView, DataAdapter db) {
        this.loginView = loginView;
        loginView.btnExit.addActionListener(this);
        loginView.btnLogin.addActionListener(this);
        this.db = db;
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == loginView.btnLogin) {
            login();
        }
        if (e.getSource() == loginView.btnExit) {
            System.exit(1);
        }
    }

    public void login() {
        try {
            String userName = loginView.txtId.getText();
            String password = loginView.txtPassword.getText();
            UserModel user = db.findUser(userName);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "User Name doesn't exist!");
                return;
            }
            if (!user.password.equals(password)) {
                JOptionPane.showMessageDialog(null, "Password isn't correct!");
                return;
            }
            //admin
            if (user.role.equals("admin")) {
                Application.adminView.show();
                Application.loginView.dispose();
                Application.loginView.clear();
                System.out.println("admin login");
            }
            //manager
            if (user.role.equals("manager")) {
                Application.managerView.show();
                Application.loginView.dispose();
                Application.loginView.clear();
                System.out.println("manager login");
            }
            //cashier
            if (user.role.equals("cashier")) {
                Application.cashierView.show();
                Application.loginView.dispose();
                Application.loginView.clear();
                System.out.println("cashier login");
            }
            //customer
            if (user.role.equals("customer")) {
                CustomerModel customer = db.findCustomer(user.userId);
                Application.customerView.show();
                Application.customerController = new CustomerController(Application.customerView, customer);
                Application.loginView.dispose();
                Application.loginView.clear();
                System.out.println("customer login");
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
